package com.example.stork.API.GetAccountTransactionList.Request;

import com.example.stork.API.Header;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Request {
    @SerializedName("Header")
    @Expose
    public Header header;
    @SerializedName("Parameters")
    @Expose
    public Parameters parameters[] = new Parameters[1];

    public Request(Header header, Parameters parameters) {
        this.header = header;
        this.parameters[0] = parameters;
    }
}
