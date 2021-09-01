package com.example.stork.API.RequestWireToIban.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SourceAccount {
    @SerializedName("$type")
    @Expose
    public String $type;
    @SerializedName("AccountSuffix")
    @Expose
    public Integer accountSuffix;
    @SerializedName("BranchCode")
    @Expose
    public Integer branchCode;
    @SerializedName("CustomerNo")
    @Expose
    public Integer customerNo;

    public String get$type() {
        return $type;
    }

    public Integer getAccountSuffix() {
        return accountSuffix;
    }

    public Integer getBranchCode() {
        return branchCode;
    }

    public Integer getCustomerNo() {
        return customerNo;
    }
}
