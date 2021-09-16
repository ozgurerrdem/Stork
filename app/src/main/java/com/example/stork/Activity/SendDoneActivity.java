package com.example.stork.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.stork.API.GetReceiptData.Request.Parameters;
import com.example.stork.R;

import java.util.ArrayList;

public class SendDoneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_done);
        ImageButton backButton = findViewById(R.id.receive_money_screen_back_btn);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

            }
        });

        Button ana = findViewById(R.id.ana_sayfa);
        ana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });

        ImageButton pdfButton = findViewById(R.id.pdf_button);
        pdfButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("pdf_key",(ArrayList<String>) getIntent().getExtras().get("pdf_key"));
                Intent intent = new Intent(getApplicationContext(), TransactionsDetailsActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}