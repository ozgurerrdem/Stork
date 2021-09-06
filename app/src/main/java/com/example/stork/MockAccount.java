package com.example.stork;


import com.example.stork.API.ProcessEftRequestToIban.Request.SourceAccount;

import java.io.Serializable;

public class MockAccount implements Serializable {


    private final String name =  "ATANALCAR ENOPHRYS";
    private final String citizenshipNumber = "11111"; //80722431894
    private final String customerNo ="773";
    private final String password = "12345";
    private final SourceAccount sourceAccount = new SourceAccount(351,1000,"TRY",773,"TR900001002533034585185045","-");

    public String getName() {
        return name;
    }



    public String getCitizenshipNumber() {
        return citizenshipNumber;
    }

    public String getCustomerNo() {
        return customerNo;
    }

    public String getPassword() {
        return password;
    }

    public SourceAccount getSourceAccount() {
        return sourceAccount;
    }

}