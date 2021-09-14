package com.example.stork.API.GetRate.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Result {

    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("buying")
    @Expose
    public String buying;
    @SerializedName("selling")
    @Expose
    public String selling;

}
