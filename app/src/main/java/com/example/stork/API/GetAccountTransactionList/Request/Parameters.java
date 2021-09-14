package com.example.stork.API.GetAccountTransactionList.Request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Parameters {
    @SerializedName("SourceAccount")
    @Expose
    public SourceAccount sourceAccount;
    @SerializedName("QueryStartDate")
    @Expose
    public String queryStartDate;
    @SerializedName("QueryEndDate")
    @Expose
    public String queryEndDate;
    @SerializedName("QueryMinimumAmount")
    @Expose
    public Integer queryMinimumAmount;
    @SerializedName("QueryMaximumAmount")
    @Expose
    public Integer queryMaximumAmount;
    @SerializedName("ActivityCount")
    @Expose
    public Integer activityCount;
}
