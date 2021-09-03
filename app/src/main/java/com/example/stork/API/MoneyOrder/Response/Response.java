package com.example.stork.API.MoneyOrder.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Response {
    @SerializedName("Data")
    @Expose
    public Data data;

    public Data getData() {
        return data;
    }
}
