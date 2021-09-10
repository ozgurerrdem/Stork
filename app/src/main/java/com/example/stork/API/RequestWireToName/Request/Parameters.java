package com.example.stork.API.RequestWireToName.Request;

import com.example.stork.MockAccount;
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

    public Parameters(Integer destinationBranchCode, String destinationName, String destinationLastName, String destinationPhoneNo, String destinationMotherName, String destinationFatherName, String destinationBirthDate, String receiverName, Boolean forceDuplicate, Integer customerNo, Integer amount, String explanation, SourceAccount sourceAccount) {
        this.destinationBranchCode = destinationBranchCode;
        this.destinationName = destinationName;
        this.destinationLastName = destinationLastName;
        this.destinationPhoneNo = destinationPhoneNo;
        this.destinationMotherName = destinationMotherName;
        this.destinationFatherName = destinationFatherName;
        this.destinationBirthDate = destinationBirthDate;
        this.receiverName = receiverName;
        this.forceDuplicate = true;
        this.customerNo =Integer.valueOf( MockAccount.customerNo);
        this.amount = amount;
        this.explanation = explanation;
        this.sourceAccount = sourceAccount;
    }
}
