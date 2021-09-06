package com.example.stork.API.GetRate.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Datum {

    @SerializedName("code")
    @Expose
    public String code;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("rate")
    @Expose
    public Float rate;
    @SerializedName("calculatedstr")
    @Expose
    public String calculatedstr;
    @SerializedName("calculated")
    @Expose
    public Float calculated;

}
