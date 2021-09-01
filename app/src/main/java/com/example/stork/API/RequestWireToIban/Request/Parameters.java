package com.example.stork.API.RequestWireToIban.Request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Parameters {
    @SerializedName("Explanation")
    @Expose
    public String explanation;
    @SerializedName("Amount")
    @Expose
    public Integer amount;
    @SerializedName("CustomerNo")
    @Expose
    public Integer customerNo;
    @SerializedName("CitizenshipNumber")
    @Expose
    public Integer citizenshipNumber;
    @SerializedName("TaxNumber")
    @Expose
    public Integer taxNumber;
    @SerializedName("IBANNumber")
    @Expose
    public String iBANNumber;
    @SerializedName("SourceAccount")
    @Expose
    public SourceAccount sourceAccount;
    @SerializedName("ReceiverName")
    @Expose
    public String receiverName;
    @SerializedName("ForceDuplicate")
    @Expose
    public Boolean forceDuplicate;
}
