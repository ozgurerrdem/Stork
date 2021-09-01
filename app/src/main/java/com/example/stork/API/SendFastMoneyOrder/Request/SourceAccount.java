package com.example.stork.API.SendFastMoneyOrder.Request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SourceAccount {
    @SerializedName("AccountSuffix")
    @Expose
    public Integer accountSuffix;
    @SerializedName("BranchCode")
    @Expose
    public Integer branchCode;
    @SerializedName("CustomerNo")
    @Expose
    public Integer customerNo;
    @SerializedName("CurrencyCode")
    @Expose
    public String currencyCode;
    @SerializedName("IBANNo")
    @Expose
    public String iBANNo;
}
