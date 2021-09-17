package com.example.stork.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.stork.Activity.CashbackActivity;
import com.example.stork.Activity.GiftsActivity;
import com.example.stork.Activity.KampanyaActivity;
import com.example.stork.Activity.MarketActivity;
import com.example.stork.Activity.PaymentsActivity;
import com.example.stork.Activity.ReceiveMoneyActivity;
import com.example.stork.Activity.SendMoneyActivity;
import com.example.stork.Activity.StorkPointsActivity;
import com.example.stork.Activity.TransactionsActivity;
import com.example.stork.Adapter.CardAdapter;
import com.example.stork.MockAccount;
import com.example.stork.Model.CardModel;
import com.example.stork.Model.NewCardModel;
import com.example.stork.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    private ImageView cardView;
    private final FloatingActionButton[] buttons = new FloatingActionButton[9];


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        ViewPager2 viewPager2 = (ViewPager2) view.findViewById(R.id.viewPager);

        buttons[0] = view.findViewById(R.id.fab1);

        buttons[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity() , SendMoneyActivity.class));
            }
        });

        buttons[1] = view.findViewById(R.id.fab2);

        buttons[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               startActivity(new Intent(getActivity(), ReceiveMoneyActivity.class));
            }
        });

        buttons[2] = view.findViewById(R.id.fab3);

        buttons[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), PaymentsActivity.class));
            }
        });


        buttons[3] = view.findViewById(R.id.fab4);

        buttons[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), MarketActivity.class));
            }
        });

        buttons[4] = view.findViewById(R.id.fab5);

        buttons[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), TransactionsActivity.class));
            }
        });

        buttons[5] = view.findViewById(R.id.fab6);

        buttons[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), StorkPointsActivity.class));
            }
        });

        buttons[6] = view.findViewById(R.id.fab7);

        buttons[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), CashbackActivity.class));
            }
        });

        buttons[7] = view.findViewById(R.id.fab8);

        buttons[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), KampanyaActivity.class));
            }
        });

        buttons[8] = view.findViewById(R.id.fab9);

        buttons[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO Menu Fragment
            }
        });

        List<NewCardModel> cardModels = new ArrayList<>();

        cardModels.add(new NewCardModel(R.drawable.maincard, MockAccount.accounts.get(0).getAccountName(),MockAccount.accounts.get(0).getAmountOfBalance().toString()+MockAccount.accounts.get(0).getCurrencyCode(),MockAccount.accounts.get(0).getIBANNo()));
        cardModels.add(new NewCardModel(R.drawable.tokyotravel,MockAccount.accounts.get(1).getAccountName(),MockAccount.accounts.get(1).getAmountOfBalance().toString()+MockAccount.accounts.get(1).getCurrencyCode(),MockAccount.accounts.get(1).getIBANNo()));
        cardModels.add(new NewCardModel(R.drawable.eutravel,MockAccount.accounts.get(2).getAccountName(),MockAccount.accounts.get(2).getAmountOfBalance().toString()+MockAccount.accounts.get(2).getCurrencyCode(),MockAccount.accounts.get(2).getIBANNo()));
        cardModels.add(new NewCardModel(R.drawable.usa,MockAccount.accounts.get(3).getAccountName(),MockAccount.accounts.get(3).getAmountOfBalance().toString()+MockAccount.accounts.get(3).getCurrencyCode(),MockAccount.accounts.get(3).getIBANNo()));
        cardModels.add(new NewCardModel(R.drawable.plat,MockAccount.accounts.get(4).getAccountName(),MockAccount.accounts.get(4).getAmountOfBalance().toString()+MockAccount.accounts.get(4).getCurrencyCode(),MockAccount.accounts.get(4).getIBANNo()));
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

        DotsIndicator dotsIndicator = (DotsIndicator) view.findViewById(R.id.dots_indicator);
        dotsIndicator.setViewPager2(viewPager2);



        return view;
    }



}