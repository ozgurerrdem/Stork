package com.example.stork.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.stork.Adapter.PagAdapter;
import com.example.stork.R;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class KampanyaActivity extends AppCompatActivity {
    private TabLayout tablayout;
    private ViewPager viewpager;
    private TabItem tumkamp,katildiklarim;
    public PagAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kampanya);

        tablayout=(TabLayout) findViewById(R.id.TabLayout);
        tumkamp=(TabItem) findViewById(R.id.TumKamp);
        katildiklarim=(TabItem) findViewById(R.id.KatildigimKamp);
        viewpager=(ViewPager) findViewById(R.id.Viewpager);

        pagerAdapter=new PagAdapter(getSupportFragmentManager(),tablayout.getTabCount());
        viewpager.setAdapter(pagerAdapter);

        tablayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewpager.setCurrentItem(tab.getPosition());
                if(tab.getPosition()==0) {
                    pagerAdapter.notifyDataSetChanged();
                }
                else if(tab.getPosition()==1) {
                    pagerAdapter.notifyDataSetChanged();
                } }


            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout));
    }
}