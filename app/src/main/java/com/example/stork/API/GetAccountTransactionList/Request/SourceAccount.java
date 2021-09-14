package com.example.stork.API.GetAccountTransactionList.Request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SourceAccount {
    @SerializedName("BranchCode")
    @Expose
    public String branchCode;
    @SerializedName("CustomerNo")
    @Expose
    public String customerNo;
    @SerializedName("AccountSuffix")
    @Expose
    public String accountSuffix;
}
