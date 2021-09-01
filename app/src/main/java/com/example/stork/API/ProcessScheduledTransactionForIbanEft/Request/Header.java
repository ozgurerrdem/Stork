package com.example.stork.API.ProcessScheduledTransactionForIbanEft.Request;

import com.google.gson.annotations.SerializedName;

public class Header {

    @SerializedName("AppKey")
    public String appKey;
    @SerializedName("Channel")
    public String channel;
    @SerializedName("TellerName")
    public String tellerName;
    @SerializedName("CallerId")
    public String callerId;
    @SerializedName("ChannelSessionId")
    public String channelSessionId;
    @SerializedName("ChannelRequestId")
    public String channelRequestId;

}