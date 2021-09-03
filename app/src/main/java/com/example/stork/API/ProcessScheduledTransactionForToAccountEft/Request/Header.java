package com.example.stork.API.ProcessScheduledTransactionForToAccountEft.Request;

import com.google.gson.annotations.SerializedName;

public class Header {

    private String AppKey;
    private String Channel;
    private String ChannelSessionId;
    private String ChannelRequestId;

    public String getAppKey() {
        return AppKey;
    }

    public void setAppKey(String appKey) {
        AppKey = appKey;
    }

    public String getChannel() {
        return Channel;
    }

    public void setChannel(String channel) {
        Channel = channel;
    }

    public String getChannelSessionId() {
        return ChannelSessionId;
    }

    public void setChannelSessionId(String channelSessionId) {
        ChannelSessionId = channelSessionId;
    }

    public String getChannelRequestId() {
        return ChannelRequestId;
    }

    public void setChannelRequestId(String channelRequestId) {
        ChannelRequestId = channelRequestId;
    }

    public Header(String appKey, String channel, String channelSessionId, String channelRequestId) {
        AppKey = appKey;
        Channel = channel;
        ChannelSessionId = channelSessionId;
        ChannelRequestId = channelRequestId;
    }

}