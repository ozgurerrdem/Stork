package com.example.stork.API.MoneyOrder.Request;

import com.example.stork.MockAccount;
import com.example.stork.Services;
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
        Services serv = new Services();
        public Parameters(SourceAccount sourceAccount, String amount, String explanation, DestinationAccount destinationAccount) {
                this.sourceAccount = sourceAccount;
                this.amount = amount;
                this.explanation = explanation;
                this.destinationAccount = destinationAccount;
                this.customerNo = MockAccount.customerNo;
                this.transactionDate =serv.getCurrentTimeStamp() ;
                this.forceDuplicate =true;
        }
}
