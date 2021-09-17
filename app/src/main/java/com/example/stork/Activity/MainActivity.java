package com.example.stork.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;


import android.os.Bundle;
import android.view.View;

import com.example.stork.API.CurrencyRate.GetCripto;
import com.example.stork.API.CurrencyRate.Response.Response;
import com.example.stork.Adapter.CardAdapter;
import com.example.stork.MockAccount;

import com.example.stork.Model.NewCardModel;
import com.example.stork.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;


public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        NavController navController = Navigation.findNavController(this,  R.id.fragment);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);

        viewPager2 = findViewById(R.id.viewPager);
        List<NewCardModel> cardModels = new ArrayList<>();


        cardModels.add(new NewCardModel(R.drawable.maincard,MockAccount.accounts.get(0).getAccountName(),MockAccount.accounts.get(0).getAmountOfBalance().toString()+MockAccount.accounts.get(0).getBirimCevirme(),MockAccount.accounts.get(0).getIBANNo()));
        cardModels.add(new NewCardModel(R.drawable.tokyotravel,MockAccount.accounts.get(1).getAccountName(),MockAccount.accounts.get(1).getAmountOfBalance().toString()+MockAccount.accounts.get(1).getBirimCevirme(),MockAccount.accounts.get(1).getIBANNo()));
        cardModels.add(new NewCardModel(R.drawable.eutravel,MockAccount.accounts.get(2).getAccountName(),MockAccount.accounts.get(2).getAmountOfBalance().toString()+MockAccount.accounts.get(2).getBirimCevirme(),MockAccount.accounts.get(2).getIBANNo()));
        cardModels.add(new NewCardModel(R.drawable.usa,MockAccount.accounts.get(3).getAccountName(),MockAccount.accounts.get(3).getAmountOfBalance().toString()+MockAccount.accounts.get(3).getBirimCevirme(),MockAccount.accounts.get(3).getIBANNo()));
        cardModels.add(new NewCardModel(R.drawable.plat,MockAccount.accounts.get(4).getAccountName(),MockAccount.accounts.get(4).getAmountOfBalance().toString()+MockAccount.accounts.get(4).getBirimCevirme(),MockAccount.accounts.get(4).getIBANNo()));
        cardModels.add(new NewCardModel(R.drawable.maincard,MockAccount.accounts.get(5).getAccountName(),MockAccount.accounts.get(5).getAmountOfBalance().toString()+MockAccount.accounts.get(5).getBirimCevirme(),MockAccount.accounts.get(5).getIBANNo()));




        viewPager2.setAdapter(new CardAdapter(cardModels , viewPager2));

        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.85f + r * 0.15f);

            }
        });

        viewPager2.setPageTransformer(compositePageTransformer);
    }



}

