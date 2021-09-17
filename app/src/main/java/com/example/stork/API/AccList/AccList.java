package com.example.stork.API.AccList;

import com.example.stork.API.AccList.Request.Parameters;
import com.example.stork.API.AccList.Request.Request;
import com.example.stork.API.AccList.Response.Response;
import com.example.stork.API.Header;
import com.example.stork.Services;

import retrofit2.Call;
import retrofit2.Callback;

public class AccList {
    Services services = new Services();
    GetAccList processEftRequestToIban = services.createRetrofit().create(GetAccList.class);

    public void getResponse (Parameters param, final Callback<Response> responseCallback){
        Call<Response> res = processEftRequestToIban.GetPostValue(new Request(new Header(),param));
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
