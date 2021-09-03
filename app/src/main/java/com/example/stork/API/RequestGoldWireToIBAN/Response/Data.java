package com.example.stork.API.RequestGoldWireToIBAN.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("ResponseCode")
    @Expose
    public String responseCode;
    @SerializedName("ResponseMessage")
    @Expose
    public String responseMessage;
    @SerializedName("ConfirmationCodeGuid")
    @Expose
    public String confirmationCodeGuid;}
