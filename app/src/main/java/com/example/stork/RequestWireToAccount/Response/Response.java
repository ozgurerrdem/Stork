package com.example.stork.RequestWireToAccount.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Response {


    @SerializedName("Data")
    public Data data;
    public Data getData() {
        return data;
    }
}