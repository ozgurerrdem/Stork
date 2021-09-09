package com.example.stork.API.RequestWireToAccount.Request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DestinationAccount {
    @SerializedName("AccountSuffix")
    @Expose
    public Integer accountSuffix;
    @SerializedName("BranchCode")
    @Expose
    public Integer branchCode;
    @SerializedName("CustomerNo")
    @Expose
    public Integer customerNo;

    public DestinationAccount(Integer accountSuffix, Integer branchCode, Integer customerNo) {
        this.accountSuffix = accountSuffix;
        this.branchCode = branchCode;
        this.customerNo = customerNo;

    }
}
