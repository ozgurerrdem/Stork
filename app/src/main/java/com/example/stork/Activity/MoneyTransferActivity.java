package com.example.stork.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.stork.Adapter.PageAdapter;
import com.example.stork.R;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MoneyTransferActivity extends AppCompatActivity {
    private TabLayout tablayout;
    private ViewPager viewpager;
    private TabItem tab1,tab2;
    public PageAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_money_transfer);


        tablayout=(TabLayout) findViewById(R.id.tablayout);
        tab1=(TabItem) findViewById(R.id.Tab1);
        tab2=(TabItem) findViewById(R.id.Tab2);
        viewpager=(ViewPager) findViewById(R.id.ViewPager);
        pagerAdapter=new PageAdapter(getSupportFragmentManager(),tablayout.getTabCount());
        viewpager.setAdapter(pagerAdapter);
        tablayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){
           @Override
           public void onTabSelected(TabLayout.Tab tab){
           viewpager.setCurrentItem(tab.getPosition());
           if(tab.getPosition()==0) {
               pagerAdapter.notifyDataSetChanged();
           }
               else if(tab.getPosition()==1) {
               pagerAdapter.notifyDataSetChanged();
           } }
           @Override
            public void onTabUnselected(TabLayout.Tab tab){

           }
          @Override
            public void onTabReselected(TabLayout.Tab tab){

          }
        });
        viewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout));
    }
}