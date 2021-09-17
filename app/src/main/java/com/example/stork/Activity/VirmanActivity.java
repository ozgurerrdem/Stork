package com.example.stork.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.ServiceState;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.stork.API.MoneyOrder.MoneyOrd;
import com.example.stork.API.MoneyOrder.Request.DestinationAccount;
import com.example.stork.API.MoneyOrder.Request.Parameters;
import com.example.stork.API.MoneyOrder.Request.SourceAccount;
import com.example.stork.API.MoneyOrder.Response.Response;
import com.example.stork.Account;
import com.example.stork.MockAccount;
import com.example.stork.R;
import com.example.stork.Services;

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
    private TextView tum_bak;
    private RelativeLayout bar;
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
        tum_bak = findViewById(R.id.tum_bak);
        ac1 = findViewById(R.id.hesabim_spinner1);
        ac2 = findViewById(R.id.hesabim_spinner2);
        bar = findViewById(R.id.loadingPanel);
        amount.setText("0");
        ImageButton back = findViewById(R.id.back_btn);
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
            acNameList1.add(a.getAccountName() + " \n" + a.getAmountOfBalance() +" "+ a.getBirimCevirme());
            acNameList2.add(a.getAccountName() + " \n" + a.getAmountOfBalance() +" "+ a.getBirimCevirme());
        }

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, acNameList1);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ac1.setAdapter(adapter1);
        ac1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // Showing selected spinner item
                indexAccount = i;

                    birim.setText(MockAccount.accounts.get(indexAccount).getBirimCevirme());

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
                exp.onEditorAction(EditorInfo.IME_ACTION_DONE);
                if (Float.parseFloat(amount.getText().toString()) > MockAccount.accounts.get(indexAccount).getAmountOfBalance()) {
                    Toast.makeText(getApplicationContext(), "Bakiyeniz yeterli değildir", Toast.LENGTH_SHORT).show();
                } else {
                    if (!amount.getText().toString().isEmpty() && (MockAccount.accounts.get(indexAccount).getCurrencyCode().equals(MockAccount.accounts.get(indexAccount1).getCurrencyCode()))) {
                        bar.setVisibility(View.VISIBLE);
                        Parameters param = new Parameters(new SourceAccount(indexAccount), amount.getText().toString(), exp.getText().toString(), new DestinationAccount(indexAccount1));
                        MoneyOrd ord = new MoneyOrd();
                        ord.getResponse(param, new Callback<Response>() {
                            @Override
                            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                                System.out.println(response.code());
                                if (response.code() == 200 && response.body() != null && response.body().getData() != null) {
                                    bar.setVisibility(View.GONE);
                                    MockAccount.accounts.get(indexAccount).setAmountOfBalance(MockAccount.accounts.get(indexAccount).getAmountOfBalance() - Float.parseFloat(amount.getText().toString()));
                                    MockAccount.accounts.get(indexAccount1).setAmountOfBalance(MockAccount.accounts.get(indexAccount1).getAmountOfBalance() + Float.parseFloat(amount.getText().toString()));
                                    //System.out.println("RESPONSE: " + response.body().getData().accountingReference + " " + response.body().getData().state);

                                    Bundle bundle = new Bundle();
                                    ArrayList<String> a = new ArrayList<String>();
                                    a.add(Services.getCurrentTimeStamp());
                                    a.add("0");
                                    a.add(MockAccount.accounts.get(indexAccount).getAmountOfBalance().toString());
                                    a.add(MockAccount.accounts.get(indexAccount).getAccountName());
                                    a.add(MockAccount.accounts.get(indexAccount).getBirimCevirme());

                                    bundle.putSerializable("pdf_key",
                                            a ); // burayı değiştim
                                    Intent intent = new Intent(getApplicationContext(), IbanSendAnimationActivity.class);
                                    intent.putExtras(bundle);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    Toast.makeText(getApplicationContext(), "İşlem Gerçekleştirilemedi", Toast.LENGTH_SHORT).show();
                                    System.out.println("ALARM ALARM");
                                }
                            }

                            @Override
                            public void onFailure(Call<Response> call, Throwable t) {

                            }
                        });
                    } else
                    {
                        Toast.makeText(getApplicationContext(), "Hesapların Bakiye Tipi Farklı", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        tum_bak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                amount.setText(MockAccount.accounts.get(indexAccount).getAmountOfBalance().toString());
            }
        });

    }
}