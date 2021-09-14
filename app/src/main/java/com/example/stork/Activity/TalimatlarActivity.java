package com.example.stork.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.stork.Adapter.PagerAdapter;
import com.example.stork.R;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class TalimatlarActivity extends AppCompatActivity {
    private TabLayout tablayout;
    private ViewPager viewPager;
    private TabItem transfer,odeme;
    public PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_talimatlar);
        ImageButton back = findViewById(R.id.back_btn77);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        tablayout=(TabLayout) findViewById(R.id.TabLayout);
        transfer=(TabItem) findViewById(R.id.Transfer);
        odeme=(TabItem) findViewById(R.id.Odeme);
        viewPager=(ViewPager) findViewById(R.id.Viewpager);

        pagerAdapter=new PagerAdapter(getSupportFragmentManager(),tablayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);

        tablayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
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
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout));
    }
}