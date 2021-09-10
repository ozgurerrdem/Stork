package com.example.stork.API.ProcessScheduledTransactionForIbanEft.Request;

import android.os.Message;

import com.example.stork.MockAccount;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Parameter {

    @SerializedName("Message")
    @Expose
    public Message message;
    @SerializedName("TransactionPeriod")
    @Expose
    public Integer transactionPeriod;
    @SerializedName("Name")
    @Expose
    public String name;
    @SerializedName("Email")
    @Expose
    public String email;
    @SerializedName("TransactionDate")
    @Expose
    public String transactionDate;
    @SerializedName("CustomerNo")
    @Expose
    public Integer customerNo;
    @SerializedName("CellPhoneNo")
    @Expose
    public String cellPhoneNo;

    public Parameter(Message message, Integer transactionPeriod, String name, String email, String transactionDate) {
        this.message = message;
        this.transactionPeriod = transactionPeriod;
        this.name = name;
        this.email = email;
        this.transactionDate = transactionDate;
        this.customerNo =Integer.valueOf( MockAccount.customerNo);
        this.cellPhoneNo ="";
    }
}