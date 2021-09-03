package com.example.stork.API.ProcessScheduledTransactionForToAccountEft.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {
    @SerializedName("State")
    @Expose
    public String state;

    public String getState() {
        return state;
    }
}