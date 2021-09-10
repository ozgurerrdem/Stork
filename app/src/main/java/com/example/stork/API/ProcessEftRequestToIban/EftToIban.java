package com.example.stork.API.ProcessEftRequestToIban;


import com.example.stork.API.Header;
import com.example.stork.API.ProcessEftRequestToIban.Request.Parameters;
import com.example.stork.API.ProcessEftRequestToIban.Request.Request;
import com.example.stork.API.ProcessEftRequestToIban.Response.Response;
import com.example.stork.Services;

import retrofit2.Call;
import retrofit2.Callback;

public class EftToIban {
    Services services = new Services();
    ProcessEftRequestToIban processEftRequestToIban = services.createRetrofit().create(ProcessEftRequestToIban.class);

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
