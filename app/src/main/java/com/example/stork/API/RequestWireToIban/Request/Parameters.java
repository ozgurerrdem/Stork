package com.example.stork.API.RequestWireToIban.Request;

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
    public Parameters(String explanation, Integer amount, String iBANNumber, SourceAccount sourceAccount, String receiverName) {
        this.explanation = explanation;
        this.amount = amount;
        this.customerNo = Integer.valueOf(MockAccount.customerNo);
        this.citizenshipNumber =0;
        this.taxNumber =0;
        this.iBANNumber = iBANNumber;
        this.sourceAccount = sourceAccount;
        this.receiverName = receiverName;
        this.forceDuplicate = true;
    }

    @Override
    public String toString() {
        return "Parameters{" +
                "explanation='" + explanation + '\'' +
                ", amount=" + amount +
                ", customerNo=" + customerNo +
                ", citizenshipNumber=" + citizenshipNumber +
                ", taxNumber=" + taxNumber +
                ", iBANNumber='" + iBANNumber + '\'' +
                ", sourceAccount=" + sourceAccount +
                ", receiverName='" + receiverName + '\'' +
                ", forceDuplicate=" + forceDuplicate +
                '}';
    }
}
