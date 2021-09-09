package com.example.stork.API.RequestWireToName.Request;

import com.example.stork.MockAccount;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SourceAccount {
    @SerializedName("AccountSuffix")
    @Expose
    private Integer accountSuffix;
    @SerializedName("BranchCode")
    @Expose
    private Integer branchCode;
    @SerializedName("CustomerNo")
    @Expose
    private Integer customerNo;

    public SourceAccount(int index) {
        this.accountSuffix = MockAccount.accounts.get(index).getAccountSuffix();
        this.branchCode = MockAccount.accounts.get(index).getBranchCode();
        this.customerNo = MockAccount.accounts.get(index).getCustomerNo();
    }
}
