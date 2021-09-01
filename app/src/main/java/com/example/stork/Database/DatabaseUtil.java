package com.example.stork.Database;

import com.example.stork.Database.Models.SavedTransaction;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DatabaseUtil {

    /*Keeps the rootnode of the database.*/
    private FirebaseDatabase rootNode = FirebaseDatabase.getInstance();
    private ArrayList<SavedTransaction> result = new ArrayList<>();

    public ArrayList<SavedTransaction> returnTheList(){
        return result;
    }

    /**
     * @return List of the all transactions on the database.
     */
    public ArrayList<SavedTransaction> getSavedTransactions(){
        /* Set the reference to saved transactions database.
        DatabaseReference reference = rootNode.getReference("SavedTransactions");
        @Override
        public void onChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot ds: dataSnapshot.getChildren()) {
                    SavedTransaction to_push = new SavedTransaction(ds.child("receiverName").getValue(String.class),
                            ds.child("receiverIBAN").getValue(String.class),
                            ds.child("amount").getValue(String.class),
                            ds.child("explanation").getValue(String.class));
                    result.add(to_push);
                }


        }
        @Override
        public void onCancelled(DatabaseError databaseError) {

        }*/
        return result;
    }

    /**
     * Adds given transaction to database.
     * @param newTransaction transaction to be added.
     */
    public void addSavedTransaction(SavedTransaction newTransaction){
        DatabaseReference reference = rootNode.getReference("SavedTransactions");
        reference.push().setValue(newTransaction);
    }

    public void deleteSavedTransaction(){

    }



}
