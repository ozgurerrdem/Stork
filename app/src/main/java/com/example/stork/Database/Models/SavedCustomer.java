package com.example.stork.Database.Models;

public class SavedCustomer {

    private String name;
    private String IBAN;

    public SavedCustomer(String name, String IBAN) {
        this.name = name;
        this.IBAN = IBAN;
    }

    public String getName() {
        return name;
    }

    public String getIBAN() {
        return IBAN;
    }
}
