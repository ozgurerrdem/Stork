package com.example.stork.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.stork.Fragment.OdemeTalimatFragment;
import com.example.stork.Fragment.TransferTalimatFragment;

public class PagerAdapter extends FragmentPagerAdapter {
    private int numoftabs;
    public PagerAdapter(@NonNull FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numoftabs=numOfTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new TransferTalimatFragment();
            case 1:
                return new OdemeTalimatFragment();
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
