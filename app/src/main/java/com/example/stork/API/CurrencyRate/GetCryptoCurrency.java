package com.example.stork.API.CurrencyRate;



import com.example.stork.API.CurrencyRate.Response.Response;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface GetCryptoCurrency {


        @Headers({
                "authorization:apikey 6Sl11wyJMeXNsVslaXwF6f:3ciAPg6jZ1c9bCaY5RF7pB",
                "Content-Type:application/json"
        })
        @GET("cripto")
        Call<Response> GetPostValue();


}
