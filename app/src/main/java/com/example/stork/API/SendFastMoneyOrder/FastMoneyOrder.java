package com.example.stork.API.SendFastMoneyOrder;


import com.example.stork.API.Header;
import com.example.stork.API.SendFastMoneyOrder.Request.Parameters;
import com.example.stork.API.SendFastMoneyOrder.Request.Request;
import com.example.stork.API.SendFastMoneyOrder.Response.Response;
import com.example.stork.Services;

import retrofit2.Call;
import retrofit2.Callback;

public class FastMoneyOrder {
    Services services = new Services();
    SendFastMoneyOrder sendFastMoneyOrder = services.createRetrofit().create(SendFastMoneyOrder.class);

    public void getResponse (Parameters param, final Callback<Response> responseCallback){
        Call<Response> res = sendFastMoneyOrder.GetPostValue(new Request(new Header(),param));
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
