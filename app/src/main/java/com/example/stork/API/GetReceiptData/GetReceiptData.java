package com.example.stork.API.GetReceiptData;

import com.example.stork.API.GetReceiptData.Request.Request;
import com.example.stork.API.GetReceiptData.Response.Response;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface GetReceiptData {
    @Headers({
            "Ocp-Apim-Subscription-Key:e0c1fb1bcce341eaa372b754f7bba785",
            "Content-Type:application/json"
    })
    @POST("customers/GetReceiptData")
    Call<Response> GetPostValue(@Body Request Request);

}
