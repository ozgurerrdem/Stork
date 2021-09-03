package com.example.stork.API.GetReceiptData.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("Content")
    @Expose
    public Content content;

    public Content getContent() {
        return content;
    }

}