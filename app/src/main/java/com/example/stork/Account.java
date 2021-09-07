package com.example.stork;


public class Account {

    private Integer accountSuffix;
    private Integer branchCode;
    private Integer customerNo;
    private String IBANNo;
    private Float amountOfBalance;
    private String currencyCode;

    public Account(Integer accountSuffix, Integer branchCode, Integer customerNo, String IBANNo, Float amountOfBalance, String currencyCode) {
        this.accountSuffix = accountSuffix;
        this.branchCode = branchCode;
        this.customerNo = customerNo;
        this.IBANNo = IBANNo;
        this.amountOfBalance = amountOfBalance;
        this.currencyCode = currencyCode;
    }

    public Integer getAccountSuffix() {
        return accountSuffix;
    }

    public Integer getBranchCode() {
        return branchCode;
    }

    public Integer getCustomerNo() {
        return customerNo;
    }

    public String getIBANNo() {
        return IBANNo;
    }

    public Float getAmountOfBalance() {
        return amountOfBalance;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }
}
