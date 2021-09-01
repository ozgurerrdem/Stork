package com.example.stork.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

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



    }


}