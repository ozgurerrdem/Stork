package com.example.stork.API.RequestWireToAccount.Request;

import com.example.stork.MockAccount;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Parameters {

    @SerializedName("Explanation")
    @Expose
    public String explanation;
    @SerializedName("Amount")
    @Expose
    public Integer amount;
    @SerializedName("CitizenshipNumber")
    @Expose
    public Integer citizenshipNumber;
    @SerializedName("CustomerNo")
    @Expose
    public Integer customerNo;
    @SerializedName("SourceAccount")
    @Expose
    public SourceAccount sourceAccount;
    @SerializedName("DestinationAccount")
    @Expose
    public DestinationAccount destinationAccount;
    @SerializedName("ReceiverName")
    @Expose
    public String receiverName;
    @SerializedName("ForceDuplicate")
    @Expose
    public Boolean forceDuplicate;

    public Parameters(String explanation, Integer amount, SourceAccount sourceAccount, DestinationAccount destinationAccount, String receiverName) {
        this.explanation = explanation;
        this.amount = amount;
        this.citizenshipNumber =0;
        this.customerNo = Integer.valueOf(MockAccount.customerNo);
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
        this.receiverName = receiverName;
        this.forceDuplicate = true;
    }
}

