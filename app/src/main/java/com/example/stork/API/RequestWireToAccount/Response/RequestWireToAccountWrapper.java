package com.example.stork.API.RequestWireToAccount.Response;

import com.example.stork.Database.Models.SavedCustomer;

import java.util.List;

public interface RequestWireToAccountWrapper {

    boolean RequestWireToAccountCallback(List<SavedCustomer> customers);
}
