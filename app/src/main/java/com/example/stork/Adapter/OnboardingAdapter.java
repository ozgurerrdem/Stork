package com.example.stork.Adapter;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stork.Model.OnboardingItems;
import com.example.stork.R;

import java.util.List;

public class OnboardingAdapter extends RecyclerView.Adapter<OnboardingAdapter.OnboardingViewHolder> {

    private List<OnboardingItems> onboardingItemsList;

    public OnboardingAdapter(List<OnboardingItems> onboardingItemsList){
        this.onboardingItemsList = onboardingItemsList;
    }

    @NonNull
    @Override
    public OnboardingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new OnboardingViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.onboarding_items,parent,false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull OnboardingViewHolder holder, int position) {
        holder.setOnboardingData(onboardingItemsList.get(position));
    }

    @Override
    public int getItemCount() {
        return onboardingItemsList.size();
    }

    class OnboardingViewHolder extends RecyclerView.ViewHolder {
        private TextView textTitle;
        private TextView textDescription;
        private ImageView imageOnboarding;

        public OnboardingViewHolder(@NonNull View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.textTitle);
            textDescription = itemView.findViewById(R.id.textDescription);
            imageOnboarding = itemView.findViewById(R.id.imageOnboarding);
        }
        void setOnboardingData(OnboardingItems onboardingItems){
            textTitle.setText(onboardingItems.getTextTitle());
            textDescription.setText(onboardingItems.getDescripton());
            imageOnboarding.setImageResource(onboardingItems.getImage());
        }
    }
}
