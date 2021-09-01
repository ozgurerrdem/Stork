package com.example.stork.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.stork.Activity.SendMoneyActivity;
import com.example.stork.Adapter.CardAdapter;
import com.example.stork.Model.CardModel;
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
                // TODO ReceiveMoney Fragment
            }
        });

        buttons[2] = view.findViewById(R.id.fab3);

        buttons[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO Odmeler Fragment
            }
        });


        buttons[3] = view.findViewById(R.id.fab4);

        buttons[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO Doviz Fragment
            }
        });

        buttons[4] = view.findViewById(R.id.fab5);

        buttons[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO Transactions Fragment
            }
        });

        buttons[5] = view.findViewById(R.id.fab6);

        buttons[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO Gifts Fragment
            }
        });

        buttons[6] = view.findViewById(R.id.fab7);

        buttons[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO Refund Fragment
            }
        });

        buttons[7] = view.findViewById(R.id.fab8);

        buttons[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO Offer Fragment
            }
        });

        buttons[8] = view.findViewById(R.id.fab9);

        buttons[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO Menu Fragment
            }
        });

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

        DotsIndicator dotsIndicator = (DotsIndicator) view.findViewById(R.id.dots_indicator);
        dotsIndicator.setViewPager2(viewPager2);



        return view;
    }



}