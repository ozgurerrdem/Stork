package com.example.stork.API.GoldRate;
import com.example.stork.API.GoldRate.Response.Response;
import com.example.stork.Services;

import retrofit2.Call;
import retrofit2.Callback;

public class GetGold {
    Services services = new Services();
    GetGoldRate getGoldRate = services.createExchangeRetrofit().create(GetGoldRate.class);

    public void getResponse (final Callback<Response> responseCallback){
        Call<Response> res = getGoldRate.GetPostValue();
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
