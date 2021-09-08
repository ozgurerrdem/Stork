package com.example.stork.API.MoneyOrder;

import com.example.stork.API.MoneyOrder.Request.Request;
import com.example.stork.API.MoneyOrder.Response.Response;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface MoneyOrder {
    @Headers({
            "Ocp-Apim-Subscription-Key:e0c1fb1bcce341eaa372b754f7bba785",
            "Content-Type:application/json"
    })
    @POST("moneytransfers/MoneyOrder")
    Call<Response> GetPostValue(@Body Request Request);
}
