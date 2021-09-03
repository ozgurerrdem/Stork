package com.example.stork.API.ExchangeRateApi;

import com.example.stork.API.ExchangeRateApi.Response.Response;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ExchangeRateApi {
    @GET("latest?access_key=da476dc127e079dbceef6dc49b076868&symbols=TRY,USD")
    Call<Response> GetCurrencyValues();
}
