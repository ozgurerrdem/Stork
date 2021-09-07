package com.example.stork.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.stork.R;

public class GroupPayDoneActivity extends AppCompatActivity {
    private Button go_to_hp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_pay_done);

        go_to_hp = findViewById(R.id.go_to_hp);
        go_to_hp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GroupPayDoneActivity.this,MainActivity.class));
            }
        });
    }
}