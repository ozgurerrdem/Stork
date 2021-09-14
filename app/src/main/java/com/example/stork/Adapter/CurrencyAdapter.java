package com.example.stork.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stork.Activity.MarketActivity;
import com.example.stork.R;

import java.util.ArrayList;

public class CurrencyAdapter extends RecyclerView.Adapter<CurrencyAdapter.ViewHolder>{
    private ArrayList<MarketActivity.Currency> currencies;
    private Context context;
    public CurrencyAdapter(ArrayList<MarketActivity.Currency> currencies,Context context) {
        this.currencies = currencies;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CurrencyAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.piyasa_hisse,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(currencies.get(position));
    }

    @Override
    public int getItemCount() {
        return currencies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView name;
        private final TextView selling;
        private final TextView buying;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            selling = itemView.findViewById(R.id.selling);
            buying = itemView.findViewById(R.id.buying);
        }
        public void bind(final MarketActivity.Currency item) {
            name.setText(item.getName());
            selling.setText(item.getSatis().toString());
            buying.setText(item.getAlis().toString());
        }
    }
}
