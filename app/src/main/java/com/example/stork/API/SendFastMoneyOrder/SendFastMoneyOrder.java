package com.example.stork.API.SendFastMoneyOrder;




import com.example.stork.API.SendFastMoneyOrder.Request.Request;
import com.example.stork.API.SendFastMoneyOrder.Response.Response;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface SendFastMoneyOrder {
    @Headers({
            "Ocp-Apim-Subscription-Key:e0c1fb1bcce341eaa372b754f7bba785",
            "Content-Type:application/json"
    })
    @POST("moneytransfers/SendFastMoneyOrder")
    Call<Response> GetPostValue(@Body Request Request);
}
