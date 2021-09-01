package com.example.stork.API.ProcessEftRequestToIban.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {
    @SerializedName("$type")
    @Expose
    public String $type;

    public String get$type() {
        return $type;
    }

    public String getTransactionCode() {
        return transactionCode;
    }

    public Object getTransactionSavingToken() {
        return transactionSavingToken;
    }

    public Boolean getForceDuplicate() {
        return forceDuplicate;
    }

    public Float getExpenseAmount() {
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

    public Integer getQueryNumber() {
        return queryNumber;
    }

    public Integer getTransactionID() {
        return transactionID;
    }

    public Integer getState() {
        return state;
    }

    public Object getCreditInfoForConfirmations() {
        return creditInfoForConfirmations;
    }

    public Object getConfirmationToken() {
        return confirmationToken;
    }

    public Integer getRequiredConfirmationType() {
        return requiredConfirmationType;
    }

    public Object getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public Boolean getCanUserCommitTransaction() {
        return canUserCommitTransaction;
    }

    public Object getNpsSurveyGuid() {
        return npsSurveyGuid;
    }

    @SerializedName("TransactionCode")
    @Expose
    public String transactionCode;
    @SerializedName("TransactionSavingToken")
    @Expose
    public Object transactionSavingToken;
    @SerializedName("ForceDuplicate")
    @Expose
    public Boolean forceDuplicate;
    @SerializedName("ExpenseAmount")
    @Expose
    public Float expenseAmount;
    @SerializedName("SourceAccount")
    @Expose
    public SourceAccount sourceAccount;
    @SerializedName("TransactionDate")
    @Expose
    public String transactionDate;
    @SerializedName("AccountingReference")
    @Expose
    public String accountingReference;
    @SerializedName("QueryNumber")
    @Expose
    public Integer queryNumber;
    @SerializedName("TransactionID")
    @Expose
    public Integer transactionID;
    @SerializedName("State")
    @Expose
    public Integer state;
    @SerializedName("CreditInfoForConfirmations")
    @Expose
    public Object creditInfoForConfirmations;
    @SerializedName("ConfirmationToken")
    @Expose
    public Object confirmationToken;
    @SerializedName("RequiredConfirmationType")
    @Expose
    public Integer requiredConfirmationType;
    @SerializedName("MobilePhoneNumber")
    @Expose
    public Object mobilePhoneNumber;
    @SerializedName("CanUserCommitTransaction")
    @Expose
    public Boolean canUserCommitTransaction;
    @SerializedName("NpsSurveyGuid")
    @Expose
    public Object npsSurveyGuid;

}
