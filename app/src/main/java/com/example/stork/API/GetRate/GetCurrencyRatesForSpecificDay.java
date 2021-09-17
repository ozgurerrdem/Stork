package com.example.stork.API.GetRate;

import com.example.stork.API.GetRate.Response.Response;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface GetCurrencyRatesForSpecificDay {
    @Headers({
            "authorization:apikey 6swZhsjdUQDjjVeLBIwrTm:5KqobMpvFl9wmkKeN0D6ir",
            "Content-Type:application/json"
    })
    @GET("allCurrency")
    Call<Response> GetPostValue();

}
