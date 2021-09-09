package com.example.stork.API.MoneyOrder.Request;

import com.example.stork.API.Header;

public class Request {
    private Header header;
    private Parameters Parameters[] = new Parameters[1];

    public Header getHeader() {
        return header;
    }

    public Parameters getParam() {
        return Parameters[0];
    }

    public Request(Header header, Parameters parameters) {
        this.header = header;
        this.Parameters[0] = parameters;
    }}
