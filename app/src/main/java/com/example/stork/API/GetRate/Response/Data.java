package com.example.stork.API.GetRate.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {
    @SerializedName("QueryDate")
    @Expose
    public String queryDate;
    @SerializedName("BranchCode")
    @Expose
    public String branchCode;
    @SerializedName("UserName")
    @Expose
    public String userName;
    @SerializedName("Rates")
    @Expose
    public List<Rate> rates = null;
    @SerializedName("IsQueryForCentralBankRates")
    @Expose
    public String isQueryForCentralBankRates;
}
