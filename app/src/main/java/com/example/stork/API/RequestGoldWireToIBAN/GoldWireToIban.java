package com.example.stork.API.RequestGoldWireToIBAN;


import com.example.stork.API.Header;
import com.example.stork.API.RequestGoldWireToIBAN.Request.Parameters;
import com.example.stork.API.RequestGoldWireToIBAN.Request.Request;
import com.example.stork.API.RequestGoldWireToIBAN.Response.Response;
import com.example.stork.Services;

import retrofit2.Call;
import retrofit2.Callback;

public class GoldWireToIban {
    Services services = new Services();
    RequestGoldWireToIBAN requestGoldWireToIBAN = services.createRetrofit().create(RequestGoldWireToIBAN.class);

    public void getResponse (Parameters param, final Callback<Response> responseCallback){
        Call<Response> res = requestGoldWireToIBAN.GetPostValue(new Request(new Header(),param));
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
