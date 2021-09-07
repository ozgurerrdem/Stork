package com.example.stork.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.stork.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class PaymentsActivity extends AppCompatActivity {
    private FloatingActionButton groups;
    private FloatingActionButton talimat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payments);

        groups = findViewById(R.id.groups_fb);
        talimat = findViewById(R.id.floatingActionButton9);

        talimat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PaymentsActivity.this,TalimatlarActivity.class));
            }
        });

        groups.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PaymentsActivity.this,GroupPaymentsActivity.class));
            }
        });
    }
}