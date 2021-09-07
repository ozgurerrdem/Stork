package com.example.stork.Fragment;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.stork.Account;
import com.example.stork.CallWrapperAccounts;
import com.example.stork.MockAccount;
import com.example.stork.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CardTransferFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CardTransferFragment extends Fragment {
    private Spinner account;
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

        MockAccount mc = new MockAccount();
        mc.readAccountsData(new CallWrapperAccounts() {
            @Override
            public void readAccountsDataCallback(List<Account> accounts) {
                for (Account ac : accounts) {
                    acNameList.add(ac.getAccountName());
                }
                ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, acNameList);
                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                account.setAdapter(dataAdapter);
                account.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        // On selecting a spinner item
                        String item = adapterView.getItemAtPosition(i).toString();

                        // Showing selected spinner item
                        Toast.makeText(adapterView.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });
            }
        });







        return view;
    }

}