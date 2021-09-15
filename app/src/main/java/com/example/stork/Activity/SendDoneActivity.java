package com.example.stork.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.stork.API.GetReceiptData.Request.Parameters;
import com.example.stork.R;

public class SendDoneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_done);
        ImageButton backButton = findViewById(R.id.receive_money_screen_back_btn);
        Button homepage = findViewById(R.id.go_to_hp);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

            }
        });
        homepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SendDoneActivity.this,MainActivity.class));

            }
        });

        ImageButton pdfButton = findViewById(R.id.pdf_button);
        pdfButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("pdf_key",(Parameters) getIntent().getExtras().get("pdf_key"));
                Intent intent = new Intent(getApplicationContext(), PdfActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}