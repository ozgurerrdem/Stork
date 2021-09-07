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
import android.widget.Toast;

import com.example.stork.API.ProcessEftRequestToIban.Request.Header;
import com.example.stork.API.SendFastMoneyOrder.Request.Parameters;
import com.example.stork.API.SendFastMoneyOrder.Request.Request;
import com.example.stork.API.SendFastMoneyOrder.Request.SourceAccount;
import com.example.stork.API.SendFastMoneyOrder.Response.Response;
import com.example.stork.API.SendFastMoneyOrder.SendFastMoneyOrder;
import com.example.stork.Account;
import com.example.stork.Adapter.CardAdapter;
import com.example.stork.CallWrapperAccounts;
import com.example.stork.MockAccount;
import com.example.stork.Model.CardModel;
import com.example.stork.R;
import com.example.stork.Services;
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
        BackendTest test = new BackendTest();
        test.run();
        MockAccount ma = new MockAccount();
        ma.readAccountsData(new CallWrapperAccounts() {
            @Override
            public void readAccountsDataCallback(List<Account> accounts) {

                //accounts set.

            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        NavController navController = Navigation.findNavController(this,  R.id.fragment);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);

        viewPager2 = findViewById(R.id.viewPager);
        List<CardModel> cardModels = new ArrayList<>();

        cardModels.add(new CardModel(R.drawable.maincard));
        cardModels.add(new CardModel(R.drawable.usa));
        cardModels.add(new CardModel(R.drawable.uni));
        cardModels.add(new CardModel(R.drawable.plat));
        cardModels.add(new CardModel(R.drawable.eutravel));
        cardModels.add(new CardModel(R.drawable.tokyotravel));

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

