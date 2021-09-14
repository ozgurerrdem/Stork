package com.example.stork.Model;

public class NewCardModel {
    private int image;
    private String account_name;
    private String account_balance;
    private String account_number;

    public NewCardModel(int image, String account_name, String account_balance, String account_number) {
        this.image = image;
        this.account_name = account_name;
        this.account_balance = account_balance;
        this.account_number = account_number;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }

    public String getAccount_balance() {
        return account_balance;
    }

    public void setAccount_balance(String account_balance) {
        this.account_balance = account_balance;
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }
}
