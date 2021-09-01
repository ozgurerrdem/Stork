package com.example.stork.API.RequestWireToAccount.Response;

import com.google.gson.annotations.SerializedName;

public class SourceAccount2 {

    @SerializedName("$type")
    public String $type;
    @SerializedName("AccountSuffix")
    public Integer accountSuffix;
    @SerializedName("BranchCode")
    public Integer branchCode;
    @SerializedName("CustomerNo")
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