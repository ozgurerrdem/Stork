package com.example.stork.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.stork.API.ProcessEftRequestToAccount.EftToAccount;
import com.example.stork.API.RequestWireToAccount.Request.DestinationAccount;
import com.example.stork.API.RequestWireToAccount.Request.Parameters;
import com.example.stork.API.RequestWireToAccount.Request.SourceAccount;
import com.example.stork.API.RequestWireToAccount.Response.Response;
import com.example.stork.API.RequestWireToAccount.WireToAccount;
import com.example.stork.Account;
import com.example.stork.Activity.IbanSendAnimationActivity;
import com.example.stork.Activity.SendDoneActivity;
import com.example.stork.Database.Models.SavedCustomer;
import com.example.stork.MockAccount;
import com.example.stork.Model.BankMap;
import com.example.stork.R;
import com.example.stork.Services;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CardTransferFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CardTransferFragment extends Fragment {
    private int indexAccount = 0;
    private String bankValue;
    private Spinner account;
    private Spinner bank;
    private EditText branch;
    private EditText accountNum;
    private EditText name;
    private EditText amount;
    private EditText exp;
    private EditText ekno;
    private TextView birim;
    private TextView tum_bak;
    private Button button;
    private RelativeLayout bar;
    ArrayList<String> acNameList = new ArrayList<>();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CardTransferFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment tab2.
     */
    // TODO: Rename and change types and number of parameters
    public static CardTransferFragment newInstance(String param1, String param2) {
        CardTransferFragment fragment = new CardTransferFragment();
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
        View view = inflater.inflate(R.layout.fragment_card_transfer, container, false);
        account = view.findViewById(R.id.hesabim_spinnerr);
        bank = view.findViewById(R.id.bank_spin);
        branch = view.findViewById(R.id.branch_edit);
        bank = view.findViewById(R.id.bank_spin);
        accountNum = view.findViewById(R.id.hesapno_editt);
        name = view.findViewById(R.id.name_edit);
        amount = view.findViewById(R.id.gonderilecek_editt);
        exp = view.findViewById(R.id.aciklama_edit);
        ekno = view.findViewById(R.id.ek_no_edit);
        button = view.findViewById(R.id.login_btn);
        birim = view.findViewById(R.id.birim);
        tum_bak = view.findViewById(R.id.tum_bak);
        bar = view.findViewById(R.id.loadingPanel);

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
        BankMap bankMap = new BankMap();

        ArrayList<String> bankList = new ArrayList<String>(bankMap.getKeyList());
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, bankList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bank.setAdapter(adapter);
        bank.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                bankValue = bankMap.getValue(bankList.get(i));
                //Toast.makeText(getContext(), bankValue, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        Services services = new Services();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (branch.getText().toString().isEmpty() || name.getText().toString().isEmpty() || amount.getText().toString().isEmpty()) {
                    Toast.makeText(getContext(), "Bütün alanların doldurulması zorunludur", Toast.LENGTH_LONG).show();
                } else {
                    bar.setVisibility(View.VISIBLE);
                    if (Integer.valueOf(bankValue).equals(Integer.valueOf(services.getBankCode(MockAccount.accounts.get(indexAccount).getIBANNo())))) {
                        //HAVALE
                        System.out.println("HAVALEEEEEE");
                        WireToAccount wire = new WireToAccount();
                        Parameters par = new Parameters(exp.getText().toString(),
                                Integer.valueOf(amount.getText().toString()),
                                new SourceAccount(indexAccount),
                                // Branch = 9142
                                // Customer No = 3487796

                                new DestinationAccount(Integer.valueOf(ekno.getText().toString()), Integer.valueOf(branch.getText().toString()), Integer.valueOf(accountNum.getText().toString())),
                                name.getText().toString().toUpperCase());
                        wire.getResponse(par, new Callback<Response>() {
                            @Override
                            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                                if (response.code() == 200 && response.body() != null && response.body().getData() != null) {
                                    bar.setVisibility(View.GONE);
                                    Toast.makeText(getContext(), "Işlem Başarılı", Toast.LENGTH_LONG).show();
                                    MockAccount.accounts.get(indexAccount).setAmountOfBalance((float) (MockAccount.accounts.get(indexAccount).getAmountOfBalance()-Float.parseFloat(amount.getText().toString()) - response.body().getData().getExpenseAmount()));
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
                                    System.out.println(par.toString());
                                    System.out.println(response.code());
                                    if (response.body().getData() != null) {
                                        System.out.println("RESPONSE: " + response.body().getData().transactionDate + " " + response.body().getData().expenseAmount);
                                    } else {
                                        System.out.println("NULLLLLLLLLL");
                                    }
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
                            public void onFailure(Call<Response> call, Throwable t) {
                                System.out.println("HATA: " + t.getMessage());
                            }
                        });
                    } else {
                        //EFT
                        System.out.println("EFTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT");
                        EftToAccount eft = new EftToAccount();
                        com.example.stork.API.ProcessEftRequestToAccount.Request.Parameters par = new com.example.stork.API.ProcessEftRequestToAccount.Request.Parameters(
                                Integer.valueOf(MockAccount.customerNo),
                                exp.getText().toString(),
                                MockAccount.accounts.get(indexAccount).getAccountName(),
                                "I",
                                Integer.valueOf(bankValue),
                                accountNum.getText().toString(),
                                Integer.valueOf(branch.getText().toString()),
                                "EFT_TYPE_TO_BRANCH",
                                amount.getText().toString(),
                                new com.example.stork.API.ProcessEftRequestToAccount.Request.SourceAccount(indexAccount,name.getText().toString().toUpperCase()),
                                "test",
                                true);
                        System.out.println(par.toString());
                        eft.getResponse(par, new Callback<com.example.stork.API.ProcessEftRequestToAccount.Response.Response>() {
                            @Override
                            public void onResponse(Call<com.example.stork.API.ProcessEftRequestToAccount.Response.Response> call, retrofit2.Response<com.example.stork.API.ProcessEftRequestToAccount.Response.Response> response) {
                                if (response.code() == 200 && response.body() != null && response.body().getData() != null) {
                                    bar.setVisibility(View.GONE);
                                    Toast.makeText(getContext(), "Işlem Başarılı", Toast.LENGTH_LONG).show();
                                    MockAccount.accounts.get(indexAccount).setAmountOfBalance((float) (MockAccount.accounts.get(indexAccount).getAmountOfBalance()-Float.parseFloat(amount.getText().toString())+ response.body().getData().getExpenseAmount()));
                                    Bundle bundle = new Bundle();
                                    ArrayList<String> a = new ArrayList<String>();
                                    a.add(response.body().data.getTransactionDate());
                                    a.add(response.body().data.getExpenseAmount().toString());
                                    a.add(MockAccount.accounts.get(indexAccount).getAmountOfBalance().toString());
                                    a.add(MockAccount.accounts.get(indexAccount).getAccountName());
                                    a.add(MockAccount.accounts.get(indexAccount).getBirimCevirme());

                                    bundle.putSerializable("pdf_key",
                                            a ); // burayı değiştim
                                    Intent intent = new Intent(getActivity().getApplicationContext(), IbanSendAnimationActivity.class);
                                    intent.putExtras(bundle);
                                    getActivity().startActivity(intent);

                                    System.out.println(response.code());
                                    if (response.body().getData() != null) {
                                        System.out.println("RESPONSE: " + response.body().getData().getTransactionDate() + " " + response.body().getData().getExpenseAmount());
                                    } else {
                                        System.out.println("NULLLLLLLLLL");
                                    }
                                } else {
                                    System.out.println(response.code());
                                    bar.setVisibility(View.GONE);
                                    Toast.makeText(getContext(), "Işlem Gerçekleştirilemedi", Toast.LENGTH_LONG).show();
                                    if (response.body() == null || response.body().getData() == null) {
                                        System.out.println("Response boş");
                                    } else {
                                        System.out.println(response.body().getData().getTransactionDate());
                                    }
                                }
                            }

                            @Override
                            public void onFailure(Call<com.example.stork.API.ProcessEftRequestToAccount.Response.Response> call, Throwable t) {
                                System.out.println("HATA: " + t.getMessage());
                            }
                        });
                    }
                }
            }
        });

    }
}