package com.example.stork.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.stork.R;
import android.os.Handler;

import java.util.ArrayList;

public class IbanSendAnimationActivity extends AppCompatActivity {

    private Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iban_send_animation);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
              ArrayList<String> gonder= (ArrayList<String>) getIntent().getExtras().getSerializable("pdf_key");
              Bundle bnd = new Bundle();
              bnd.putSerializable("pdf_key",gonder);
                Intent intent = new Intent(IbanSendAnimationActivity.this , SendDoneActivity.class);
                intent.putExtras(bnd);
                startActivity(intent);
                finish();
            }
        },3000);
    }
}