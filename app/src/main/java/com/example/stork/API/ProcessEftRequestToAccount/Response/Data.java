package com.example.stork.API.ProcessEftRequestToAccount.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {
    @SerializedName("$type")
    @Expose
    private String $type;
    @SerializedName("TransactionCode")
    @Expose
    private String transactionCode;
    @SerializedName("ForceDuplicate")
    @Expose
    private Boolean forceDuplicate;
    @SerializedName("ExpenseAmount")
    @Expose
    private Double expenseAmount;
    @SerializedName("SourceAccount")
    @Expose
    private SourceAccount sourceAccount;
    @SerializedName("TransactionDate")
    @Expose
    private String transactionDate;
    @SerializedName("AccountingReference")
    @Expose
    private String accountingReference;
    @SerializedName("TransactionID")
    @Expose
    private Integer transactionID;
    @SerializedName("State")
    @Expose
    private Integer state;

    public String get$type() {
        return $type;
    }

    public String getTransactionCode() {
        return transactionCode;
    }

    public Boolean getForceDuplicate() {
        return forceDuplicate;
    }

    public Double getExpenseAmount() {
        return expenseAmount;
    }

    public SourceAccount getSourceAccount() {
        return sourceAccount;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public String getAccountingReference() {
        return accountingReference;
    }

    public Integer getTransactionID() {
        return transactionID;
    }

    public Integer getState() {
        return state;
    }
}