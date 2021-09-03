package com.example.stork.API.ExchangeRateApi.Response;

import com.google.gson.annotations.SerializedName;

public class Response {
    @SerializedName("success")
    public Boolean success;
    @SerializedName("timestamp")
    public Integer timestamp;
    @SerializedName("base")
    public String base;
    @SerializedName("date")
    public String date;
    @SerializedName("rates")
    public Rates rates;
}
