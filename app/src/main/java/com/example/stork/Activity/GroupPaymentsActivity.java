package com.example.stork.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.stork.API.GetRate.GetRate;
import com.example.stork.API.GetRate.Response.Response;
import com.example.stork.Adapter.GroupPaymentsAdapter;
import com.example.stork.R;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import retrofit2.Call;
import retrofit2.Callback;

public class GroupPaymentsActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TabItem tab1,tab2;
    public GroupPaymentsAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_payments);




        tabLayout = findViewById(R.id.group_payments_tablayout);
        tab1 =(TabItem) findViewById(R.id.group_payments_tab1);
        tab2 =(TabItem) findViewById(R.id.group_payments_tab2);
        viewPager =(ViewPager) findViewById(R.id.group_payments_viewpager);
        adapter = new GroupPaymentsAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition()==0){
                    adapter.notifyDataSetChanged();
                }
                else if(tab.getPosition() ==1){
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }

}