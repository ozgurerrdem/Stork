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
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    private ViewPager2 viewPager2;
    private ImageView cardView;
    private ConstraintLayout send_money_btn;


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        viewPager2 = (ViewPager2) view.findViewById(R.id.viewPager);

        send_money_btn = (ConstraintLayout) view.findViewById(R.id.send_money_btn);

        send_money_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity() , SendMoneyActivity.class));
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