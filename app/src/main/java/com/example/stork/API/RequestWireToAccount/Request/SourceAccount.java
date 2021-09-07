package com.example.stork.API.RequestWireToAccount.Request;

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

    public SourceAccount(Integer accountSuffix, Integer branchCode, Integer customerNo, String currencyCode) {
        this.accountSuffix = accountSuffix;
        this.branchCode = branchCode;
        this.customerNo = customerNo;
        this.currencyCode = currencyCode;
    }
}