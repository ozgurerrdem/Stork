package com.example.stork.API.ProcessScheduledTransactionForToAccountEft.Request;

import com.example.stork.API.Header;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Request {
    private Header header;
    private Parameters Parameters[] = new Parameters[1];

    public Header getHeader() {
        return header;
    }

    public Parameters getParam() {
        return Parameters[0];
    }

    public Request(Header header,Parameters parameters) {
        this.header = header;
        this.Parameters[0] = parameters;
    }
}

