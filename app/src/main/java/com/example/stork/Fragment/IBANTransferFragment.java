package com.example.stork.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.stork.API.AccList.GetAccList;
import com.example.stork.API.RequestWireToIban.Request.Header;
import com.example.stork.API.RequestWireToIban.Request.Parameters;
import com.example.stork.API.RequestWireToIban.Request.Request;
import com.example.stork.API.RequestWireToIban.Request.SourceAccount;
import com.example.stork.API.RequestWireToIban.RequestWireToIban;
import com.example.stork.API.RequestWireToIban.Response.Response;
import com.example.stork.Database.DatabaseUtil;
import com.example.stork.Database.Models.SavedCustomer;
import com.example.stork.R;
import com.example.stork.Services;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link IBANTransferFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class IBANTransferFragment extends Fragment {
    private Spinner account;
    private EditText iban;
    private EditText name;
    private EditText amount;
    private EditText exp;
    private CheckBox checkBox;
    private Button button;

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
        button = view.findViewById(R.id.button);

        List<String> categories = new ArrayList<String>();
        categories.add("Automobile");
        categories.add("Business Services");
        categories.add("Computers");
        categories.add("Education");
        categories.add("Personal");
        categories.add("Travel");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, categories);
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

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (iban.getText().toString().isEmpty() || name.getText().toString().isEmpty() || amount.getText().toString().isEmpty()) {
                    Toast.makeText(getContext(),"Alanlari Doldurunuz",Toast.LENGTH_LONG).show();
                } else {
                    if (checkBox.isChecked()){
                        DatabaseUtil db = new DatabaseUtil();
                        db.addSavedCustomer(new SavedCustomer(name.getText().toString(),iban.getText().toString(),""));
                    }
                    /* TODO Transferi Tamamla */
                }
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}