package com.example.stork.Database;

import com.example.stork.Database.Models.SavedTransaction;

import java.util.List;

public interface CallWrapper {
    void readDataCallback(List<SavedTransaction> transactions);
}
