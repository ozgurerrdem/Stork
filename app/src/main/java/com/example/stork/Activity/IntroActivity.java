package com.example.stork.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.stork.API.GetRate.GetRate;
import com.example.stork.API.GetRate.Response.Response;
import com.example.stork.Account;
import com.example.stork.Adapter.OnboardingAdapter;
import com.example.stork.MockAccount;
import com.example.stork.Model.OnboardingItems;
import com.example.stork.R;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class IntroActivity extends AppCompatActivity {



    OnboardingAdapter onboardingAdapter;
    Button onboardingActionButton;
    LinearLayout layoutOnboardingIndicator;
    TextView onboarding_skip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        setUpOnboardingItem();
        layoutOnboardingIndicator = findViewById(R.id.onboardingIndicator);
        final ViewPager2 viewPager2 = findViewById(R.id.onboardingViewpager);
        viewPager2.setAdapter(onboardingAdapter);
        onboardingActionButton = findViewById(R.id.onboardaction);
        onboarding_skip = findViewById(R.id.onboarding_skip);

        setupOnboardingIndicator();
        setCurrentOnboardingIndicator(0);

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentOnboardingIndicator(position);
            }
        });

        onboarding_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(IntroActivity.this , LoginActivity.class));
                finish();
            }
        });

        onboardingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(viewPager2.getCurrentItem() + 1 < onboardingAdapter.getItemCount()){
                    viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);

                }else{
                    startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                    finish();
                }
            }
        });




    }

    private void setUpOnboardingItem(){
        List<OnboardingItems> onboardingItemsList = new ArrayList<>();

        OnboardingItems firstPage = new OnboardingItems();
        firstPage.setTextTitle("Tüm Hesapların Tek Bir Yerde");
        firstPage.setDescripton("Stork, banka derdi olmadan tüm hesaplarını ve kartlarını tek bir noktadan yönetmeni sağlar.");
        firstPage.setImage(R.drawable.onboarding_card_resize);

        OnboardingItems secondPage = new OnboardingItems();
        secondPage.setTextTitle("Kolay  Para Transferi");
        secondPage.setDescripton("Uzun hesap bilgileri gerekmeden arkadaşlarınla kolayca para gönderme ve para alma işlemleri gerçekleştirebilirsin.");
        secondPage.setImage(R.drawable.onboarding_send_resize);

        OnboardingItems thirdPage = new OnboardingItems();
        thirdPage.setTextTitle("Ödemelerini Planla");
        thirdPage.setDescripton("Bütün ödemelerini kolayca planlayabilir , detaylı analizlerle bütçe kontrolünü sağlayabilirsin.");
        thirdPage.setImage(R.drawable.onboardging_analysis_resize);

        OnboardingItems fourthPage = new OnboardingItems();
        fourthPage.setTextTitle("Çeşitli Hediyeler ve Avantajlar");
        fourthPage.setDescripton("Bankacılık işlemlerinin yanı sıra çeşitli hediyeler ve avantajlar da Stork dünyasında seni bekliyor.");
        fourthPage.setImage(R.drawable.onboarding_offers_resize);


        onboardingItemsList.add(firstPage);
        onboardingItemsList.add(secondPage);
        onboardingItemsList.add(thirdPage);
        onboardingItemsList.add(fourthPage);

        onboardingAdapter = new OnboardingAdapter(onboardingItemsList);

    }
    private void setupOnboardingIndicator() {
        ImageView[] indicators = new ImageView[onboardingAdapter.getItemCount()];
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT
        );
        layoutParams.setMargins(8,0,8,0);
        for(int i= 0 ; i<indicators.length;i++){
            indicators[i] = new ImageView(getApplicationContext());
            indicators[i].setImageDrawable(ContextCompat.getDrawable(
                    getApplicationContext(),
                    R.drawable.onboarding_indicator_inactive
            ));

            indicators[i].setLayoutParams(layoutParams);
            layoutOnboardingIndicator.addView(indicators[i]);
        }
    }

    private void setCurrentOnboardingIndicator(int index){
        int childCount = layoutOnboardingIndicator.getChildCount();
        for(int i = 0; i<childCount;i++){
            ImageView imageView = (ImageView) layoutOnboardingIndicator.getChildAt(i);
            if(i == index){
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(getApplicationContext(),R.drawable.onboarding_indicator_active)
                );

            }else{
                imageView.setImageDrawable(ContextCompat.getDrawable(getApplicationContext() , R.drawable.onboarding_indicator_inactive));
            }

        }
        if(index == onboardingAdapter.getItemCount() -1 ) {
            onboardingActionButton.setText("Başla");
        }else{
            onboardingActionButton.setText("İlerle");
        }
    }

}