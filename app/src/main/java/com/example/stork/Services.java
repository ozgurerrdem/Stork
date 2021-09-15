package com.example.stork;


import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Services {
    public Retrofit createRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://api-gateway.intertech.com.tr/BankingApiV01/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public Retrofit createExchangeRetrofit(){
        return new Retrofit.Builder()
                .baseUrl("https://api.collectapi.com/economy/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
    }
    public String getBankCode(String iban){
        return iban.substring(5,9);
    }
    public boolean compareBanksByIban (String iban1, String iban2){
        return getBankCode(iban1).equals(getBankCode(iban2));
    }
    public static String getCurrentTimeStamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
    }
}
