package com.example.stork.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.stork.R;

public class GroupDetailsActivity extends AppCompatActivity {
    private Button group_pay_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_details);

        group_pay_button = findViewById(R.id.group_pay_button);
        group_pay_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GroupDetailsActivity.this,SendAnimationActivity.class));
            }
        });
    }
}