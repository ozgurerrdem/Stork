package com.example.stork.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.stork.R;
import android.os.Handler;

public class IbanSendAnimationActivity extends AppCompatActivity {

    private Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iban_send_animation);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(IbanSendAnimationActivity.this , SendDoneActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }
}