package com.example.stork.Activity;

import com.example.stork.Database.DatabaseUtil;
import com.example.stork.Database.Models.SavedTransaction;
import com.example.stork.Database.CallWrapper;

import java.util.List;

public class BackendTest {

    public void run() {

        //First test.
        readToDatabaseTest();

    }

    public void readToDatabaseTest(){
        DatabaseUtil db = new DatabaseUtil();
        db.readData(new CallWrapper() {
            @Override
            public void readDataCallback(List<SavedTransaction> transactions) {
                System.out.println(transactions.get(0).getAmount() + " " + transactions.get(0).getExplanation() + " " + transactions.get(0).getExplanation() + " " + transactions.get(0).getReceiverName() + " ");
            }
        });
    }

    /**
     * Yeni test fonksiyonlarının tanımlara aşağıya, run() içinde çağırmayı unutmayın..
     */

}
