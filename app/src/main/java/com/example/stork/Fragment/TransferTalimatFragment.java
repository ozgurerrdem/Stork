package com.example.stork.Fragment;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.stork.API.ProcessScheduledTransactionForIbanEft.Request.Parameter;
import com.example.stork.API.ProcessScheduledTransactionForIbanEft.Response.Response;
import com.example.stork.API.ProcessScheduledTransactionForIbanEft.ScheduledTransactionForIbanEft;
import com.example.stork.Account;
import com.example.stork.MockAccount;
import com.example.stork.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TransferTalimatFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TransferTalimatFragment extends Fragment {
    final Calendar myCalendar = Calendar.getInstance();
    private EditText date;
    private Spinner account;
    private EditText name;
    private EditText iban;
    private EditText amount;
    private TextView birim;
    private Button button;
    private int indexAccount;

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    private ArrayList<String> acNameList = new ArrayList<String>();

    public TransferTalimatFragment() {
        // Required empty public constructor
    }

    public static TransferTalimatFragment newInstance(String param1, String param2) {
        TransferTalimatFragment fragment = new TransferTalimatFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_transfer_talimat, container, false);
        date = view.findViewById(R.id.tarih_edit);
        name = view.findViewById(R.id.name_edit);
        account = view.findViewById(R.id.gonderici_spinner);
        birim = view.findViewById(R.id.birim);
        iban = view.findViewById(R.id.alici_iban_edit);
        amount = view.findViewById(R.id.gonderim_edit);
        button = view.findViewById(R.id.buton);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        acNameList.clear();
        for (Account a : MockAccount.accounts) {
            acNameList.add(a.getAccountName() + " \n" + a.getAmountOfBalance() + " " + a.getCurrencyCode());
        }

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, acNameList);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        account.setAdapter(dataAdapter);
        account.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                indexAccount = i;
                if (MockAccount.accounts.get(indexAccount).getCurrencyCode().equals("TRY")) {
                    birim.setText("TL");
                } else {
                    birim.setText(MockAccount.accounts.get(indexAccount).getCurrencyCode());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }
        };
        date.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new DatePickerDialog(getContext(), dateSetListener, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (name.getText().toString().isEmpty() || iban.getText().toString().isEmpty() || amount.getText().toString().isEmpty() || date.getText().toString().isEmpty()) {
                    Toast.makeText(getContext(), "Bütün alanların doldurulması zorunludur", Toast.LENGTH_LONG).show();
                } else
                {
                    ScheduledTransactionForIbanEft transaction = new ScheduledTransactionForIbanEft();
                    transaction.getResponse(new Parameter(new Message(), 0, name.getText().toString(), "", date.getText().toString()), new Callback<Response>() {
                        @Override
                        public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                            if (response.body() != null && response.code() == 200) {
                                Toast.makeText(getContext(), "Talimat Olusturuldu", Toast.LENGTH_LONG).show();
                            }else {
                                Toast.makeText(getContext(), "Talimat Olusturulamadi", Toast.LENGTH_LONG).show();
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
    private void updateLabel() {
        String myFormat = "yy-MM-dd hh:mm:ss"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        date.setText(sdf.format(myCalendar.getTime()));
    }
}