package com.example.stork.API.GetReceiptData.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Content {
    public String get$value() {
        return $value;
    }

    @SerializedName("$value")
    @Expose
    public String $value;


}
