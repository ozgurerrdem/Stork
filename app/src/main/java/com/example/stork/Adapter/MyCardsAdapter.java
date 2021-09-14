package com.example.stork.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.stork.Model.CardModel;
import com.example.stork.Model.NewCardModel;
import com.example.stork.R;

import java.util.List;

public class MyCardsAdapter extends RecyclerView.Adapter<MyCardsAdapter.CardViewHolder> {

    private List<NewCardModel>cardModelList;
    private ViewPager2 mycards_viewPager;


    public MyCardsAdapter(List<NewCardModel> cardModelList, ViewPager2 mycards_viewPager) {
        this.cardModelList = cardModelList;
        this.mycards_viewPager = mycards_viewPager;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CardViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.card_item_container,
                        parent,
                        false
                )
        );

    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        holder.setImage(cardModelList.get(position));
    }

    @Override
    public int getItemCount() {
        return cardModelList.size();
    }

    class CardViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;

        CardViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.card_image);


        }

        void setImage(NewCardModel cardModel){
            imageView.setImageResource(cardModel.getImage());
        }

    }



}
