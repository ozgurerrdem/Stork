package com.example.stork.AccList;

import com.example.stork.AccList.Request.Request;
import com.example.stork.AccList.Response.Response;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface GetAccList {

    @Headers({
            "Ocp-Apim-Subscription-Key: ae040c4d3b784271a6791bb00d61428c",
            "Content-Type:application/json"
    })
    @POST("Accounts/GetAccountList")
    Call<Response> GetPostValue(@Body Request Request);
}
