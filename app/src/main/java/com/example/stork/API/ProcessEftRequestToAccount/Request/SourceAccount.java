package com.example.stork.API.ProcessEftRequestToAccount.Request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SourceAccount {
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

}
