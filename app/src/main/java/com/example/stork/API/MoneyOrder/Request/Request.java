package com.example.stork.API.MoneyOrder.Request;

import com.example.stork.API.ProcessEftRequestToIban.Request.Header;
import com.example.stork.API.ProcessEftRequestToIban.Request.Parameters;

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
    }}
