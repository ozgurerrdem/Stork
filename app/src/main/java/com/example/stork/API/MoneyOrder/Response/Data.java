package com.example.stork.API.MoneyOrder.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("AccountingReference")
    @Expose
    public String accountingReference;
    @SerializedName("State")
    @Expose
    public String state;

}
