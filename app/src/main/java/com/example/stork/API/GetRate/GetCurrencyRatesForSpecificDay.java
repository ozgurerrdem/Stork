package com.example.stork.API.GetRate;

import com.example.stork.API.GetRate.Request.Request;
import com.example.stork.API.GetRate.Response.Response;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface GetCurrencyRatesForSpecificDay {
    @Headers({
            "Ocp-Apim-Subscription-Key:e0c1fb1bcce341eaa372b754f7bba785",
            "Content-Type:application/json"
    })
    @POST("exchange/GetCurrencyRatesForSpecificDay")
    Call<Response> GetPostValue(@Body Request Request);

}
