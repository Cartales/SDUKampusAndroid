package com.example.zulkuf.sdukampus.fragments.pool;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import com.example.zulkuf.sdukampus.PageAdapter;
import com.example.zulkuf.sdukampus.R;
import com.example.zulkuf.sdukampus.fragments.DayKey;


/**
 * Created by zulkuf on 14/03/17.
 */

public class DaysFragment extends Fragment implements DayKey {
    int day;
    DaysList list  = new DaysList();
    ListView listView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pool_days_fragment,container,false);
        return view;


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView = (ListView)view.findViewById(R.id.poolList);
        PoolArrayAdapter adapter = new PoolArrayAdapter(getContext());
        listView.setAdapter(adapter);


    }

    @Override
    public void dayKey(int key) {
      day =key;
    }


    public class PoolArrayAdapter extends ArrayAdapter<String>{
        public PoolArrayAdapter(@NonNull Context context) {

            super(context,R.layout.custom_pool_list_item,list.getTime());

        }

        @Override
        public int getItemViewType(int position) {
            return super.getItemViewType(position);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view  = inflater.inflate(R.layout.custom_pool_list_item,parent,false);

            ImageView ivPoolIcon = (ImageView)view.findViewById(R.id.ivPoolGenderImage);
            TextView tvPoolTime = (TextView)view.findViewById(R.id.tvPoolTime);
            TextView tvPoolGender = (TextView)view.findViewById(R.id.tvPoolGender);
            TextView tvPoolClean = (TextView)getActivity().findViewById(R.id.tvPoolClean);
            String[] poolGender ;
            String[] poolTime = list.getTime();
            String freetime;
            String ivValue;
            switch (day){
                case 0:
                    listView.setVisibility(View.INVISIBLE);
                    freetime = list.getMonday();
                    tvPoolClean.setText(list.getMonday());

                    break;
                case 1:
                     poolGender = list.getTuesday();
                    tvPoolGender.setText(poolGender[position]);
                    tvPoolTime.setText(poolTime[position]);
                    ivValue = poolGender[position];
                    if (ivValue.equals("Bay")){
                        ivPoolIcon.setBackgroundResource(R.drawable.boy);
                    }else if (ivValue.equals("Bayan")){
                        ivPoolIcon.setBackgroundResource(R.drawable.girl);
                    }else if(ivValue.equals("Bay - Bayan")){
                        ivPoolIcon.setBackgroundResource(R.drawable.man);
                    }else{
                        ivPoolIcon.setBackgroundResource(R.drawable.clean);
                    }
                    break;
                case 2:
                    poolGender = list.getWednesday();
                    tvPoolGender.setText(poolGender[position]);
                    tvPoolTime.setText(poolTime[position]);
                    ivValue = poolGender[position];
                    if (ivValue.equals("Bay")){
                        ivPoolIcon.setBackgroundResource(R.drawable.boy);
                    }else if (ivValue.equals("Bayan")){
                        ivPoolIcon.setBackgroundResource(R.drawable.girl);
                    }else if(ivValue.equals("Bay - Bayan")){
                        ivPoolIcon.setBackgroundResource(R.drawable.man);
                    }else{
                        ivPoolIcon.setBackgroundResource(R.drawable.clean);
                    }
                    break;
                case 3:
                    poolGender = list.getThursday();
                    tvPoolGender.setText(poolGender[position]);
                    tvPoolTime.setText(poolTime[position]);
                    ivValue = poolGender[position];
                    if (ivValue.equals("Bay")){
                        ivPoolIcon.setBackgroundResource(R.drawable.boy);
                    }else if (ivValue.equals("Bayan")){
                        ivPoolIcon.setBackgroundResource(R.drawable.girl);
                    }else if(ivValue.equals("Bay - Bayan")){
                        ivPoolIcon.setBackgroundResource(R.drawable.man);
                    }else{
                        ivPoolIcon.setBackgroundResource(R.drawable.clean);
                    }
                    break;
                case 4:
                    poolGender = list.getFriday();
                    tvPoolGender.setText(poolGender[position]);
                    tvPoolTime.setText(poolTime[position]);
                    ivValue = poolGender[position];
                    if (ivValue.equals("Bay")){
                        ivPoolIcon.setBackgroundResource(R.drawable.boy);
                    }else if (ivValue.equals("Bayan")){
                        ivPoolIcon.setBackgroundResource(R.drawable.girl);
                    }else if(ivValue.equals("Bay - Bayan")){
                        ivPoolIcon.setBackgroundResource(R.drawable.man);
                    }else{
                        ivPoolIcon.setBackgroundResource(R.drawable.clean);
                    }
                    break;
                case 5:
                    poolGender = list.getSaturday();
                    tvPoolGender.setText(poolGender[position]);
                    tvPoolTime.setText(poolTime[position]);
                    ivValue = poolGender[position];
                    if (ivValue.equals("Bay")){
                        ivPoolIcon.setBackgroundResource(R.drawable.boy);
                    }else if (ivValue.equals("Bayan")){
                        ivPoolIcon.setBackgroundResource(R.drawable.girl);
                    }else if(ivValue.equals("Bay - Bayan")){
                        ivPoolIcon.setBackgroundResource(R.drawable.man);
                    }else{
                        ivPoolIcon.setBackgroundResource(R.drawable.clean);
                    }
                    break;
                case 6:
                    poolGender = list.getSunday();
                    tvPoolGender.setText(poolGender[position]);
                    tvPoolTime.setText(poolTime[position]);
                    ivValue = poolGender[position];
                    if (ivValue.equals("Bay")){
                        ivPoolIcon.setBackgroundResource(R.drawable.boy);
                    }else if (ivValue.equals("Bayan")){
                        ivPoolIcon.setBackgroundResource(R.drawable.girl);
                    }else if(ivValue.equals("Bay - Bayan")){
                        ivPoolIcon.setBackgroundResource(R.drawable.man);
                    }else{
                        ivPoolIcon.setBackgroundResource(R.drawable.clean);
                    }
                    break;

            }

            return view;
        }
    }
}
