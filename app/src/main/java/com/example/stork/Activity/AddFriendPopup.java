package com.example.stork.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.stork.Database.DatabaseUtil;
import com.example.stork.Database.Models.SavedCustomer;
import com.example.stork.R;

public class AddFriendPopup extends AppCompatActivity {
    private EditText name;
    private EditText iban;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_friend_popup);
        Button button = findViewById(R.id.login_btn);
        name = findViewById(R.id.editText4);
        iban = findViewById(R.id.editText5);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AddFriendPopup.this, "Arkadas Eklendi", Toast.LENGTH_SHORT).show();
                String nameStr = String.valueOf(name.getText());
                String ibanStr = String.valueOf(iban.getText());
                if (!nameStr.equals("") && !ibanStr.equals("")){
                    DatabaseUtil db = new DatabaseUtil();
                    db.addSavedCustomer(new SavedCustomer(nameStr,ibanStr,"https://i2.wp.com/www.cssscript.com/wp-content/uploads/2020/12/Customizable-SVG-Avatar-Generator-In-JavaScript-Avataaars.js.png?fit=438%2C408&ssl=1"));
                    finish();
                } else {
                    Toast.makeText(AddFriendPopup.this, "Gerekli Alanlari Doldurunuz", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}