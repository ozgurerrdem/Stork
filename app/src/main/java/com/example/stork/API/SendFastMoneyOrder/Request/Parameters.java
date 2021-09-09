package com.example.stork.API.SendFastMoneyOrder.Request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Parameters {
    @SerializedName("PaymentReason")
    @Expose
    public String paymentReason;
    @SerializedName("PaymentSource")
    @Expose
    public String paymentSource;
    @SerializedName("SenderAccountNumber")
    @Expose
    public String senderAccountNumber;
    @SerializedName("SenderIdentityNumber")
    @Expose
    public String senderIdentityNumber;
    @SerializedName("ReceiverCode")
    @Expose
    public String receiverCode;
    @SerializedName("ReceiverAccountNumber")
    @Expose
    public String receiverAccountNumber;
    @SerializedName("ReceiverIdentityNumber")
    @Expose
    public String receiverIdentityNumber;
    @SerializedName("SenderAddress")
    @Expose
    public String senderAddress;
    @SerializedName("SenderName")
    @Expose
    public String senderName;
    @SerializedName("SenderPassportNo")
    @Expose
    public String senderPassportNo;
    @SerializedName("SenderBirthPlace")
    @Expose
    public String senderBirthPlace;
    @SerializedName("SenderBirthDate")
    @Expose
    public String senderBirthDate;
    @SerializedName("Explanation")
    @Expose
    public String explanation;
    @SerializedName("KolasAddressType")
    @Expose
    public String kolasAddressType;
    @SerializedName("KolasAddressValue")
    @Expose
    public String kolasAddressValue;
    @SerializedName("Amount")
    @Expose
    public Integer amount;
    @SerializedName("SourceAccount")
    @Expose
    public SourceAccount sourceAccount;
    @SerializedName("ReceiverName")
    @Expose
    public String receiverName;
    @SerializedName("CustomerIdentity")
    @Expose
    public Integer customerIdentity;
    @SerializedName("CustomerNo")
    @Expose
    public Integer customerNo;

    public Parameters(String paymentReason, String paymentSource, String senderAccountNumber, String senderIdentityNumber, String receiverCode, String receiverAccountNumber, String receiverIdentityNumber, String senderAddress, String senderName, String senderPassportNo, String senderBirthPlace, String senderBirthDate, String explanation, String kolasAddressType, String kolasAddressValue, Integer amount, SourceAccount sourceAccount, String receiverName, Integer customerIdentity, Integer customerNo) {
        this.paymentReason = paymentReason;
        this.paymentSource = paymentSource;
        this.senderAccountNumber = senderAccountNumber;
        this.senderIdentityNumber = senderIdentityNumber;
        this.receiverCode = receiverCode;
        this.receiverAccountNumber = receiverAccountNumber;
        this.receiverIdentityNumber = receiverIdentityNumber;
        this.senderAddress = senderAddress;
        this.senderName = senderName;
        this.senderPassportNo = senderPassportNo;
        this.senderBirthPlace = senderBirthPlace;
        this.senderBirthDate = senderBirthDate;
        this.explanation = explanation;
        this.kolasAddressType = kolasAddressType;
        this.kolasAddressValue = kolasAddressValue;
        this.amount = amount;
        this.sourceAccount = sourceAccount;
        this.receiverName = receiverName;
        this.customerIdentity = customerIdentity;
        this.customerNo = customerNo;
    }
}
