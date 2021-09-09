package com.example.stork.API.GetReceiptData.Request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Parameters {
    @SerializedName("BranchCode")
    @Expose
    public Integer branchCode;
    @SerializedName("TransactionDate")
    @Expose
    public String transactionDate;
    @SerializedName("ReferenceNo")
    @Expose
    public Integer referenceNo;
    @SerializedName("CustomerNo")
    @Expose
    public Integer customerNo;
    @SerializedName("IsPdf")
    @Expose
    public Boolean isPdf;

    public Parameters(Integer branchCode, String transactionDate, Integer referenceNo, Integer customerNo, Boolean isPdf) {
        this.branchCode = branchCode;
        this.transactionDate = transactionDate;
        this.referenceNo = referenceNo;
        this.customerNo = customerNo;
        this.isPdf = isPdf;
    }
}
