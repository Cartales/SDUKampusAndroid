package com.example.zulkuf.sdukampus.fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zulkuf.sdukampus.NewScreen;
import com.example.zulkuf.sdukampus.R;
import com.example.zulkuf.sdukampus.data.Channel;
import com.example.zulkuf.sdukampus.data.Metric;
import com.example.zulkuf.sdukampus.data.News;
import com.example.zulkuf.sdukampus.service.WeatherServiceCallback;
import com.example.zulkuf.sdukampus.service.WeatherService;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.List;

/**
 * Created by zulkuf on 07/03/17.
 */

public class MainMenuFragment extends Fragment implements WeatherServiceCallback {
    //News
    private String TAG = NewScreen.class.getSimpleName();
    private Context mContext;

    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private MyNewsListAdapter myNewsListAdapter;


    private List<News> mNewsList;



    //Weather
    private ImageView weatherImageIcon;
    private  TextView temperature;
    private  TextView weatherText;
    private  TextView location;
    private RelativeLayout weather;

    private WeatherService service;
    private ProgressDialog dialog;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        //Ekran oluşturulur.
        View view = inflater.inflate(R.layout.mainmenu_fragment, container, false);
        mContext = container.getContext();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Componentler çağırılır.
        weatherImageIcon = (ImageView)view.findViewById(R.id.weatherIcon);
        temperature  = (TextView)view.findViewById(R.id.weatherTemperature);
        weatherText  = (TextView)view.findViewById(R.id.weatherCondition);
        location  = (TextView)view.findViewById(R.id.weatherLocation);
        weather = (RelativeLayout)view.findViewById(R.id.weather);


        service = new WeatherService(this);

        //Progress Dialog oluşturuldu.
        dialog = new ProgressDialog(getActivity());
        dialog.setMessage("Yükleniyor");
        dialog.show();

        service.refreshWeather("isparta, tr");

        getListItems();
        setSwipeRefreshLayout();
        setRecyclerView();



    }

    @Override
    public void serviceSuccess(Channel channel) {
            dialog.hide();
        Metric metric = channel.getMetric();
        int reSourceId = getResources().getIdentifier("@drawable/icon_" + channel.getWeatherIcon(),null,getActivity().getPackageName());
        @SuppressWarnings("deprecation")
        //Hava Durumu ikonu atandı
        Drawable weatherIconDrawable = getResources().getDrawable(reSourceId);
        weatherImageIcon.setImageDrawable(weatherIconDrawable);

        //Sıcaklık durum ve il değerleri atandı.
        temperature.setText(metric.getTemperature() + "\u00B0" + metric.getUnit());
        weatherText.setText(channel.getWeatherText());
        location.setText("Isparta");
        //Image Kısmı
        Picasso.with(getContext())
                .load(channel.getPhotos().getBackgroundImage())
                .centerCrop()
                .resize(100,100)
                .into(new Target() {
                    @Override
                    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                        weather.setBackground(new BitmapDrawable(getContext().getResources(),bitmap));
                    }

                    @Override
                    public void onBitmapFailed(Drawable errorDrawable) {
                        Log.d("IMAGE","Weather background image loading failed");
                    }

                    @Override
                    public void onPrepareLoad(Drawable placeHolderDrawable) {
                        Log.d("IMAGE","Weather background image prepare loading");
                    }
                });



}

    @Override
    public void serviceFailure(Exception exception) {
        //Servis hata mesajı.
        dialog.hide();
        Toast.makeText(getContext(),exception.getMessage(),Toast.LENGTH_LONG).show();
    }

    /*********************************************************
     * NEWS START
     */

    private void getListItems(){
        mNewsList = News.createNewsList();
    }

    private void setSwipeRefreshLayout(){

        mSwipeRefreshLayout = (SwipeRefreshLayout) getActivity().findViewById(R.id.swipeRefreshLayout);

        mSwipeRefreshLayout.setColorSchemeResources(
                R.color.refresh_progress_1,
                R.color.refresh_progress_2,
                R.color.refresh_progress_3
        );
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //Refresh işlemi
                getCurrentNews();
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });
    }
    private void getCurrentNews(){
        News news6 = new News();
        news6.setCaption("Konferans: Hatıralarla Necmettin Erbakan");
        news6.setDescription("Süleyman Demirel Üniversitesi İdealist Gençlik Topluluğu tarafından “Hatıralarla Necmettin Erbakan”" +
                " konulu bir konferans düzenleniyor. 10 Mart Cuma günü saat 15.00’te Hukuk Fakültesi Konferans Salonu’nda gerçekleştirilecek" +
                " olan konferans, Siyasetçi Fethullah Erbaş tarafından verilecek. ");
        news6.setImage("https://pbs.twimg.com/profile_images/573053038266470400/XnFvteTs.jpeg");

        mNewsList.add(0,news6);

        myNewsListAdapter.notifyItemInserted(0);
        mLinearLayoutManager.scrollToPosition(0);
    }

    private void setRecyclerView(){
        mRecyclerView = (RecyclerView)getActivity().findViewById(R.id.recyclerView);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setHasFixedSize(true);
        mLinearLayoutManager = new LinearLayoutManager(mContext);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        myNewsListAdapter = new MyNewsListAdapter();
        mRecyclerView.setAdapter(myNewsListAdapter);
    }


    private class MyNewsListAdapter extends RecyclerView.Adapter<MyNewsListAdapter.MyNewsHolder>{
        @Override
        public MyNewsListAdapter.MyNewsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.custom_recycler_view_announcement,parent,false);
            return new MyNewsListAdapter.MyNewsHolder(view);
        }

        @Override
        public void onBindViewHolder(MyNewsListAdapter.MyNewsHolder holder, int position) {
            News news = mNewsList.get(position);

            holder.tvNewsCaption.setText(news.getCaption());
            holder.tvNewsDescription.setText(news.getDescription());

            //Image Kısmı
            Picasso.with(mContext)
                    .load(news.getImage())
                    .resize(300, 300)
                    .centerCrop()
                    .into(holder.ivNewsImage);
        }

        @Override
        public int getItemCount() {
            return mNewsList.size();
        }

        public class MyNewsHolder extends RecyclerView.ViewHolder{
            ImageView ivNewsImage;
            TextView tvNewsCaption,  tvNewsDescription;

            public MyNewsHolder(View view) {
                super(view);
                ivNewsImage = (ImageView) view.findViewById(R.id.ivNewsImage);

                tvNewsCaption = (TextView) view.findViewById(R.id.tvNewsCaption);
                tvNewsDescription = (TextView) view.findViewById(R.id.tvNewsDescription);

            }
        }
    }

}
