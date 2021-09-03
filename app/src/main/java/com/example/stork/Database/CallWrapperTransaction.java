package com.example.stork.Database;

import com.example.stork.Database.Models.SavedCustomer;
import com.example.stork.Database.Models.SavedTransaction;

import java.util.List;

public interface CallWrapperTransaction {
    void readTransactionDataCallback(List<SavedTransaction> transactions);
}
