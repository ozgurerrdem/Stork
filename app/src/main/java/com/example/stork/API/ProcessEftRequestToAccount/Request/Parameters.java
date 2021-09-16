package com.example.stork.API.ProcessEftRequestToAccount.Request;

import com.example.stork.MockAccount;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Parameters {
    @SerializedName("CustomerNo")
    @Expose
    public Integer customerNo;
    @SerializedName("Explanation")
    @Expose
    public String explanation;
    @SerializedName("SenderName")
    @Expose
    public String senderName;
    @SerializedName("TransferReason")
    @Expose
    public String transferReason;
    @SerializedName("DestinationBankCode")
    @Expose
    public Integer destinationBankCode;
    @SerializedName("EFTDestinationAccount")
    @Expose
    public String eFTDestinationAccount;
    @SerializedName("DestinationBranchCode")
    @Expose
    public Integer destinationBranchCode;
    @SerializedName("EFTDestinationType")
    @Expose
    public String eFTDestinationType;
    @SerializedName("Amount")
    @Expose
    public String amount;
    @SerializedName("SourceAccount")
    @Expose
    public SourceAccount sourceAccount;
    @SerializedName("ReceiverName")
    @Expose
    public String receiverName;
    @SerializedName("ForceDuplicate")
    @Expose
    public Boolean forceDuplicate;

    public Parameters(Integer customerNo, String explanation, String senderName, String transferReason, Integer destinationBankCode, String eFTDestinationAccount, Integer destinationBranchCode, String eFTDestinationType, String amount, SourceAccount sourceAccount, String receiverName, Boolean forceDuplicate) {
        this.customerNo =Integer.valueOf( MockAccount.customerNo);
        this.explanation = explanation;
        this.senderName = senderName;
        this.transferReason = "I";
        this.destinationBankCode = destinationBankCode;
        this.eFTDestinationAccount = eFTDestinationAccount;
        this.destinationBranchCode = destinationBranchCode;
        this.eFTDestinationType = "EFT_TYPE_TO_BRANCH";
        this.amount = amount;
        this.sourceAccount = sourceAccount;
        this.receiverName = receiverName;
        this.forceDuplicate = true;
    }

    @Override
    public String toString() {
        return "Parameters{" +
                "customerNo=" + customerNo +
                ", explanation='" + explanation + '\'' +
                ", senderName='" + senderName + '\'' +
                ", transferReason='" + transferReason + '\'' +
                ", destinationBankCode=" + destinationBankCode +
                ", eFTDestinationAccount='" + eFTDestinationAccount + '\'' +
                ", destinationBranchCode=" + destinationBranchCode +
                ", eFTDestinationType='" + eFTDestinationType + '\'' +
                ", amount='" + amount + '\'' +
                ", sourceAccount=" + sourceAccount +
                ", receiverName='" + receiverName + '\'' +
                ", forceDuplicate=" + forceDuplicate +
                '}';
    }
}
