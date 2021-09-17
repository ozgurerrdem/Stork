package com.example.stork.API.GoldRate;

import com.example.stork.API.GoldRate.Response.Response;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface GetGoldRate {
    @Headers({
            "authorization:apikey 6swZhsjdUQDjjVeLBIwrTm:5KqobMpvFl9wmkKeN0D6ir",
            "Content-Type:application/json"
    })
    @GET("goldPrice")
    Call<Response> GetPostValue();


}
