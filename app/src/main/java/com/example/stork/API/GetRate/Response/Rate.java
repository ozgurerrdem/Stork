package com.example.stork.API.GetRate.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rate {
    @SerializedName("CurrencyCode")
    @Expose
    public String currencyCode;
    @SerializedName("CrossRate")
    @Expose
    public String crossRate;
    @SerializedName("ChangeRate")
    @Expose
    public String changeRate;
    @SerializedName("ExchangeRate")
    @Expose
    public String exchangeRate;
    @SerializedName("CashChangeRate")
    @Expose
    public String cashChangeRate;
    @SerializedName("CashExchangeRate")
    @Expose
    public String cashExchangeRate;

}
