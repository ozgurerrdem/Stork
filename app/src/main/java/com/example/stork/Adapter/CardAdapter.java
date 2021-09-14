package com.example.stork.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.stork.Activity.MyCardsActivity;
import com.example.stork.Model.CardModel;
import com.example.stork.Model.NewCardModel;
import com.example.stork.R;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHolder> {

    private List<NewCardModel> cardModelList;
    private ViewPager2 viewPager2;


    public CardAdapter(List<NewCardModel> cardModelList, ViewPager2 viewPager2) {
        this.cardModelList = cardModelList;
        this.viewPager2 = viewPager2;
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
        private TextView account_name;
        private TextView account_balance;
        private TextView account_number;


        CardViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.card_image);
            account_name = itemView.findViewById(R.id.account_name);
            account_balance = itemView.findViewById(R.id.account_balance);
            account_number = itemView.findViewById(R.id.account_number);

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(imageView.getContext(), MyCardsActivity.class);
                    imageView.getContext().startActivity(intent);
                }
            });


        }

        void setImage(NewCardModel cardModel) {
            imageView.setImageResource(cardModel.getImage());
            account_name.setText(cardModel.getAccount_name());
            account_balance.setText(cardModel.getAccount_balance());
            account_number.setText(cardModel.getAccount_number());


        }

    }


}
