package com.example.stork.API.ProcessEftRequestToIban.Request;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class SourceAccount implements Serializable {
    @SerializedName("AccountSuffix")
    @Expose
    public Integer accountSuffix;
    @SerializedName("BranchCode")
    @Expose
    public Integer branchCode;
    @SerializedName("CurrencyCode")
    @Expose
    public String currencyCode;
    @SerializedName("CustomerNo")
    @Expose
    public Integer customerNo;
    @SerializedName("IBANNo")
    @Expose
    public String iBANNo;
    @SerializedName("ShortName")
    @Expose
    public String shortName;


    public SourceAccount(Integer accountSuffix, Integer branchCode, String currencyCode, Integer customerNo, String iBANNo, String shortName) {
        this.accountSuffix = accountSuffix;
        this.branchCode = branchCode;
        this.currencyCode = currencyCode;
        this.customerNo = customerNo;
        this.iBANNo = iBANNo;
        this.shortName = shortName;
    }
}

