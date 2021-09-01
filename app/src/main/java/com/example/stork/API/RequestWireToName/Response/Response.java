package com.example.stork.API.RequestWireToName.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Response {
    @SerializedName("$type")
    @Expose
    private String $type;
    @SerializedName("Data")
    @Expose
    private Data data;

    public String get$type() {
        return $type;
    }

    public void set$type(String $type) {
        this.$type = $type;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
