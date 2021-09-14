package com.example.stork.API.GetReceiptData;


import com.example.stork.API.GetReceiptData.Request.Parameters;
import com.example.stork.API.GetReceiptData.Request.Request;
import com.example.stork.API.GetReceiptData.Response.Response;
import com.example.stork.API.Header;
import com.example.stork.Services;

import retrofit2.Call;
import retrofit2.Callback;

public class ReceiptData {
    Services services = new Services();
    GetReceiptData getReceiptData = services.createRetrofit().create(GetReceiptData.class);

    public void getResponse (Parameters param, final Callback<Response> responseCallback){
        Call<Response> res = getReceiptData.GetPostValue(new Request(new Header(),param));
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
