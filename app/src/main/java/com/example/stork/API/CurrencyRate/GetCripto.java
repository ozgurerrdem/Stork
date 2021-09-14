package com.example.stork.API.CurrencyRate;

import com.example.stork.API.CurrencyRate.Response.Response;
import com.example.stork.Services;

import retrofit2.Call;
import retrofit2.Callback;

public class GetCripto {

    Services services = new Services();
    GetCryptoCurrency getCryptoCurrency = services.createExchangeRetrofit().create(GetCryptoCurrency.class);

    public void getResponse (final Callback<com.example.stork.API.CurrencyRate.Response.Response> responseCallback){
        Call<com.example.stork.API.CurrencyRate.Response.Response> res = getCryptoCurrency.GetPostValue();
        res.enqueue(new Callback<com.example.stork.API.CurrencyRate.Response.Response>() {
            @Override
            public void onResponse(Call<com.example.stork.API.CurrencyRate.Response.Response> call, retrofit2.Response<com.example.stork.API.CurrencyRate.Response.Response> response) {
                responseCallback.onResponse(call,response);
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {

            }
        });
    }
}
