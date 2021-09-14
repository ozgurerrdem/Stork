package com.example.stork.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.stork.R;

public class TransactionsDetailsActivity extends AppCompatActivity {
    private Button transactions_confirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transactions_details);


        transactions_confirm = findViewById(R.id.transactions_confirm);
        transactions_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TransactionsDetailsActivity.this, IbanSendAnimationActivity.class));
            }
        });
    }
}