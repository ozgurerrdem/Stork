package com.example.stork.API.RequestWireToIban.Request;

import com.example.stork.MockAccount;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SourceAccount {
    @SerializedName("AccountSuffix")
    @Expose
    public Integer accountSuffix;
    @SerializedName("BranchCode")
    @Expose
    public Integer branchCode;
    @SerializedName("CustomerNo")
    @Expose
    public Integer customerNo;
    @SerializedName("CurrencyCode")
    @Expose
    public String currencyCode;

    public SourceAccount(int index) {
        this.accountSuffix = MockAccount.accounts.get(index).getAccountSuffix();
        this.branchCode = MockAccount.accounts.get(index).getBranchCode();
        this.customerNo = MockAccount.accounts.get(index).getCustomerNo();
        this.currencyCode = MockAccount.accounts.get(index).getCurrencyCode();
    }

    @Override
    public String toString() {
        return "SourceAccount{" +
                "accountSuffix=" + accountSuffix +
                ", branchCode=" + branchCode +
                ", customerNo=" + customerNo +
                ", currencyCode='" + currencyCode + '\'' +
                '}';
    }
}
