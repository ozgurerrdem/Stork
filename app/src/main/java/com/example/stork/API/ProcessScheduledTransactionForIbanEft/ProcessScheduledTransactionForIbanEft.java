package com.example.stork.API.ProcessScheduledTransactionForIbanEft;

import com.example.stork.API.ProcessScheduledTransactionForIbanEft.Request.Request;
import com.example.stork.API.ProcessScheduledTransactionForIbanEft.Response.Response;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ProcessScheduledTransactionForIbanEft {
    @Headers({
            "Ocp-Apim-Subscription-Key: ae040c4d3b784271a6791bb00d61428c",
            "Content-Type: application/json"
    })
    @POST("moneytransfers/ProcessScheduledTransactionForIbanEft")
    Call<Response> GetPostValue(@Body Request Request);
}
