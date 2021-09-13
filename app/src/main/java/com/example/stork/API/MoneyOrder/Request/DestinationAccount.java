package com.example.stork.API.MoneyOrder.Request;

import com.example.stork.MockAccount;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DestinationAccount {

    @SerializedName("BranchCode")
    @Expose
    public String branchCode;
    @SerializedName("AccountSuffix")
    @Expose
    public String accountSuffix;

    public DestinationAccount(int index) {
        this.branchCode = MockAccount.accounts.get(index).getBranchCode().toString();
        this.accountSuffix = MockAccount.accounts.get(index).getAccountSuffix().toString();
    }
}

