package com.example.stork.API.GetRate;

import com.example.stork.API.GetRate.Response.Response;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface GetCurrencyRatesForSpecificDay {
    @Headers({
            "authorization:apikey 3eEmam7XKXmCtLoVY4IXwi:1RzSJvjIHhPY8sQcM4W6NT",
            "Content-Type:application/json"
    })
    @GET("currencyToAll?int=10&base=TRY")
    Call<Response> GetPostValue();

}
