package com.example.stork.API.GetRate;


import com.example.stork.API.GetRate.GetCurrencyRatesForSpecificDay;
import com.example.stork.API.GetRate.Response.Response;
import com.example.stork.Services;

import retrofit2.Call;
import retrofit2.Callback;

public class GetRate {
    Services services = new Services();
    GetCurrencyRatesForSpecificDay getCurrencyRatesForSpecificDay = services.createExchangeRetrofit().create(GetCurrencyRatesForSpecificDay.class);

    public void getResponse (final Callback<Response> responseCallback){
        Call<Response> res = getCurrencyRatesForSpecificDay.GetPostValue();
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
