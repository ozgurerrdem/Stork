package com.example.stork.Adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.stork.Database.Models.SavedCustomer;
import com.example.stork.R;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private final ArrayList<SavedCustomer> SavedCustomerArrayList;
    private final Context context;

    public RecyclerAdapter(ArrayList<SavedCustomer> list, Context context) {
        this.SavedCustomerArrayList = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecyclerAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.recycler_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {
        SavedCustomer data = SavedCustomerArrayList.get(position);
        holder.name.setText(data.getName());
        holder.iban.setText(data.getIBAN());
    }

    @Override
    public int getItemCount() {
        return SavedCustomerArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView name;
        private final TextView iban;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textView);
            iban = itemView.findViewById(R.id.textView2);
        }
    }
}
