package com.example.stork.API.RequestWireToName.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {
    @SerializedName("$type")
    @Expose
    private String $type;
    @SerializedName("State")
    @Expose
    private Integer state;

    public String get$type() {
        return $type;
    }

    public void set$type(String $type) {
        this.$type = $type;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

}
