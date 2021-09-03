package com.example.stork.API.RequestGoldWireToIBAN.Request;

import com.example.stork.API.ProcessEftRequestToIban.Request.Header;

public class Request {
    private Header header;
    private com.example.stork.API.ProcessEftRequestToIban.Request.Parameters Parameters[] = new com.example.stork.API.ProcessEftRequestToIban.Request.Parameters[1];

    public Header getHeader() {
        return header;
    }

    public com.example.stork.API.ProcessEftRequestToIban.Request.Parameters getParam() {
        return Parameters[0];
    }

    public Request(Header header, com.example.stork.API.ProcessEftRequestToIban.Request.Parameters parameters) {
        this.header = header;
        this.Parameters[0] = parameters;
    }
}
