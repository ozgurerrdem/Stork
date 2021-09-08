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

        public Parameters(int index, String miktar, String exp, DestinationAccount dest ) {
                Services services = new Services();
                SourceAccount source = new SourceAccount();
                source.accountSuffix= MockAccount.accounts.get(index).getAccountSuffix().toString();
                source.branchCode=MockAccount.accounts.get(index).getBranchCode().toString();
                source.currencyCode=MockAccount.accounts.get(index).getCurrencyCode();
                source.customerNo=MockAccount.customerNo;
                sourceAccount = source;
                amount = miktar;
                explanation = exp;
                destinationAccount = dest;
                customerNo = MockAccount.customerNo;
                transactionDate =services.getCurrentTimeStamp();
        }


}
