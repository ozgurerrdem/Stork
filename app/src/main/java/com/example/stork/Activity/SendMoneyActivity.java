package com.example.stork.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.stork.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class SendMoneyActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_money);

        ImageButton back_btn = findViewById(R.id.send_money_screen_back_btn);
        ImageButton floatActionButton3=findViewById(R.id.floatingActionButton3);
        FloatingActionButton floatingActionButton4 = findViewById(R.id.floatingActionButton4);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        floatingActionButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              startActivity(new Intent(SendMoneyActivity.this , SendMoneyToFriendsActivity.class));
                finish();
            }
        });


        floatActionButton3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(SendMoneyActivity.this,SendBankActivity.class));
            }
        });
    }
}