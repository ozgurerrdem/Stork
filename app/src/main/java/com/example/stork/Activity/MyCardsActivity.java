package com.example.stork.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.stork.Adapter.MyCardsAdapter;
import com.example.stork.Model.CardModel;
import com.example.stork.Model.NewCardModel;
import com.example.stork.R;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

import java.util.ArrayList;
import java.util.List;

public class MyCardsActivity extends AppCompatActivity {
    private ViewPager2 mycards_viewpager;
    private SeekBar seekBar;
    private TextView seekbar_Text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cards);

        mycards_viewpager = findViewById(R.id.mycards_viewPager);


        List<NewCardModel>cardModels = new ArrayList<>();

        cardModels.add(new NewCardModel(R.drawable.maincard,"Ana Hesap","3,444.30","TR32132132131"));
        cardModels.add(new NewCardModel(R.drawable.tokyotravel,"Hesap Adı","Hesap Bakiye","Hesap numarası"));
        cardModels.add(new NewCardModel(R.drawable.eutravel,"Hesap Adı","Hesap Bakiye","Hesap numarası"));
        cardModels.add(new NewCardModel(R.drawable.usa,"Hesap Adı","Hesap Bakiye","Hesap numarası"));
        cardModels.add(new NewCardModel(R.drawable.plat,"Hesap Adı","Hesap Bakiye","Hesap numarası"));

        mycards_viewpager.setAdapter(new MyCardsAdapter(cardModels , mycards_viewpager));

        mycards_viewpager.setClipToPadding(false);
        mycards_viewpager.setClipChildren(false);
        mycards_viewpager.setOffscreenPageLimit(3);
        mycards_viewpager.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.85f + r * 0.15f);

            }
        });


        mycards_viewpager.setPageTransformer(compositePageTransformer);

        ImageView back_btn = findViewById(R.id.back_btn77);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MyCardsActivity.this , MainActivity.class));
            }
        });

        DotsIndicator dotsIndicator = (DotsIndicator) findViewById(R.id.dots_indicator);
        dotsIndicator.setViewPager2(mycards_viewpager);


        seekBar = (SeekBar) findViewById(R.id.seek_bar);
        seekbar_Text = findViewById(R.id.seek_bar_text_current);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                seekbar_Text.setText(String.valueOf("₺ "+progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



    }
}