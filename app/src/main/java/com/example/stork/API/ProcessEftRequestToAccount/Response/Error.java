package com.example.stork.API.ProcessEftRequestToAccount.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Error {
    @SerializedName("$type")
    @Expose
    private String $type;
    @SerializedName("Code")
    @Expose
    private Integer code;
    @SerializedName("Description")
    @Expose
    private String description;
    @SerializedName("Parameters")
    @Expose
    private Object parameters;
    @SerializedName("TransactionId")
    @Expose
    private Integer transactionId;
    @SerializedName("ErrorId")
    @Expose
    private String errorId;

    public String get$type() {
        return $type;
    }

    public Integer getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public Object getParameters() {
        return parameters;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public String getErrorId() {
        return errorId;
    }
}
