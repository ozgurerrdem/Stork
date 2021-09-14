package com.example.stork.API.CurrencyRate;


import com.example.stork.API.CurrencyRate.GetCripto;
import com.example.stork.API.CurrencyRate.Response.Response;
import com.example.stork.Services;

import retrofit2.Call;
import retrofit2.Callback;

public class GetCripto {
    Services services = new Services();
    GetCryptoCurrency getCurrencyRatesForSpecificDay = services.createExchangeRetrofit().create(GetCryptoCurrency.class);

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
