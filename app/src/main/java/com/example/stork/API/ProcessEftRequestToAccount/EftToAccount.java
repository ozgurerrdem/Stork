package com.example.stork.API.ProcessEftRequestToAccount;


import com.example.stork.API.Header;
import com.example.stork.API.ProcessEftRequestToAccount.Request.Parameters;
import com.example.stork.API.ProcessEftRequestToAccount.Request.Request;
import com.example.stork.API.ProcessEftRequestToAccount.Response.Response;
import com.example.stork.Services;

import retrofit2.Call;
import retrofit2.Callback;

public class EftToAccount {
    Services services = new Services();
    ProcessEftRequestToAccount processEftRequestToIban = services.createRetrofit().create(ProcessEftRequestToAccount.class);

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
