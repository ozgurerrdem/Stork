package com.example.stork.API.ProcessEftRequestToIban;




import com.example.stork.API.ProcessEftRequestToIban.Request.Request;

import okhttp3.Response;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ProcessEftRequestToIban {
    @Headers({
            "Ocp-Apim-Subscription-Key:e0c1fb1bcce341eaa372b754f7bba785",
            "Content-Type:application/json"
    })
    @POST("moneytransfers/ProcessEftRequestToIban")
    Call<Response> GetPostValue(@Body Request Request);
}
