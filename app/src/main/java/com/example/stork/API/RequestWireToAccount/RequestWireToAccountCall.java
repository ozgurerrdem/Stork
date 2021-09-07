package com.example.stork.API.RequestWireToAccount;

import com.example.stork.API.RequestWireToAccount.Request.Parameters;
import com.example.stork.API.RequestWireToAccount.Request.Request;
import com.example.stork.API.RequestWireToAccount.Response.Response;
import com.example.stork.Services;

import retrofit2.Call;
import retrofit2.Callback;

public class RequestWireToAccountCall {

    public static void requestWireToAccount(Request request){
        Services services = new Services();
        RequestWireToAccount req = services.createRetrofit().create(RequestWireToAccount.class);

        Call<Response> res = req.GetPostValue(request);
        res.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {

            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {

            }
        });
    }



}
