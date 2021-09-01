package com.example.stork.API.AccList.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {
    @SerializedName("$type")
    @Expose
    public String $type;
    @SerializedName("AccountList")
    @Expose
    public List<Account> accountList = null;

    public String get$type() {
        return $type;
    }

    public List<Account> getAccountList() {
        return accountList;
    }
}
