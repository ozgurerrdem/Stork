package com.example.stork.API.RequestWireToName.Request;

import com.example.stork.API.RequestWireToName.Request.Header;
import com.example.stork.API.RequestWireToName.Request.Parameters;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Request {

    @SerializedName("Header")
    @Expose
    private com.example.stork.API.RequestWireToName.Request.Header header;
    @SerializedName("Parameters")
    @Expose
    private com.example.stork.API.RequestWireToName.Request.Parameters Parameters[] = new com.example.stork.API.RequestWireToName.Request.Parameters[1];

    public Request(Header header, com.example.stork.API.RequestWireToName.Request.Parameters parameters) {
        this.header = header;
        this.Parameters[0] = parameters;
    }
}
