package com.example.stork.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.stork.Fragment.ChartsFragment;
import com.example.stork.Fragment.GelirFragment;
import com.example.stork.Fragment.HarcamalarFragment;
import com.example.stork.Fragment.KatildigimKampanyaFragment;
import com.example.stork.Fragment.TumKampanyaFragment;

public class ChartsAdapter extends FragmentPagerAdapter {
    private int numoftabs;
    public ChartsAdapter(@NonNull FragmentManager fm,int numOfTabs) {
        super(fm);
        this.numoftabs=numOfTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new HarcamalarFragment();
            case 1:
                return new GelirFragment();
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
