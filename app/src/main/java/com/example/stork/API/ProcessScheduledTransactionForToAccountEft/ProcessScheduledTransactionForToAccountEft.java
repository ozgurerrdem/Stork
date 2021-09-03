package com.example.stork.API.ProcessScheduledTransactionForToAccountEft;

import com.example.stork.API.AccList.Request.Request;
import com.example.stork.API.AccList.Response.Response;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ProcessScheduledTransactionForToAccountEft {
    @Headers({
            "Ocp-Apim-Subscription-Key:e0c1fb1bcce341eaa372b754f7bba785",
            "Content-Type:application/json"
    })
    @POST("ProcessScheduledTransactionForToAccountEft")
    Call<Response> GetPostValue(@Body Request Request);

}

