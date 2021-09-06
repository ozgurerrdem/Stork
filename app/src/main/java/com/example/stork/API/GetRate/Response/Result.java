package com.example.stork.API.GetRate.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Result {

    @SerializedName("base")
    @Expose
    public String base;
    @SerializedName("lastupdate")
    @Expose
    public String lastupdate;
    @SerializedName("data")
    @Expose
    public List<Datum> data = null;

}
