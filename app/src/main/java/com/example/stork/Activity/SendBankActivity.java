package com.example.stork.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.stork.Adapter.RecyclerAdapter;
import com.example.stork.Database.CallWrapperCustomer;
import com.example.stork.Database.DatabaseUtil;
import com.example.stork.Database.Models.SavedCustomer;
import com.example.stork.R;

import java.util.ArrayList;
import java.util.List;

public class SendBankActivity extends AppCompatActivity {
    private ArrayList<SavedCustomer> savedList;
    private RecyclerView rview;
    private RecyclerAdapter adapter;
    SavedCustomer saved = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_bank);

        ImageButton back = findViewById(R.id.back_btn77);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Button new_address=findViewById(R.id.new_adress);

        savedList = new ArrayList<>();
        rview = findViewById(R.id.recyclerView);
        adapter = new RecyclerAdapter(savedList, this, new RecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(SavedCustomer item) {
                saved = item;
                Intent intent = new Intent(SendBankActivity.this,MoneyTransferActivity.class);
                intent.putExtra("saved",saved);
                startActivity(intent);
            }
        });

        rview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rview.setAdapter(adapter);

        new_address.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(SendBankActivity.this,MoneyTransferActivity.class));
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