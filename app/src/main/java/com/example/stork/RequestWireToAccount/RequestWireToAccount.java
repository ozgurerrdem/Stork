package com.example.stork.RequestWireToAccount;


import com.example.stork.RequestWireToAccount.Request.Request;

import okhttp3.Response;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface RequestWireToAccount {
    @Headers({
            "Ocp-Apim-Subscription-Key: ae040c4d3b784271a6791bb00d61428c",
            "Content-Type:application/json"
    })
    @POST("moneytransfers/RequestWireToAccount")
    Call<Response> GetPostValue(@Body Request Request);
}
