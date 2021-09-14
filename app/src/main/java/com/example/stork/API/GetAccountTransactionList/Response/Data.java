package com.example.stork.API.GetAccountTransactionList.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {
    @SerializedName("$type")
    @Expose
    public String $type;
    @SerializedName("ActivityCollection")
    @Expose
    public List<Object> activityCollection = null;
}
