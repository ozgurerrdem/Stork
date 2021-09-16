package com.example.stork.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.stork.API.GetReceiptData.Request.Parameters;
import com.example.stork.API.RequestWireToIban.Response.Data;
import com.example.stork.MockAccount;
import com.example.stork.R;

import java.util.ArrayList;

public class TransactionsDetailsActivity extends AppCompatActivity {
    private Button transactions_confirm;
    private TextView gonderici_hesap;
    private TextView alici_hesap_Adi;
    private TextView gonderim_miktari;
    private TextView kalan_bakiye;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transactions_details);

        gonderici_hesap=findViewById(R.id.gonderici_hesap);
        alici_hesap_Adi=findViewById(R.id.alici_hesap_Adi);
        gonderim_miktari=findViewById(R.id.gonderim_miktari);
        kalan_bakiye=findViewById(R.id.kalan_bakiye);
        ArrayList<String> data = (ArrayList<String>) getIntent().getExtras().getSerializable("pdf_key");

        gonderici_hesap.setText("10");
        alici_hesap_Adi.setText(data.get(0).toString());
        gonderim_miktari.setText(data.get(1).toString());
        kalan_bakiye.setText(MockAccount.accounts.get(5).getAmountOfBalance().toString());

        transactions_confirm = findViewById(R.id.transactions_confirm);
        transactions_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(TransactionsDetailsActivity.this, MainActivity.class));
            }
        });
    }
}