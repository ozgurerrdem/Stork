package com.example.stork;

import com.example.stork.Database.Models.SavedCustomer;

import java.util.List;

public interface CallWrapperAccounts {
    void readAccountsDataCallback(List<Account> accounts);
}
