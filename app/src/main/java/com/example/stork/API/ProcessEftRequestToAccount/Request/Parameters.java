package com.example.stork.API.ProcessEftRequestToAccount.Request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Parameters {
    @SerializedName("Explanation")
    @Expose
    private String explanation;
    @SerializedName("SenderName")
    @Expose
    private String senderName;
    @SerializedName("IBANNo")
    @Expose
    private String iBANNo;
    @SerializedName("DestinationBankCode")
    @Expose
    private Integer destinationBankCode;
    @SerializedName("EFTDestinationAccount")
    @Expose
    private String eFTDestinationAccount;
    @SerializedName("DestinationBranchCode")
    @Expose
    private Integer destinationBranchCode;
    @SerializedName("Amount")
    @Expose
    private Integer amount;
    @SerializedName("CustomerNo")
    @Expose
    private Integer customerNo;
    @SerializedName("SourceAccount")
    @Expose
    private SourceAccount sourceAccount;
    @SerializedName("ReceiverName")
    @Expose
    private String receiverName;
    @SerializedName("ForceDuplicate")
    @Expose
    private Boolean forceDuplicate;

    public String getExplanation() {
        return explanation;
    }

    public String getSenderName() {
        return senderName;
    }

    public String getiBANNo() {
        return iBANNo;
    }

    public Integer getDestinationBankCode() {
        return destinationBankCode;
    }

    public String geteFTDestinationAccount() {
        return eFTDestinationAccount;
    }

    public Integer getDestinationBranchCode() {
        return destinationBranchCode;
    }

    public Integer getAmount() {
        return amount;
    }

    public Integer getCustomerNo() {
        return customerNo;
    }

    public SourceAccount getSourceAccount() {
        return sourceAccount;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public Boolean getForceDuplicate() {
        return forceDuplicate;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public void setiBANNo(String iBANNo) {
        this.iBANNo = iBANNo;
    }

    public void setDestinationBankCode(Integer destinationBankCode) {
        this.destinationBankCode = destinationBankCode;
    }

    public void seteFTDestinationAccount(String eFTDestinationAccount) {
        this.eFTDestinationAccount = eFTDestinationAccount;
    }

    public void setDestinationBranchCode(Integer destinationBranchCode) {
        this.destinationBranchCode = destinationBranchCode;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public void setCustomerNo(Integer customerNo) {
        this.customerNo = customerNo;
    }

    public void setSourceAccount(SourceAccount sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public void setForceDuplicate(Boolean forceDuplicate) {
        this.forceDuplicate = forceDuplicate;
    }
}
