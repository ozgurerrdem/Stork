package com.example.stork.Adapter;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.stork.Database.Models.SavedCustomer;
import com.example.stork.Fragment.IBANTransferFragment;
import com.example.stork.Fragment.CardTransferFragment;

public class PageAdapter extends FragmentPagerAdapter {
    private int numoftabs;
    private SavedCustomer saved;

    public PageAdapter(FragmentManager fm, int numOfTabs, SavedCustomer saved) {
        super(fm);
        this.numoftabs=numOfTabs;
        this.saved = saved;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                IBANTransferFragment iban = new IBANTransferFragment();
                Bundle bundle = new Bundle();
                bundle.putSerializable("saved",saved);
                iban.setArguments(bundle);
                return iban;
            case 1:
                return new CardTransferFragment();
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
