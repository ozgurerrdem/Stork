package com.example.stork.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.stork.Fragment.CreateGroupFragment;
import com.example.stork.Fragment.MyGroupsFragment;

public class GroupPaymentsAdapter extends FragmentPagerAdapter {
    private int numoftabs;

    public GroupPaymentsAdapter(FragmentManager fm , int numoftabs){
        super(fm);
        this.numoftabs=numoftabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new MyGroupsFragment();
            case 1:
                return new CreateGroupFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return numoftabs;
    }
    @Override
    public int getItemPosition(@NonNull Object object){
        return POSITION_NONE;
    }
}
