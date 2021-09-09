package com.example.stork.API;

public class Header {
    public String  AppKey;
    public String  Channel;
    public String  ChannelSessionId;
    public String  ChannelRequestId;

    public Header(String appKey, String channel, String channelSessionId, String channelRequestId) {
        AppKey = appKey;
        Channel = channel;
        ChannelSessionId = channelSessionId;
        ChannelRequestId = channelRequestId;
    }
    public Header (){
        AppKey = "API7909c7de460b462aa1d";
        Channel = "API";
        ChannelSessionId = "test";
        ChannelRequestId = "a9058690-a286-40b7-b610-dbf477201501";
    }
}
