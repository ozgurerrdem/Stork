package com.example.stork.API.GoldRate.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("buy")
    @Expose
    public String buy;
    @SerializedName("sell")
    @Expose
    public String sell;
}
