package com.example.stork.API.CurrencyRate.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("currency")
    @Expose
    public String currency;
    @SerializedName("changeWeek")
    @Expose
    public Float changeWeek;
    @SerializedName("changeWeekstr")
    @Expose
    public String changeWeekstr;
    @SerializedName("changeDay")
    @Expose
    public Float changeDay;
    @SerializedName("changeDaystr")
    @Expose
    public String changeDaystr;
    @SerializedName("changeHour")
    @Expose
    public Float changeHour;
    @SerializedName("changeHourstr")
    @Expose
    public String changeHourstr;
    @SerializedName("volumestr")
    @Expose
    public String volumestr;
    @SerializedName("volume")
    @Expose
    public Long volume;
    @SerializedName("pricestr")
    @Expose
    public String pricestr;
    @SerializedName("price")
    @Expose
    public Float price;
    @SerializedName("circulatingSupply")
    @Expose
    public String circulatingSupply;
    @SerializedName("marketCapstr")
    @Expose
    public String marketCapstr;
    @SerializedName("marketCap")
    @Expose
    public Long marketCap;
    @SerializedName("code")
    @Expose
    public String code;
    @SerializedName("name")
    @Expose
    public String name;

}
