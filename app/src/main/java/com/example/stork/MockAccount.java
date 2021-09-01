package com.example.stork;


import com.example.stork.ProcessEftRequestToIban.Request.SourceAccount;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.math.BigInteger;

public class MockAccount implements Serializable {


    private final String name =  "BELLADONNA";
    private final String middleName = "TOOK";
    private final String surname = "GYRİNOCHEİLİDAE";
    private final String citizenshipNumber = "11111";
    private final Integer customerNo = 13188998;
    private final String password = "12345";
    private final SourceAccount sourceAccount = new SourceAccount(385,9142,"TRY",773,"TR900001002533034585185045","-");

    public String getName() {
        return name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getSurname() {
        return surname;
    }

    public String getCitizenshipNumber() {
        return citizenshipNumber;
    }

    public Integer getCustomerNo() {
        return customerNo;
    }

    public String getPassword() {
        return password;
    }

    public SourceAccount getSourceAccount() {
        return sourceAccount;
    }

}