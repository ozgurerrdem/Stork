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
        this.currencyCode = birimChanger(currencyCode);
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

    public void setAccountSuffix(Integer accountSuffix) {
        this.accountSuffix = accountSuffix;
    }

    public void setBranchCode(Integer branchCode) {
        this.branchCode = branchCode;
    }

    public void setCustomerNo(Integer customerNo) {
        this.customerNo = customerNo;
    }

    public void setIBANNo(String IBANNo) {
        this.IBANNo = IBANNo;
    }

    public void setAmountOfBalance(Float amountOfBalance) {
        this.amountOfBalance = amountOfBalance;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    private String birimChanger(String birim) {

        if (birim.equals("TRY"))
            birim=" ₺";
        else if (birim.equals("USD"))
            birim=" $";
        else if (birim.equals("EUR"))
            birim=" €";
        else
            birim=" XAU";

        return birim;
    }
}
