package com.example.stork.API.ProcessEftRequestToAccount.Request;

import com.example.stork.MockAccount;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SourceAccount {

    @SerializedName("AccountName")
    @Expose
    public String accountName;
    @SerializedName("AccountSuffix")
    @Expose
    public Integer accountSuffix;
    @SerializedName("BranchCode")
    @Expose
    public Integer branchCode;
    @SerializedName("CustomerNo")
    @Expose
    public Integer customerNo;
    @SerializedName("IBANNo")
    @Expose
    public String iBANNo;
    @SerializedName("ShortName")
    @Expose
    public String shortName;

    public SourceAccount(int index, String name) {
        this.accountName = name;
        this.accountSuffix = MockAccount.accounts.get(index).getAccountSuffix();
        this.branchCode = MockAccount.accounts.get(index).getBranchCode();
        this.customerNo = MockAccount.accounts.get(index).getCustomerNo();
        this.iBANNo = "-";
        this.shortName ="-";
    }
}
