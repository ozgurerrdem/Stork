package com.example.stork.API.AccList.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Response {
    @SerializedName("$type")
    @Expose
    public String $type;
    @SerializedName("Data")
    @Expose
    public Data data;

    @SerializedName("Error")
    public Error error;

    public String get$type() {
        return $type;
    }

    public Data getData() {
        return data;
    }
}
