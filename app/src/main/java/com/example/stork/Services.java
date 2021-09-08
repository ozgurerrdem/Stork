package com.example.stork;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Services {
    public Retrofit createRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://api-gateway.intertech.com.tr/BankingApiV01/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
