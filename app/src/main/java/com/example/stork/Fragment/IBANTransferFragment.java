package com.example.stork.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.stork.API.ProcessEftRequestToIban.EftToIban;
import com.example.stork.API.RequestWireToIban.Request.Parameters;
import com.example.stork.API.RequestWireToIban.Request.SourceAccount;
import com.example.stork.API.RequestWireToIban.Response.Response;
import com.example.stork.API.RequestWireToIban.WireToIban;
import com.example.stork.Account;
import com.example.stork.Activity.IbanSendAnimationActivity;
import com.example.stork.Activity.SendDoneActivity;
import com.example.stork.Database.DatabaseUtil;
import com.example.stork.Database.Models.SavedCustomer;
import com.example.stork.MockAccount;
import com.example.stork.R;
import com.example.stork.Services;

import java.io.Serializable;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link IBANTransferFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class IBANTransferFragment extends Fragment {
    private int indexAccount = 0;
    private Spinner account;
    private EditText iban;
    private EditText name;
    private EditText amount;
    private EditText exp;
    private TextView tum_bak;
    private TextView birim;
    private CheckBox checkBox;
    private Button button;
    private RelativeLayout bar;
    private ArrayList<String> acNameList = new ArrayList<String>();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public IBANTransferFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment tab1.
     */
    // TODO: Rename and change types and number of parameters
    public static IBANTransferFragment newInstance(String param1, String param2) {
        IBANTransferFragment fragment = new IBANTransferFragment();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_iban_transfer, container, false);
        account = view.findViewById(R.id.hesabim_spinner);
        iban = view.findViewById(R.id.iban_edit);
        name = view.findViewById(R.id.aliciad_edit);
        amount = view.findViewById(R.id.gonderilecek_edit);
        exp = view.findViewById(R.id.aciklama_edit);
        checkBox = view.findViewById(R.id.chechBox);
        button = view.findViewById(R.id.login_btn);
        bar = view.findViewById(R.id.loadingPanel);
        tum_bak = view.findViewById(R.id.tum_bak);
        birim = view.findViewById(R.id.birim);


        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        acNameList.clear();
        for (Account a : MockAccount.accounts) {
            acNameList.add(a.getAccountName() + " \n" + a.getAmountOfBalance() + " " + a.getBirimCevirme());
        }

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, acNameList);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        account.setAdapter(dataAdapter);
        account.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
        tum_bak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                amount.setText(MockAccount.accounts.get(indexAccount).getAmountOfBalance().toString());
            }
        });

        SavedCustomer saved = (SavedCustomer) getArguments().getSerializable("saved");
        if (saved != null) {
            name.setText(saved.getName());
            iban.setText(saved.getIBAN());
        }
        Services services = new Services();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exp.onEditorAction(EditorInfo.IME_ACTION_DONE);
                if (iban.getText().toString().isEmpty() || name.getText().toString().isEmpty() || amount.getText().toString().isEmpty()) {
                    Toast.makeText(getContext(), "Bütün alanların doldurulması zorunludur", Toast.LENGTH_LONG).show();
                } else {
                    if (Integer.parseInt(amount.getText().toString()) <= MockAccount.accounts.get(indexAccount).getAmountOfBalance() - 30) {
                        bar.setVisibility(View.VISIBLE);
                        if (checkBox.isChecked()) {
                            DatabaseUtil db = new DatabaseUtil();
                            db.addSavedCustomer(new SavedCustomer(name.getText().toString().toUpperCase(), iban.getText().toString().toUpperCase(), ""));
                        }
                        if (services.compareBanksByIban(iban.getText().toString(), MockAccount.accounts.get(indexAccount).getIBANNo())) {
                            //HAVALE
                            System.out.println("HAVALEEEEEE");
                            WireToIban wire = new WireToIban();
                            Parameters par = new Parameters(exp.getText().toString(), Integer.valueOf(amount.getText().toString()), iban.getText().toString().toUpperCase(), new SourceAccount(indexAccount), name.getText().toString().toUpperCase());
                            wire.getResponse(par, new Callback<Response>() {
                                @Override
                                public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                                    System.out.println(par.toString());
                                    System.out.println(response.code());
                                    if (response.code() == 200 && response.body() != null && response.body().getData() != null) {
                                        bar.setVisibility(View.GONE);
                                        Toast.makeText(getContext(), "Işlem Başarılı", Toast.LENGTH_LONG).show();
                                        if(response.body().getData()  != null){
                                            MockAccount.accounts.get(indexAccount).setAmountOfBalance((float) (MockAccount.accounts.get(indexAccount).getAmountOfBalance() - Float.parseFloat(amount.getText().toString()) + response.body().getData().expenseAmount));
                                        }else{
                                            MockAccount.accounts.get(indexAccount).setAmountOfBalance((float) (MockAccount.accounts.get(indexAccount).getAmountOfBalance() - Float.parseFloat(amount.getText().toString())));
                                        }
                                        Bundle bundle = new Bundle();
                                        ArrayList<String> a = new ArrayList<String>();
                                        a.add(response.body().data.transactionDate);
                                        a.add(response.body().data.expenseAmount.toString());
                                        a.add(MockAccount.accounts.get(indexAccount).getAmountOfBalance().toString());
                                        a.add(MockAccount.accounts.get(indexAccount).getAccountName());
                                        a.add(MockAccount.accounts.get(indexAccount).getBirimCevirme());

                                        bundle.putSerializable("pdf_key",
                                                a ); // burayı değiştim
                                        Intent intent = new Intent(getActivity().getApplicationContext(), IbanSendAnimationActivity.class);
                                        intent.putExtras(bundle);
                                        getActivity().startActivity(intent);
                                    } else {
                                        bar.setVisibility(View.GONE);
                                        Toast.makeText(getContext(), "Işlem Gerçekleştirilemedi", Toast.LENGTH_LONG).show();
                                    }
                                    if (response.body() != null && response.body().getData() != null) {
                                        System.out.println("RESPONSE: " + response.body().getData().transactionDate + " " + response.body().getData().expenseAmount);
                                    } else {
                                        System.out.println("NULLLLLLLLLL");
                                    }
                                }

                                @Override
                                public void onFailure(Call<Response> call, Throwable t) {
                                    System.out.println("HATA: " + t.getMessage());
                                }
                            });
                        } else {
                            //EFT
                            System.out.println("EFTTTTT");
                            EftToIban eftToIban = new EftToIban();
                            com.example.stork.API.ProcessEftRequestToIban.Request.Parameters par = new com.example.stork.API.ProcessEftRequestToIban.Request.Parameters(
                                    exp.getText().toString(),
                                    iban.getText().toString(),
                                    Integer.valueOf(services.getBankCode(iban.getText().toString())),
                                    Integer.valueOf(amount.getText().toString()),
                                    Integer.valueOf(MockAccount.customerNo),
                                    new com.example.stork.API.ProcessEftRequestToIban.Request.SourceAccount(indexAccount),
                                    name.getText().toString().toUpperCase(),
                                    true
                            );
                            eftToIban.getResponse(par, new Callback<com.example.stork.API.ProcessEftRequestToIban.Response.Response>() {
                                @Override
                                public void onResponse(Call<com.example.stork.API.ProcessEftRequestToIban.Response.Response> call, retrofit2.Response<com.example.stork.API.ProcessEftRequestToIban.Response.Response> response) {
                                    System.out.println(response.code());
                                    if (response.code() == 200 && response.body() != null && response.body().getData() != null) {
                                        bar.setVisibility(View.GONE);
                                        Toast.makeText(getContext(), "Işlem Başarılı", Toast.LENGTH_LONG).show();
                                        if(response.body().getData()  != null){
                                            MockAccount.accounts.get(indexAccount).setAmountOfBalance((float) (MockAccount.accounts.get(indexAccount).getAmountOfBalance() - Float.parseFloat(amount.getText().toString()) + response.body().getData().expenseAmount));
                                        }else{
                                            MockAccount.accounts.get(indexAccount).setAmountOfBalance((float) (MockAccount.accounts.get(indexAccount).getAmountOfBalance() - Float.parseFloat(amount.getText().toString())));
                                        }
                                        Bundle bundle = new Bundle();
                                        ArrayList<String> a = new ArrayList<String>();
                                        a.add(response.body().data.transactionDate);
                                        a.add(response.body().data.expenseAmount.toString());
                                        a.add(MockAccount.accounts.get(indexAccount).getAmountOfBalance().toString());
                                        a.add(MockAccount.accounts.get(indexAccount).getAccountName());
                                        a.add(MockAccount.accounts.get(indexAccount).getBirimCevirme());

                                        bundle.putSerializable("pdf_key",
                                                a ); // burayı değiştim
                                        Intent intent = new Intent(getActivity().getApplicationContext(), IbanSendAnimationActivity.class);
                                        intent.putExtras(bundle);
                                        getActivity().startActivity(intent);


                                    } else {
                                        bar.setVisibility(View.GONE);
                                        Toast.makeText(getContext(), "Işlem Gerçekleştirilemedi", Toast.LENGTH_LONG).show();
                                        if (response.body() == null || response.body().getData() == null) {
                                            System.out.println("Response boş");
                                        } else {
                                            System.out.println(response.body().getData().transactionDate);
                                        }
                                    }
                                }

                                @Override
                                public void onFailure(Call<com.example.stork.API.ProcessEftRequestToIban.Response.Response> call, Throwable t) {

                                }
                            });
                        }
                    }
                    else {
                        Toast.makeText(getContext(),"Bakiyeniz Yeterli değil",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}