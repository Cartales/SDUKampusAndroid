package com.example.zulkuf.sdukampus;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zulkuf.sdukampus.data.News;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NewScreen extends AppCompatActivity {
    private String TAG = NewScreen.class.getSimpleName();
    private Context mContext = this;

    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private MyNewsListAdapter myNewsListAdapter;


    private List<News> mNewsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deneme);


        getListItems();
        setSwipeRefreshLayout();
        setRecyclerView();
    }

    private void getListItems(){
        mNewsList = News.createNewsList();
    }

    private void setSwipeRefreshLayout(){
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);

        mSwipeRefreshLayout.setColorSchemeResources(
                R.color.refresh_progress_1,
                R.color.refresh_progress_2,
                R.color.refresh_progress_3
        );
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //Refresh işlemi
                getNewCity();
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    private void getNewCity(){
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
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setHasFixedSize(true);
        mLinearLayoutManager = new LinearLayoutManager(mContext);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        myNewsListAdapter = new MyNewsListAdapter();
        mRecyclerView.setAdapter(myNewsListAdapter);
    }

    private class MyNewsListAdapter extends RecyclerView.Adapter<MyNewsListAdapter.MyNewsHolder>{
        @Override
        public MyNewsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.custom_recycler_view_announcement,parent,false);
            return new MyNewsHolder(view);
        }

        @Override
        public void onBindViewHolder(MyNewsHolder holder, int position) {
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
