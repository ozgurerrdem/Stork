package com.example.stork.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.stork.API.MoneyOrder.MoneyOrd;
import com.example.stork.API.MoneyOrder.Request.DestinationAccount;
import com.example.stork.API.MoneyOrder.Request.Parameters;
import com.example.stork.API.MoneyOrder.Request.SourceAccount;
import com.example.stork.API.MoneyOrder.Response.Response;
import com.example.stork.Account;
import com.example.stork.MockAccount;
import com.example.stork.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;

public class VirmanActivity extends AppCompatActivity {
    private Spinner ac1;
    private Spinner ac2;
    private Button button;
    private EditText amount;
    private EditText exp;
    private TextView birim;
    private ArrayList<String> acNameList1 = new ArrayList<String>();
    private ArrayList<String> acNameList2 = new ArrayList<String>();
    private int indexAccount = 0;
    private int indexAccount1 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_virman);

        button = findViewById(R.id.login_btn);
        amount = findViewById(R.id.gonderilecek_edit);
        exp = findViewById(R.id.aciklama_edit);
        birim = findViewById(R.id.birim);
        ac1 = findViewById(R.id.hesabim_spinner1);
        ac2 = findViewById(R.id.hesabim_spinner2);
        ImageButton back = findViewById(R.id.back_btn77);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        acNameList1.clear();
        for (Account a : MockAccount.accounts) {
            acNameList1.add(a.getAccountName());
            acNameList2.add(a.getAccountName());
        }

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, acNameList1);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ac1.setAdapter(adapter1);
        ac1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // Showing selected spinner item
                indexAccount = i;
                birim.setText(MockAccount.accounts.get(indexAccount).getCurrencyCode());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, acNameList2);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ac2.setAdapter(adapter2);
        ac2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // Showing selected spinner item
                indexAccount1 = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!amount.getText().toString().isEmpty() && (MockAccount.accounts.get(indexAccount).getCurrencyCode().equals(MockAccount.accounts.get(indexAccount1).getCurrencyCode()))) {
                    Parameters param = new Parameters(new SourceAccount(indexAccount), amount.getText().toString(), exp.getText().toString(), new DestinationAccount(indexAccount1));
                    MoneyOrd ord = new MoneyOrd();
                    ord.getResponse(param, new Callback<Response>() {
                        @Override
                        public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                            System.out.println(response.code());
                            if (response.code() == 200) {
                                System.out.println("RESPONSE: " + response.body().getData().accountingReference + " " + response.body().getData().state);
                            } else {
                                System.out.println("ALARM ALARM");
                            }
                        }

                        @Override
                        public void onFailure(Call<Response> call, Throwable t) {

                        }
                    });
                }
            }
        });

    }
}