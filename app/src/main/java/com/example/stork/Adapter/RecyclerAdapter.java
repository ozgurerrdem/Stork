package com.example.stork.Adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.stork.FriendData;
import com.example.stork.R;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private final ArrayList<FriendData> friendDataArrayList;
    private final Context context;

    public RecyclerAdapter(ArrayList<FriendData> list, Context context) {
        this.friendDataArrayList = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecyclerAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.recycler_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {
        FriendData data = friendDataArrayList.get(position);
        holder.name.setText(data.getName());
    }

    @Override
    public int getItemCount() {
        return friendDataArrayList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textView);
        }
    }
}
