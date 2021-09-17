package com.example.stork.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;

import com.example.stork.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class SendMoneyActivity extends AppCompatActivity {
    FloatingActionButton talimat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_money);

        ImageButton back_btn = findViewById(R.id.send_money_screen_back_btn);
        ImageButton floatActionButton3 = findViewById(R.id.floatingActionButton3);
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
                startActivity(new Intent(SendMoneyActivity.this, SendMoneyToFriendsActivity.class));
            }
        });


        floatActionButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SendMoneyActivity.this, SendBankActivity.class));
            }
        });

        talimat = findViewById(R.id.floatingActionButton12);
        talimat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SendMoneyActivity.this, TalimatlarActivity.class));
            }
        });

        FloatingActionButton fb5 = findViewById(R.id.floatingActionButton5);
        fb5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SendMoneyActivity.this,VirmanActivity.class));
            }
        });

    }
}