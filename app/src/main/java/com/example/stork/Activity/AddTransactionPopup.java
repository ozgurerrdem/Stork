package com.example.stork.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.stork.Database.DatabaseUtil;
import com.example.stork.Database.Models.SavedTransaction;
import com.example.stork.R;

public class AddTransactionPopup extends AppCompatActivity {
    private EditText name;
    private EditText iban;
    private EditText amount;
    private EditText explanation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_transaction_popup);
        Button button = findViewById(R.id.login_btn);
        name = findViewById(R.id.editText4);
        iban = findViewById(R.id.editText5);
        amount = findViewById(R.id.editText6);
        explanation = findViewById(R.id.editText7);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AddTransactionPopup.this, "Arkadas Eklendi", Toast.LENGTH_SHORT).show();
                String nameStr = String.valueOf(name.getText());
                String ibanStr = String.valueOf(iban.getText());
                String amountStr = String.valueOf(amount.getText());
                String explanationStr = String.valueOf(explanation.getText());

                if (!nameStr.isEmpty() && !ibanStr.isEmpty() && !amountStr.isEmpty()){
                    DatabaseUtil db = new DatabaseUtil();
                    db.addSavedTransaction(new SavedTransaction(nameStr,ibanStr,amountStr,explanationStr));
                } else {
                    Toast.makeText(AddTransactionPopup.this, "Gerekli Alanlari Doldurunuz", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}