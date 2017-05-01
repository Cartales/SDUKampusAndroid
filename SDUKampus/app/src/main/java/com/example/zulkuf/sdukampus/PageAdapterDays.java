package com.example.zulkuf.sdukampus;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.zulkuf.sdukampus.fragments.pool.DaysFragment;

/**
 * Created by zulkuf on 07/03/17.
 */

public  class PageAdapterDays extends FragmentStatePagerAdapter {

    int mNumofTabs;
    public PageAdapterDays(FragmentManager fm,int NumOfTabs) {
        super(fm);
        this.mNumofTabs = NumOfTabs;
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
            case 5:
                DaysFragment tab6 = new DaysFragment();
                tab6.dayKey(5);
            return tab6;
            case 6:
                DaysFragment tab7 = new DaysFragment();
                tab7.dayKey(6);
                return tab7;
            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return mNumofTabs;
    }
}
