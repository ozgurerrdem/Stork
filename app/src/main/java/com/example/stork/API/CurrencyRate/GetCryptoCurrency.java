package com.example.stork.API.CurrencyRate;



import com.example.stork.API.CurrencyRate.Response.Response;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface GetCryptoCurrency {


        @Headers({
                "authorization:apikey 6swZhsjdUQDjjVeLBIwrTm:5KqobMpvFl9wmkKeN0D6ir",
                "Content-Type:application/json"
        })
        @GET("cripto")
        Call<Response> GetPostValue();


}
