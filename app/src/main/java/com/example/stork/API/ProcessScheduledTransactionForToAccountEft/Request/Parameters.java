package com.example.stork.API.ProcessScheduledTransactionForToAccountEft.Request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Parameters {

    @SerializedName("Message")
    @Expose
    public String message;
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

}
