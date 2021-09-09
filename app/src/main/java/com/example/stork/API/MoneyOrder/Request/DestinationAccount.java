package com.example.stork.API.MoneyOrder.Request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DestinationAccount {

    @SerializedName("BranchCode")
    @Expose
    public String branchCode;
    @SerializedName("AccountSuffix")
    @Expose
    public String accountSuffix;

    public DestinationAccount(String branchCode, String accountSuffix) {
        this.branchCode = branchCode;
        this.accountSuffix = accountSuffix;
    }
}

