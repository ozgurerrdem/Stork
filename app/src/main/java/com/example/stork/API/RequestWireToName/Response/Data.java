package com.example.stork.API.RequestWireToName.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {
    @SerializedName("$type")
    @Expose
    private String $type;
    @SerializedName("TransactionCode")
    @Expose
    private String transactionCode;
    @SerializedName("TransactionSavingToken")
    @Expose
    private Object transactionSavingToken;
    @SerializedName("ForceDuplicate")
    @Expose
    private Boolean forceDuplicate;
    @SerializedName("ExpenseAmount")
    @Expose
    private Double expenseAmount;
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
    @SerializedName("ConfirmationToken")
    @Expose
    private Object confirmationToken;
    @SerializedName("RequiredConfirmationType")
    @Expose
    private Integer requiredConfirmationType;
    @SerializedName("MobilePhoneNumber")
    @Expose
    private Object mobilePhoneNumber;
    @SerializedName("NpsSurveyGuid")
    @Expose
    private Object npsSurveyGuid;

    public String get$type() {
        return $type;
    }

    public void set$type(String $type) {
        this.$type = $type;
    }

    public String getTransactionCode() {
        return transactionCode;
    }

    public void setTransactionCode(String transactionCode) {
        this.transactionCode = transactionCode;
    }

    public Object getTransactionSavingToken() {
        return transactionSavingToken;
    }

    public void setTransactionSavingToken(Object transactionSavingToken) {
        this.transactionSavingToken = transactionSavingToken;
    }

    public Boolean getForceDuplicate() {
        return forceDuplicate;
    }

    public void setForceDuplicate(Boolean forceDuplicate) {
        this.forceDuplicate = forceDuplicate;
    }

    public Double getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(Double expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getAccountingReference() {
        return accountingReference;
    }

    public void setAccountingReference(String accountingReference) {
        this.accountingReference = accountingReference;
    }

    public Integer getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(Integer transactionID) {
        this.transactionID = transactionID;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Object getConfirmationToken() {
        return confirmationToken;
    }

    public void setConfirmationToken(Object confirmationToken) {
        this.confirmationToken = confirmationToken;
    }

    public Integer getRequiredConfirmationType() {
        return requiredConfirmationType;
    }

    public void setRequiredConfirmationType(Integer requiredConfirmationType) {
        this.requiredConfirmationType = requiredConfirmationType;
    }

    public Object getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(Object mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public Object getNpsSurveyGuid() {
        return npsSurveyGuid;
    }

    public void setNpsSurveyGuid(Object npsSurveyGuid) {
        this.npsSurveyGuid = npsSurveyGuid;
    }

}
