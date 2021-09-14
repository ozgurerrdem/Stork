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

import com.example.stork.API.GetRate.GetRate;
import com.example.stork.API.GetRate.Response.Response;
import com.example.stork.Adapter.CardAdapter;
import com.example.stork.MockAccount;
import com.example.stork.Model.CardModel;
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

        //Test
        System.out.println("Bakalım Hata var mi "+ MockAccount.accounts.get(3).getAccountName());
        GetRate get = new GetRate();
        get.getResponse(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {

                for (int i=0;i<10;i++){
                    System.out.println("---------------------------------------------");

                    System.out.println(response.body().result.get(i).name + " Satış : "+response.body().result.get(i).selling +  " Alış : "+response.body().result.get(i).buying );
                }


            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {


            }
        });


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        NavController navController = Navigation.findNavController(this,  R.id.fragment);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);

        viewPager2 = findViewById(R.id.viewPager);
        List<CardModel> cardModels = new ArrayList<>();

        cardModels.add(new CardModel(R.drawable.maincard));
        cardModels.add(new CardModel(R.drawable.tokyotravel));
        cardModels.add(new CardModel(R.drawable.eutravel));
        cardModels.add(new CardModel(R.drawable.usa));
        cardModels.add(new CardModel(R.drawable.plat));



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

