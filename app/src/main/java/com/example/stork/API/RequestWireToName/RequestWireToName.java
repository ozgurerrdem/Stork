package com.example.stork.API.RequestWireToName;

import com.example.stork.API.RequestWireToName.Request.Request;
import com.example.stork.API.RequestWireToName.Response.Response;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface RequestWireToName {
    @Headers({
            "Ocp-Apim-Subscription-Key: ae040c4d3b784271a6791bb00d61428c",
            "Content-Type:application/json"
    })
    @POST("moneytransfers/RequestWireToName")
    Call<Response> GetPostValue(@Body Request Request);
}
