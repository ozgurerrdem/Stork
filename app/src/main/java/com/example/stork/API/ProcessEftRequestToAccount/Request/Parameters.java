package com.example.stork.API.ProcessEftRequestToAccount.Request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Parameters {
    @SerializedName("Explanation")
    @Expose
    private String explanation;
    @SerializedName("SenderName")
    @Expose
    private String senderName;
    @SerializedName("IBANNo")
    @Expose
    private String iBANNo;
    @SerializedName("DestinationBankCode")
    @Expose
    private Integer destinationBankCode;
    @SerializedName("EFTDestinationAccount")
    @Expose
    private String eFTDestinationAccount;
    @SerializedName("DestinationBranchCode")
    @Expose
    private Integer destinationBranchCode;
    @SerializedName("Amount")
    @Expose
    private Integer amount;
    @SerializedName("CustomerNo")
    @Expose
    private Integer customerNo;
    @SerializedName("SourceAccount")
    @Expose
    private SourceAccount sourceAccount;
    @SerializedName("ReceiverName")
    @Expose
    private String receiverName;
    @SerializedName("ForceDuplicate")
    @Expose
    private Boolean forceDuplicate=true;


}
