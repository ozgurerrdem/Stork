package com.example.stork.Database.Models;

public class SavedTransaction {

    private String receiverName, receiverIBAN, amount, explanation;

    public SavedTransaction(){

    }

    public SavedTransaction(String receiverName, String receiverIBAN, String amount, String explanation) {
        this.receiverName = receiverName;
        this.receiverIBAN = receiverIBAN;
        this.amount = amount;
        this.explanation = explanation;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public String getRecieverIBAN() {
        return receiverIBAN;
    }

    public String getAmount() {
        return amount;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public void setReceiverIBAN(String recieverIBAN) {
        this.receiverIBAN = recieverIBAN;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }
}
