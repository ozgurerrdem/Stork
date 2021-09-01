package com.example.stork.API.SendFastMoneyOrder.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {
    @SerializedName("SenderCode")
    @Expose
    public String senderCode;
    @SerializedName("QueryCode")
    @Expose
    public String queryCode;
    @SerializedName("Status")
    @Expose
    public String status;
    @SerializedName("ErrorCode")
    @Expose
    public String errorCode;
    @SerializedName("ResultMessage")
    @Expose
    public String resultMessage;
    @SerializedName("TransactionSavingToken")
    @Expose
    public String transactionSavingToken;
    @SerializedName("State")
    @Expose
    public String state;
    @SerializedName("ConfirmationToken")
    @Expose
    public String confirmationToken;
    @SerializedName("RequiredConfirmationType")
    @Expose
    public String requiredConfirmationType;
    @SerializedName("MobilePhoneNumber")
    @Expose
    public String mobilePhoneNumber;
}
