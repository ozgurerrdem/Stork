package com.example.stork.Adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.stork.Database.Models.SavedCustomer;
import com.example.stork.R;

import java.io.InputStream;
import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    public interface OnItemClickListener {
        void onItemClick(SavedCustomer item);
    }

    private final ArrayList<SavedCustomer> SavedCustomerArrayList;
    OnItemClickListener listener;
    private final Context context;

    public RecyclerAdapter(ArrayList<SavedCustomer> list, Context context, OnItemClickListener listener) {
        this.SavedCustomerArrayList = list;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecyclerAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.recycler_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {
        holder.bind(SavedCustomerArrayList.get(position),listener);
    }

    @Override
    public int getItemCount() {
        return SavedCustomerArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView name;
        private final TextView iban;
        private final ImageView avatar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textView);
            iban = itemView.findViewById(R.id.textView2);
            avatar = itemView.findViewById(R.id.imageView2);
        }
        public void bind(final SavedCustomer item, final OnItemClickListener listener) {
            name.setText(item.getName());
            iban.setText(item.getIBAN());
            new DownloadImageTask(avatar)
                    .execute(item.getPhotoLink());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });
        }
    }

    public class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
}
