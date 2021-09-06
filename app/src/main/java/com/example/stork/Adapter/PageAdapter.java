package com.example.stork.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.stork.Fragment.tab1;
import com.example.stork.Fragment.tab2;

public class PageAdapter extends FragmentPagerAdapter {
    private int numoftabs;

    public PageAdapter(FragmentManager fm,int numOfTabs) {
        super(fm);
        this.numoftabs=numOfTabs;
    }


    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new tab1();
            case 1:
                return new tab2();
            default:
                return null;
        }

    }


    @Override
    public int getCount() {
        return numoftabs;
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }
}
