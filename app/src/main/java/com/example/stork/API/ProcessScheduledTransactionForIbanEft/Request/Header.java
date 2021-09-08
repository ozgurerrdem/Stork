package com.example.stork.API.ProcessScheduledTransactionForIbanEft.Request;

import com.google.gson.annotations.SerializedName;

public class Header {

    @SerializedName("AppKey")
    public String appKey;
    @SerializedName("Channel")
    public String channel;
    @SerializedName("ChannelSessionId")
    public String channelSessionId;
    @SerializedName("ChannelRequestId")
    public String channelRequestId;

    public Header(String appKey, String channel, String channelSessionId, String channelRequestId) {
        this.appKey = appKey;
        this.channel = channel;
        this.channelSessionId = channelSessionId;
        this.channelRequestId = channelRequestId;
    }
}