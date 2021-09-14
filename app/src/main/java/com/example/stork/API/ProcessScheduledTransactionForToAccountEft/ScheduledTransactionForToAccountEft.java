package com.example.stork.API.ProcessScheduledTransactionForToAccountEft;


import com.example.stork.API.Header;
import com.example.stork.API.ProcessScheduledTransactionForToAccountEft.Request.Parameters;
import com.example.stork.API.ProcessScheduledTransactionForToAccountEft.Request.Request;
import com.example.stork.API.ProcessScheduledTransactionForToAccountEft.Response.Response;
import com.example.stork.Services;

import retrofit2.Call;
import retrofit2.Callback;

public class ScheduledTransactionForToAccountEft {
    Services services = new Services();
    ProcessScheduledTransactionForToAccountEft processScheduledTransactionForToAccountEft = services.createRetrofit().create(ProcessScheduledTransactionForToAccountEft.class);

    public void getResponse (Parameters param, final Callback<Response> responseCallback){
        Call<Response> res = processScheduledTransactionForToAccountEft.GetPostValue(new Request(new Header(),param));
        res.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                responseCallback.onResponse(call,response);
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {

            }
        });
    }
}
