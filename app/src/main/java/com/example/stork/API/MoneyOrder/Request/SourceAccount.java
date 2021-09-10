package com.example.stork.API.MoneyOrder.Request;

import com.example.stork.MockAccount;
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
    @SerializedName("CurrencyCode")
    @Expose
    public String currencyCode;

    public SourceAccount(int index) {
        this.accountSuffix = MockAccount.accounts.get(index).getAccountSuffix().toString();
        this.branchCode = MockAccount.accounts.get(index).getBranchCode().toString();
        this.customerNo = MockAccount.accounts.get(index).getCustomerNo().toString();
        this.currencyCode = MockAccount.accounts.get(index).getCurrencyCode();
    }
}