package com.example.stork.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.stork.Adapter.RecyclerAdapter;
import com.example.stork.Database.CallWrapperCustomer;
import com.example.stork.Database.DatabaseUtil;
import com.example.stork.Database.Models.SavedCustomer;
import com.example.stork.R;

import java.util.ArrayList;
import java.util.List;

public class ReceiveMoneyActivity extends AppCompatActivity {

    private ArrayList<SavedCustomer> savedList;
    private RecyclerView rview;
    private RecyclerAdapter adapter;
    private TextView textView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_money);

        ImageButton button = findViewById(R.id.receive_money_screen_back_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        savedList = new ArrayList<>();
        textView = findViewById(R.id.textView10);
        rview = findViewById(R.id.recycler);
        adapter = new RecyclerAdapter(savedList, this, new RecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(SavedCustomer item) {
            }
        });

        rview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rview.setAdapter(adapter);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ReceiveMoneyActivity.this, AddFriendPopup.class));
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        DatabaseUtil db = new DatabaseUtil();
        savedList.clear();
        db.readCustomerData(new CallWrapperCustomer() {
            @Override
            public void readCustomerDataCallback(List<SavedCustomer> customers) {
                for(SavedCustomer sc : customers){
                    savedList.add(new SavedCustomer(sc.getName(),sc.getIBAN(),sc.getPhotoLink()));
                    adapter.notifyDataSetChanged();
                }
            }
        });
    }

}