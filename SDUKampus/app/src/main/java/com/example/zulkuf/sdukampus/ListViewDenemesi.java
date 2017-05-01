package com.example.zulkuf.sdukampus;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by zulkuf on 13/03/17.
 */

public class ListViewDenemesi extends AppCompatActivity {
    private String[] time  = {"Dört","Sekiz","Onİki","OnSekiz","OtuzYedi","KırkAltı","KırkYedi"};
    private String[] location  = {"Batı","Tıp","Doğu","Tönge","Mevlana","Batıkent","Halıkent"};
    private String[] numbers  = {"4","8","12","18","37","46","47"};
    private ListView mBusList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deneme);
        mBusList = (ListView)findViewById(R.id.lv1);
      MyArrayAdapter myArrayAdapter = new MyArrayAdapter(ListViewDenemesi.this);

        mBusList.setAdapter(myArrayAdapter);
    }

    private class MyArrayAdapter extends ArrayAdapter<String>{
        public MyArrayAdapter(@NonNull Context context) {
            super(context, R.layout.custom_bus_list_item,time);
        }

        @Override
        public int getItemViewType(int position) {
            return super.getItemViewType(position);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view  = layoutInflater.inflate(R.layout.custom_bus_list_item,parent,false);

            ImageView img = (ImageView)view.findViewById(R.id.ivBusNumberImage);
            TextView tv1 = (TextView)view.findViewById(R.id.tvBusTime);
            TextView tv2 = (TextView)view.findViewById(R.id.tvBusRoute);
            TextView tv3 = (TextView)view.findViewById(R.id.tvBusNumber);


            tv1.setText(time[position]);
            tv2.setText(location[position]);
            tv3.setText(numbers[position]);


            return view;
        }
    }


}
