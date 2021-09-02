package com.example.stork.API.RequestWireToName.Request;

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

    public Integer getAccountSuffix() {
        return accountSuffix;
    }

    public void setAccountSuffix(Integer accountSuffix) {
        this.accountSuffix = accountSuffix;
    }

    public Integer getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(Integer branchCode) {
        this.branchCode = branchCode;
    }

    public Integer getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(Integer customerNo) {
        this.customerNo = customerNo;
    }

}
