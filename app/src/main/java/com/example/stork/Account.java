package com.example.stork;


public class Account {

    private Integer accountSuffix;
    private Integer branchCode;
    private Integer customerNo;
    private String IBANNo;
    private Float amountOfBalance;
    private String currencyCode;
    private String accountName;

    public Account(Integer accountSuffix, Integer branchCode, Integer customerNo, String IBANNo, Float amountOfBalance, String currencyCode,String accountName) {
        this.accountSuffix = accountSuffix;
        this.branchCode = branchCode;
        this.customerNo = customerNo;
        this.IBANNo = IBANNo;
        this.amountOfBalance = amountOfBalance;
        this.currencyCode = currencyCode;
        this.accountName = accountName;
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

    public String getAccountName() {
        return accountName;
    }
}
