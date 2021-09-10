package com.example.stork.Fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.stork.Account;
import com.example.stork.Database.Models.SavedCustomer;
import com.example.stork.MockAccount;
import com.example.stork.Model.BankMap;
import com.example.stork.R;

import java.util.ArrayList;
import java.util.Set;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CardTransferFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CardTransferFragment extends Fragment {
    private int indexAccount =0;
    private String bankValue;
    private Spinner account;
    private Spinner bank;
    private Spinner branch;
    private EditText accountNum;
    private EditText name;
    private EditText amount;
    private EditText exp;
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
        branch = view.findViewById(R.id.branch_spin);
        bank = view.findViewById(R.id.bank_spin);
        accountNum = view.findViewById(R.id.hesapno_editt);
        name = view.findViewById(R.id.name_edit);
        amount = view.findViewById(R.id.gonderilecek_editt);
        exp = view.findViewById(R.id.aciklama_edit);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        acNameList.clear();
        for (Account a : MockAccount.accounts) {
            acNameList.add(a.getAccountName());
        }
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, acNameList);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        account.setAdapter(dataAdapter);
        account.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                indexAccount = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        BankMap bankMap = new BankMap();

        ArrayList<String> bankList=  new ArrayList<String>(bankMap.getKeyList());
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item,bankList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bank.setAdapter(adapter);
        bank.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               bankValue = bankMap.getValue(bankList.get(i));
                Toast.makeText(getContext(),bankValue,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        SavedCustomer saved = (SavedCustomer) getArguments().getSerializable("saved");
        if (saved != null) {
            name.setText(saved.getName());
        }
    }
}