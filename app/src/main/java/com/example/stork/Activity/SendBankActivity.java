package com.example.stork.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.stork.API.ProcessEftRequestToIban.Request.Header;
import com.example.stork.API.SendFastMoneyOrder.Request.Parameters;
import com.example.stork.API.SendFastMoneyOrder.Request.Request;
import com.example.stork.API.SendFastMoneyOrder.Request.SourceAccount;
import com.example.stork.API.SendFastMoneyOrder.Response.Response;
import com.example.stork.API.SendFastMoneyOrder.SendFastMoneyOrder;
import com.example.stork.R;
import com.example.stork.Services;

import retrofit2.Call;
import retrofit2.Callback;

public class SendBankActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_bank);
        Button new_adress=findViewById(R.id.new_adress);

        new_adress.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(SendBankActivity.this,MoneyTransferActivity.class));
            }
        });

    }


}