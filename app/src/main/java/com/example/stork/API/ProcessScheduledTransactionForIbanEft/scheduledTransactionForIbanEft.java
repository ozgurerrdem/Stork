package com.example.stork.API.ProcessScheduledTransactionForIbanEft;


import com.example.stork.API.ProcessScheduledTransactionForIbanEft.ProcessScheduledTransactionForIbanEft;
import com.example.stork.API.ProcessScheduledTransactionForIbanEft.Request.Header;
import com.example.stork.API.ProcessScheduledTransactionForIbanEft.Request.Parameter;
import com.example.stork.API.ProcessScheduledTransactionForIbanEft.Request.Request;
import com.example.stork.API.ProcessScheduledTransactionForIbanEft.Response.Response;
import com.example.stork.Services;

import retrofit2.Call;
import retrofit2.Callback;

public class scheduledTransactionForIbanEft {
    Services services = new Services();
    ProcessScheduledTransactionForIbanEft processScheduledTransactionForIbanEft = services.createRetrofit().create(ProcessScheduledTransactionForIbanEft.class);

    public void getResponse (Parameter param, final Callback<Response> responseCallback){
        Header header = new Header("c1c2a508fdf64c14a7b44edc9241c9cd","API","331eb5f529c74df2b800926b5f34b874","a9058690-a286-40b7-b610-dbf477201501");
        Call<Response> res = processScheduledTransactionForIbanEft.GetPostValue(new Request(header,param));
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
