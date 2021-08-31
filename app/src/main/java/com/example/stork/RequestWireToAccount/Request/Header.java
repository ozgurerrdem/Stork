package com.example.stork.RequestWireToAccount.Request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Header {

    @SerializedName("Channel")
    @Expose
    private String channel;
    @SerializedName("AppKey")
    @Expose
    private String appKey;
    @SerializedName("ChannelSessionId")
    @Expose
    private String channelSessionId;
    @SerializedName("ChannelRequestId")
    @Expose
    private String channelRequestId;

    public Header(String channel, String appKey, String channelSessionId, String channelRequestId) {
        this.channel = channel;
        this.appKey = appKey;
        this.channelSessionId = channelSessionId;
        this.channelRequestId = channelRequestId;
    }
}