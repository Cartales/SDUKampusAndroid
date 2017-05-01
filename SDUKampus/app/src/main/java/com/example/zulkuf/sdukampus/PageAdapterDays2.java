package com.example.zulkuf.sdukampus;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.zulkuf.sdukampus.fragments.refectory.DaysFragment;
/**
 * Created by zulkuf on 4/28/17.
 */

public class PageAdapterDays2 extends FragmentStatePagerAdapter {

    int mNumOfTabs;

    public PageAdapterDays2(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){

            case 0:
                DaysFragment tab1 = new DaysFragment();
                tab1.dayKey(0);
                return tab1;
            case 1:
                DaysFragment tab2 = new DaysFragment();
                tab2.dayKey(1);
                return tab2;
            case 2:
                DaysFragment tab3 = new DaysFragment();
                tab3.dayKey(2);
                return tab3;
            case 3:
                DaysFragment tab4 = new DaysFragment();
                tab4.dayKey(3);
                return tab4;

            case 4:
                DaysFragment tab5 = new DaysFragment();
                tab5.dayKey(4);
                return tab5;

            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}