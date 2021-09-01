package com.example.stork.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.stork.Adapter.RecyclerAdapter;
import com.example.stork.FriendData;
import com.example.stork.R;

import java.util.ArrayList;

public class ReceiveMoneyActivity extends AppCompatActivity {

    private ArrayList<FriendData> friendDataArrayList;
    private RecyclerView rview;
    private RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_money);

        friendDataArrayList = new ArrayList<>();
        rview = findViewById(R.id.recycler);
        adapter = new RecyclerAdapter(friendDataArrayList, this);

        rview.setHasFixedSize(true);
        rview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rview.setAdapter(adapter);
        friendDataArrayList.add(new FriendData("Emre"));
        friendDataArrayList.add(new FriendData("Yigit"));
        friendDataArrayList.add(new FriendData("Duygu"));
        friendDataArrayList.add(new FriendData("Kutay"));
        friendDataArrayList.add(new FriendData("Vahid"));
        friendDataArrayList.add(new FriendData("Yilan"));
        friendDataArrayList.add(new FriendData("Burak"));
        friendDataArrayList.add(new FriendData("Busra"));
        friendDataArrayList.add(new FriendData("Ozgur"));
        friendDataArrayList.add(new FriendData("Vahid"));
        adapter.notifyDataSetChanged();
    }
}