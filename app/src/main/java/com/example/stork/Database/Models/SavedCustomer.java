package com.example.stork.Database.Models;

public class SavedCustomer {

    private String name;
    private String IBAN;
    private String photoLink;

    public SavedCustomer(String name, String IBAN, String photoLink) {
        this.name = name;
        this.IBAN = IBAN;
        this.photoLink = photoLink;
    }

    public String getName() {
        return name;
    }

    public String getIBAN() {
        return IBAN;
    }

    public String getPhotoLink() {
        return photoLink;
    }
}
