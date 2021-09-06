package com.example.stork.API.GetRate.Request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Parameters {
    @SerializedName("ExchangeBiddingTime")
    @Expose
    public String exchangeBiddingTime;
}
