package com.example.zulkuf.sdukampus.fragments.refectory;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.zulkuf.sdukampus.R;
import com.example.zulkuf.sdukampus.fragments.DayKey;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

/**
 * Created by zulkuf on 14/03/17.
 */

public class DaysFragment extends Fragment implements DayKey {
    int day;
    RefectoryList list = new RefectoryList();
    ListView listView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.refectory_days_fragment,container,false);
        return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listView = (ListView)view.findViewById(R.id.refectoryList);
        RefectoryArrayAdapter adapter = new RefectoryArrayAdapter(getContext());
        listView.setAdapter(adapter);
    }

    @Override
    public void dayKey(int key) {
        day = key;
    }


    public class RefectoryArrayAdapter extends ArrayAdapter<String> {
        public RefectoryArrayAdapter(@NonNull Context context) {

            super(context,R.layout.custom_refectory_list_item,list.getMonday());

        }

        @Override
        public int getItemViewType(int position) {
            return super.getItemViewType(position);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view  = inflater.inflate(R.layout.custom_refectory_list_item,parent,false);

            final ImageView ivRefectoryIcon = (ImageView)view.findViewById(R.id.ivRefectoryImage);
            TextView tvCalorie = (TextView)view.findViewById(R.id.tvRefectoryCalorie);
            TextView tvFoodName = (TextView)view.findViewById(R.id.tvRefectoryName);
            String[] foodName ;
            String[] foodCalorie = list.getCalorie();
            String foodPartical = foodCalorie[day];
            String[] splice = foodPartical.split("-");
            String[] foodImages = list.getImages();
            String foodImagePart = foodImages[day];
            String[] images = foodImagePart.split("-");
            String ivValue;
            switch (day){
                case 0:
                    foodName = list.getMonday();
                    tvFoodName.setText(foodName[position]);
                    tvCalorie.setText(splice[position]);
                    Picasso.with(getContext())
                            .load(images[position])
                            .centerCrop()
                            .resize(100,100)
                            .into(new Target() {
                                @Override
                                public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                                    ivRefectoryIcon.setBackground(new BitmapDrawable(getContext().getResources(),bitmap));
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
                    break;
                case 1:
                    foodName = list.getTuesday();
                    tvFoodName.setText(foodName[position]);
                    tvCalorie.setText(splice[position]);
                    Picasso.with(getContext())
                            .load(images[position])
                            .centerCrop()
                            .resize(100,100)
                            .into(new Target() {
                                @Override
                                public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                                    ivRefectoryIcon.setBackground(new BitmapDrawable(getContext().getResources(),bitmap));
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
                    break;
                case 2:
                    foodName = list.getWednesday();
                    tvFoodName.setText(foodName[position]);
                    tvCalorie.setText(splice[position]);
                    Picasso.with(getContext())
                            .load(images[position])
                            .centerCrop()
                            .resize(100,100)
                            .into(new Target() {
                                @Override
                                public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                                    ivRefectoryIcon.setBackground(new BitmapDrawable(getContext().getResources(),bitmap));
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
                    break;
                case 3:
                    foodName = list.getThursday();
                    tvFoodName.setText(foodName[position]);
                    tvCalorie.setText(splice[position]);
                    Picasso.with(getContext())
                            .load(images[position])
                            .centerCrop()
                            .resize(100,100)
                            .into(new Target() {
                                @Override
                                public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                                    ivRefectoryIcon.setBackground(new BitmapDrawable(getContext().getResources(),bitmap));
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
                    break;
                case 4:
                    foodName = list.getFriday();
                    tvFoodName.setText(foodName[position]);
                    tvCalorie.setText(splice[position]);
                    Picasso.with(getContext())
                            .load(images[position])
                            .centerCrop()
                            .resize(100,100)
                            .into(new Target() {
                                @Override
                                public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                                    ivRefectoryIcon.setBackground(new BitmapDrawable(getContext().getResources(),bitmap));
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
                    break;
                default:
                    return null;
            }

            return view;
        }
    }

}
