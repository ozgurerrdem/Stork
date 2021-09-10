package com.example.stork.API.RequestGoldWireToIBAN.Request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Parameters {
    @SerializedName("Type")
    @Expose
    public String type;
    @SerializedName("TransactionType")
    @Expose
    public String transactionType;
    @SerializedName("IBAN")
    @Expose
    public String iban;
    @SerializedName("Currency")
    @Expose
    public String currency;
    @SerializedName("Amount")
    @Expose
    public Integer amount;
    @SerializedName("Description")
    @Expose
    public String description;

    public Parameters( String iban, Integer amount, String description) {
        this.type = "V";
        this.transactionType = "N";
        this.iban = iban;
        this.currency = "XAU";
        this.amount = amount;
        this.description = description;
    }
}
