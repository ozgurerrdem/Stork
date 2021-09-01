package com.example.stork.API.RequestWireToIban.Response;

import com.google.gson.annotations.SerializedName;

public class Response {
    @SerializedName("$type")
    public String $type;

    @SerializedName("Data")
    public Data data;

    public String get$type() {
        return $type;
    }

    public Data getData() {
        return data;
    }
}
