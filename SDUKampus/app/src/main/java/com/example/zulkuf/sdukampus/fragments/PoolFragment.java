package com.example.zulkuf.sdukampus.fragments;

import android.content.res.ColorStateList;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;

import com.example.zulkuf.sdukampus.PageAdapterDays;
import com.example.zulkuf.sdukampus.R;

/**
 * Created by zulkuf on 07/03/17.
 */

public class PoolFragment extends Fragment{

    TabLayout tabLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pool_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tabLayout  = (TabLayout)view.findViewById(R.id.days_Tab);
        tabLayout.addTab(tabLayout.newTab().setText("Pazartesi"));
        tabLayout.addTab(tabLayout.newTab().setText("Salı"));
        tabLayout.addTab(tabLayout.newTab().setText("Çarşamba"));
        tabLayout.addTab(tabLayout.newTab().setText("Perşembe"));
        tabLayout.addTab(tabLayout.newTab().setText("Cuma"));
        tabLayout.addTab(tabLayout.newTab().setText("Cumartesi"));
        tabLayout.addTab(tabLayout.newTab().setText("Pazar"));
        tabLayout.setBackgroundColor(getResources().getColor(R.color.sduYesil));
        tabLayout.setTabTextColors(ColorStateList.valueOf(getResources().getColor(R.color.sduBeyaz)));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        final ViewPager viewPager  = (ViewPager)view.findViewById(R.id.pool_Pager);
        final PageAdapterDays adapter = new PageAdapterDays
                (getFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
