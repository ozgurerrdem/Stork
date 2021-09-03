package com.example.stork.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_money);

        savedList = new ArrayList<>();
        rview = findViewById(R.id.recycler);
        adapter = new RecyclerAdapter(savedList, this, new RecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(SavedCustomer item) {
                Toast.makeText(getApplicationContext(), "Eyyy "+ item.getName()+ " sen kimsin!!!", Toast.LENGTH_SHORT).show();
            }
        });

        rview.setHasFixedSize(true);
        rview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rview.setAdapter(adapter);

        DatabaseUtil db = new DatabaseUtil();
        db.readCustomerData(new CallWrapperCustomer() {
            @Override
            public void readCustomerDataCallback(List<SavedCustomer> customers) {
                for(SavedCustomer sc : customers){
                    savedList.add(new SavedCustomer(sc.getName(),sc.getIBAN()));
                }
            }
        });
        adapter.notifyDataSetChanged();
    }
}