package com.example.stork.API.ProcessEftRequestToAccount;
import com.example.stork.API.ProcessEftRequestToAccount.Request.Request;
import com.example.stork.API.ProcessEftRequestToAccount.Response.Response;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ProcessEftRequestToAccount {
    @Headers({
            "Ocp-Apim-Subscription-Key:18e42a2ed35549b4a09007722af387b1",
            "Content-Type:application/json"
    })
    @POST("moneytransfers/ProcessEftRequestToAccount")
    Call<Response> GetPostValue(@Body Request Request);
}
