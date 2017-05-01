package com.example.zulkuf.sdukampus.fragments;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;

import com.example.zulkuf.sdukampus.PageAdapterDays2;
import com.example.zulkuf.sdukampus.R;

/**
 * Created by zulkuf on 07/03/17.
 */

public class RefectoryFragment extends Fragment {

    TabLayout tabLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.refectory_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tabLayout = (TabLayout)view.findViewById(R.id.days_TabR);
        tabLayout.addTab(tabLayout.newTab().setText("Pazartesi"));
        tabLayout.addTab(tabLayout.newTab().setText("Salı"));
        tabLayout.addTab(tabLayout.newTab().setText("Çarşamba"));
        tabLayout.addTab(tabLayout.newTab().setText("Perşembe"));
        tabLayout.addTab(tabLayout.newTab().setText("Cuma"));

        tabLayout.setBackgroundColor(getResources().getColor(R.color.sduYesil));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager)view.findViewById(R.id.refactory_Pager);
        final PageAdapterDays2 adapter = new PageAdapterDays2(getFragmentManager(),
                                        tabLayout.getTabCount());
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
