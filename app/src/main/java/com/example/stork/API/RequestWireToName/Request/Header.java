package com.example.stork.API.RequestWireToName.Request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Header {
    @SerializedName("AppKey")
    @Expose
    private String appKey;
    @SerializedName("Channel")
    @Expose
    private String channel;
    @SerializedName("ChannelSessionId")
    @Expose
    private String channelSessionId;
    @SerializedName("ChannelRequestId")
    @Expose
    private String channelRequestId;

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getChannelSessionId() {
        return channelSessionId;
    }

    public void setChannelSessionId(String channelSessionId) {
        this.channelSessionId = channelSessionId;
    }

    public String getChannelRequestId() {
        return channelRequestId;
    }

    public void setChannelRequestId(String channelRequestId) {
        this.channelRequestId = channelRequestId;
    }
}
