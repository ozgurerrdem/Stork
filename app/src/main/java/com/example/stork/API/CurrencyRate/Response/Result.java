package com.example.stork.API.CurrencyRate.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("changeHour")
    @Expose
    public Float changeHour;
    @SerializedName("changeHourstr")
    @Expose
    public String changeHourstr;
    @SerializedName("changeDay")
    @Expose
    public Float changeDay;
    @SerializedName("changeDaystr")
    @Expose
    public String changeDaystr;
    @SerializedName("changeWeek")
    @Expose
    public Float changeWeek;
    @SerializedName("changeWeekstr")
    @Expose
    public String changeWeekstr;
    @SerializedName("volumestr")
    @Expose
    public String volumestr;
    @SerializedName("volume")
    @Expose
    public Float volume;
    @SerializedName("currency")
    @Expose
    public String currency;
    @SerializedName("pricestr")
    @Expose
    public String pricestr;
    @SerializedName("price")
    @Expose
    public Float price;
    @SerializedName("marketCapstr")
    @Expose
    public String marketCapstr;
    @SerializedName("marketCap")
    @Expose
    public Float marketCap;
    @SerializedName("circulatingSupply")
    @Expose
    public String circulatingSupply;
    @SerializedName("code")
    @Expose
    public String code;
    @SerializedName("name")
    @Expose
    public String name;
}
