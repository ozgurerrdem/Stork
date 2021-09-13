package com.example.stork.Database;

import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.stork.Database.Models.SavedCustomer;
import com.example.stork.Database.Models.SavedTransaction;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DatabaseUtil {

    /*Keeps the rootnode of the database.*/
    private FirebaseDatabase rootNode = FirebaseDatabase.getInstance();

    public void readTransactionData(CallWrapperTransaction myCallback) {
        DatabaseReference reference = rootNode.getReference("SavedTransactions");
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            String to_send = "";
            List<SavedTransaction> transactions = new ArrayList<>();
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot transaction : dataSnapshot.getChildren()){
                    SavedTransaction to_push = new SavedTransaction(transaction.child("receiverName").getValue(String.class),
                            transaction.child("receiverIBAN").getValue(String.class),
                            transaction.child("amount").getValue(String.class),
                            transaction.child("explanation").getValue(String.class));
                    transactions.add(to_push);

                    //to_send += transactions.child("amount").getValue(String.class);
                    //to_send += " ";
                }

                myCallback.readTransactionDataCallback(transactions);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {}
        });
    }

    /**
     * @return List of the all transactions on the database.
     */
    public ArrayList<SavedTransaction> getSavedTransactions(){
        //Set the reference to saved transactions database.
        DatabaseReference reference = rootNode.getReference("SavedTransactions");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // this method is call to get the realtime
                // updates in the data.
                // this method is called when the data is
                // changed in our Firebase console.
                // below line is for getting the data from
                // snapshot of our database.
                String value = snapshot.getValue(String.class);

                // after getting the value we are setting
                // our value to our text view in below line.
                System.out.println(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // calling on cancelled method when we receive
                // any error or we are not able to get the data.
                //Toast.makeText(MainActivity.this, "Fail to get data.", Toast.LENGTH_SHORT).show();
            }
        });

        return new ArrayList<>();
    }

    /**
     * Adds given transaction to database.
     * @param newTransaction transaction to be added.
     */
    public void addSavedTransaction(SavedTransaction newTransaction){
        DatabaseReference reference = rootNode.getReference("SavedTransactions");
        reference.push().setValue(newTransaction);
    }


    public void readCustomerData(CallWrapperCustomer myCallback) {
        DatabaseReference reference = rootNode.getReference("SavedCustomers");
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            String to_send = "";
            List<SavedCustomer> customers = new ArrayList<>();
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot customer : dataSnapshot.getChildren()){
                    SavedCustomer to_push = new SavedCustomer(customer.child("name").getValue(String.class),
                                                                customer.child("iban").getValue(String.class),
                            customer.child("photoLink").getValue(String.class));
                    customers.add(to_push);
                }

                myCallback.readCustomerDataCallback(customers);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {}
        });
    }

    /**
     * @return List of the all transactions on the database.
     */
    public ArrayList<SavedCustomer> getSavedCustomers(){
        //Set the reference to saved transactions database.
        DatabaseReference reference = rootNode.getReference("SavedCustomers");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // this method is call to get the realtime
                // updates in the data.
                // this method is called when the data is
                // changed in our Firebase console.
                // below line is for getting the data from
                // snapshot of our database.
                String value = snapshot.getValue(String.class);

                // after getting the value we are setting
                // our value to our text view in below line.
                System.out.println(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // calling on cancelled method when we receive
                // any error or we are not able to get the data.
                //Toast.makeText(MainActivity.this, "Fail to get data.", Toast.LENGTH_SHORT).show();
            }
        });

        return new ArrayList<>();
    }

    /**
     * Adds given transaction to database.
     * @param newCustomer transaction to be added.
     */
    public void addSavedCustomer(SavedCustomer newCustomer){
        DatabaseReference reference = rootNode.getReference("SavedCustomers");
        Query setRef = reference.orderByChild("iban").equalTo(newCustomer.getIBAN());
        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(!dataSnapshot.exists()){
                    System.out.println("Yok..");
                    reference.push().setValue(newCustomer);
                }else{
                    System.out.println("zaten var.");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                System.out.println("error.");
            }
        };
        setRef.addListenerForSingleValueEvent(eventListener);
    }




}
