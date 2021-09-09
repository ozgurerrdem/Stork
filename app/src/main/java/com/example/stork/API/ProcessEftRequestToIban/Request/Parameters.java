package com.example.stork.API.ProcessEftRequestToIban.Request;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Parameters {

        @SerializedName("Explanation")
        @Expose
        public String explanation;
        @SerializedName("IBANNo")
        @Expose
        public String iBANNo;
        @SerializedName("DestinationBankCode")
        @Expose
        public Integer destinationBankCode;
        @SerializedName("Amount")
        @Expose
        public Integer amount;
        @SerializedName("CustomerNo")
        @Expose
        public Integer customerNo;
        @SerializedName("SourceAccount")
        @Expose
        public SourceAccount sourceAccount;
        @SerializedName("ReceiverName")
        @Expose
        public String receiverName;
        @SerializedName("ForceDuplicate")
        @Expose
        public Boolean forceDuplicate;

        public Parameters(String explanation, String iBANNo, Integer destinationBankCode, Integer amount, Integer customerNo, SourceAccount sourceAccount, String receiverName, Boolean forceDuplicate) {
                this.explanation = explanation;
                this.iBANNo = iBANNo;
                this.destinationBankCode = destinationBankCode;
                this.amount = amount;
                this.customerNo = customerNo;
                this.sourceAccount = sourceAccount;
                this.receiverName = receiverName;
                this.forceDuplicate = true;
        }
}
