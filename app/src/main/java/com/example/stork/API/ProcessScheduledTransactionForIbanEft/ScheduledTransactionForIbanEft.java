package com.example.stork.API.ProcessScheduledTransactionForIbanEft;


import com.example.stork.API.Header;
import com.example.stork.API.ProcessScheduledTransactionForIbanEft.Request.Parameter;
import com.example.stork.API.ProcessScheduledTransactionForIbanEft.Request.Request;
import com.example.stork.API.ProcessScheduledTransactionForIbanEft.Response.Response;
import com.example.stork.Services;

import retrofit2.Call;
import retrofit2.Callback;

public class ScheduledTransactionForIbanEft {
    Services services = new Services();
    ProcessScheduledTransactionForIbanEft processScheduledTransactionForIbanEft = services.createRetrofit().create(ProcessScheduledTransactionForIbanEft.class);

    public void getResponse (Parameter param, final Callback<Response> responseCallback){
        Call<Response> res = processScheduledTransactionForIbanEft.GetPostValue(new Request(new Header(),param));
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
