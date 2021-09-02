package com.example.stork.Activity;

import com.example.stork.Database.CallWrapperCustomer;
import com.example.stork.Database.DatabaseUtil;
import com.example.stork.Database.Models.SavedCustomer;
import com.example.stork.Database.Models.SavedTransaction;
import com.example.stork.Database.CallWrapperTransaction;

import java.util.List;

public class BackendTest {

    public void run() {

        //First test.
        readCustomersFromDatabaseTest();

    }

    public void addCustomerToDatabaseTest(){

        DatabaseUtil db = new DatabaseUtil();
        SavedCustomer nc1 = new SavedCustomer("Doruk ERGÜN", "67888888");
        SavedCustomer nc2 = new SavedCustomer("sadsadsad", "1");
        SavedCustomer nc3 = new SavedCustomer("LMAOOO", "673333");
        SavedCustomer nc4 = new SavedCustomer("Dorsdsd", "672");
        db.addSavedCustomer(nc1);
        db.addSavedCustomer(nc2);
        db.addSavedCustomer(nc3);
        db.addSavedCustomer(nc4);

    }

    public void readTransactionsFromDatabaseTest(){
        DatabaseUtil db = new DatabaseUtil();
        db.readTransactionData(new CallWrapperTransaction() {
            @Override
            public void readTransactionDataCallback(List<SavedTransaction> transactions) {
                System.out.println(transactions.get(0).getAmount() + " " + transactions.get(0).getExplanation() + " " + transactions.get(0).getExplanation() + " " + transactions.get(0).getReceiverName() + " ");
            }
        });
    }


    public void readCustomersFromDatabaseTest(){
        DatabaseUtil db = new DatabaseUtil();
        db.readCustomerData(new CallWrapperCustomer() {
            @Override
            public void readCustomerDataCallback(List<SavedCustomer> customers) {
                int i = 0;
                for(SavedCustomer sc : customers){
                    System.out.print(i + ":");
                    System.out.println(customers.get(i).getName() + " " + customers.get(i).getIBAN());
                    i++;
                }
            }
        });
    }

    /**
     * Yeni test fonksiyonlarının tanımlara aşağıya, run() içinde çağırmayı unutmayın..
     */

}
