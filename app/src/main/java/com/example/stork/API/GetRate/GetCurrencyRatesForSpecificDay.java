package com.example.stork.API.GetRate;

import com.example.stork.API.GetRate.Response.Response;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface GetCurrencyRatesForSpecificDay {
    @Headers({
            "authorization:apikey 6Sl11wyJMeXNsVslaXwF6f:3ciAPg6jZ1c9bCaY5RF7pB",
            "Content-Type:application/json"
    })
    @GET("allCurrency")
    Call<Response> GetPostValue();

}
