package com.example.stork.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.stork.Adapter.SmallCardsAdapter;
import com.example.stork.Model.CardModel;
import com.example.stork.R;

import java.util.ArrayList;
import java.util.List;

public class TransactionsActivity extends AppCompatActivity {
    private ViewPager2 small_cards_viewpager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transactions);

        ImageButton backButton = findViewById(R.id.back_btn77);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

            }
        });

        small_cards_viewpager = findViewById(R.id.small_cards_viewpager2);

        List<CardModel> cardModels = new ArrayList<>();

        cardModels.add(new CardModel(R.drawable.main_small));
        cardModels.add(new CardModel(R.drawable.tokyo_small));
        cardModels.add(new CardModel(R.drawable.usa_small));
        cardModels.add(new CardModel(R.drawable.universal_small));
        cardModels.add(new CardModel(R.drawable.europe_small));
        cardModels.add(new CardModel(R.drawable.plat_small));

        small_cards_viewpager.setAdapter(new SmallCardsAdapter(cardModels,small_cards_viewpager));

        small_cards_viewpager.setClipToPadding(false);
        small_cards_viewpager.setClipChildren(false);
        small_cards_viewpager.setOffscreenPageLimit(3);
        small_cards_viewpager.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.85f + r * 0.15f);

            }
        });


        small_cards_viewpager.setPageTransformer(compositePageTransformer);
    }
}