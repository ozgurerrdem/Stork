package com.example.stork.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;

import com.example.stork.Adapter.SmallCardsAdapter;
import com.example.stork.Model.CardModel;
import com.example.stork.R;

import java.util.ArrayList;
import java.util.List;

public class CashbackActivity extends AppCompatActivity {
    private ViewPager2 small_cards_viewpager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cashback);


    }
}