package com.example.stork.API.ProcessScheduledTransactionForIbanEft.Request;

import com.example.stork.API.Header;
import com.google.gson.annotations.SerializedName;

public class Request {

    @SerializedName("Header")
    public Header header;
    @SerializedName("Parameters")
    public Parameter Parameters[] = new Parameter[1];

    public Request(Header header, Parameter parameters) {
        this.header = header;
        this.Parameters[0] = parameters;
    }
}