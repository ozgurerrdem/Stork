package com.example.stork.API.MoneyOrder.Request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Parameters {


        @SerializedName("SourceAccount")
        @Expose
        public SourceAccount sourceAccount;
        @SerializedName("Amount")
        @Expose
        public String amount;
        @SerializedName("Explanation")
        @Expose
        public String explanation;
        @SerializedName("DestinationAccount")
        @Expose
        public DestinationAccount destinationAccount;
        @SerializedName("CustomerNo")
        @Expose
        public String customerNo;
        @SerializedName("TransactionDate")
        @Expose
        public String transactionDate;
        @SerializedName("ForceDuplicate")
        @Expose
        public Boolean forceDuplicate;


}
