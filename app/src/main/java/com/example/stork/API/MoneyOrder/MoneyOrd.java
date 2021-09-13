package com.example.stork.API.MoneyOrder;


import com.example.stork.API.Header;
import com.example.stork.API.MoneyOrder.Request.Parameters;
import com.example.stork.API.MoneyOrder.Request.Request;
import com.example.stork.API.MoneyOrder.Response.Response;
import com.example.stork.Services;

import retrofit2.Call;
import retrofit2.Callback;

public class MoneyOrd {
    Services services = new Services();
    MoneyOrder moneyOrder = services.createRetrofit().create(MoneyOrder.class);

    public void getResponse (Parameters param, final Callback<Response> responseCallback){
        Call<Response> res = moneyOrder.GetPostValue(new Request(new Header(),param));
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
