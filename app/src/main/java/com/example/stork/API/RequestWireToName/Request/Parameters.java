package com.example.stork.API.RequestWireToName.Request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Parameters {
    @SerializedName("DestinationBranchCode")
    @Expose
    private Integer destinationBranchCode;
    @SerializedName("DestinationName")
    @Expose
    private String destinationName;
    @SerializedName("DestinationLastName")
    @Expose
    private String destinationLastName;
    @SerializedName("DestinationPhoneNo")
    @Expose
    private String destinationPhoneNo;
    @SerializedName("DestinationMotherName")
    @Expose
    private String destinationMotherName;
    @SerializedName("DestinationFatherName")
    @Expose
    private String destinationFatherName;
    @SerializedName("DestinationBirthDate")
    @Expose
    private String destinationBirthDate;
    @SerializedName("ReceiverName")
    @Expose
    private String receiverName;
    @SerializedName("ForceDuplicate")
    @Expose
    private Boolean forceDuplicate;
    @SerializedName("CustomerNo")
    @Expose
    private Integer customerNo;
    @SerializedName("Amount")
    @Expose
    private Integer amount;
    @SerializedName("Explanation")
    @Expose
    private String explanation;
    @SerializedName("SourceAccount")
    @Expose
    private SourceAccount sourceAccount;

    public Integer getDestinationBranchCode() {
        return destinationBranchCode;
    }

    public void setDestinationBranchCode(Integer destinationBranchCode) {
        this.destinationBranchCode = destinationBranchCode;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    public String getDestinationLastName() {
        return destinationLastName;
    }

    public void setDestinationLastName(String destinationLastName) {
        this.destinationLastName = destinationLastName;
    }

    public String getDestinationPhoneNo() {
        return destinationPhoneNo;
    }

    public void setDestinationPhoneNo(String destinationPhoneNo) {
        this.destinationPhoneNo = destinationPhoneNo;
    }

    public String getDestinationMotherName() {
        return destinationMotherName;
    }

    public void setDestinationMotherName(String destinationMotherName) {
        this.destinationMotherName = destinationMotherName;
    }

    public String getDestinationFatherName() {
        return destinationFatherName;
    }

    public void setDestinationFatherName(String destinationFatherName) {
        this.destinationFatherName = destinationFatherName;
    }

    public String getDestinationBirthDate() {
        return destinationBirthDate;
    }

    public void setDestinationBirthDate(String destinationBirthDate) {
        this.destinationBirthDate = destinationBirthDate;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public Boolean getForceDuplicate() {
        return forceDuplicate;
    }

    public void setForceDuplicate(Boolean forceDuplicate) {
        this.forceDuplicate = forceDuplicate;
    }

    public Integer getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(Integer customerNo) {
        this.customerNo = customerNo;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public SourceAccount getSourceAccount() {
        return sourceAccount;
    }

    public void setSourceAccount(SourceAccount sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

}
