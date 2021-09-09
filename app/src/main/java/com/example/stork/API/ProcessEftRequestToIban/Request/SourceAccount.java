package com.example.stork.API.ProcessEftRequestToIban.Request;


import com.example.stork.MockAccount;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class SourceAccount implements Serializable {
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


    public SourceAccount(int index) {
        this.accountSuffix = MockAccount.accounts.get(index).getAccountSuffix();
        this.branchCode = MockAccount.accounts.get(index).getBranchCode();
        this.customerNo = MockAccount.accounts.get(index).getCustomerNo();
        this.currencyCode = MockAccount.accounts.get(index).getCurrencyCode();
        this.iBANNo = MockAccount.accounts.get(index).getIBANNo();
        this.shortName ="";
    }
}

