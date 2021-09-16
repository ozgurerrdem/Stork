package com.example.stork.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.stork.Model.CardModel;
import com.example.stork.Model.NewCardModel;
import com.example.stork.R;

import java.util.List;

public class SmallCardsAdapter extends RecyclerView.Adapter<SmallCardsAdapter.CardViewHolder> {
    private List<NewCardModel> cardModelList;
    private ViewPager2 small_cards_viewpager;

    public SmallCardsAdapter(List<NewCardModel> cardModelList, ViewPager2 small_cards_viewpager) {
        this.cardModelList = cardModelList;
        this.small_cards_viewpager = small_cards_viewpager;
    }

    @NonNull
    @Override
    public SmallCardsAdapter.CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CardViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.small_card_container,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull SmallCardsAdapter.CardViewHolder holder, int position) {
        holder.setImageView(cardModelList.get(position));
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

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.card_image);
            account_name = itemView.findViewById(R.id.small_account_name);
            account_balance = itemView.findViewById(R.id.small_account_balance);
            account_number = itemView.findViewById(R.id.small_account_number);

        }

        void setImageView(NewCardModel cardModel) {
            imageView.setImageResource(cardModel.getImage());
            account_name.setText(cardModel.getAccount_name());
            account_balance.setText(cardModel.getAccount_balance());
            account_number.setText(cardModel.getAccount_number());


        }
    }
}
