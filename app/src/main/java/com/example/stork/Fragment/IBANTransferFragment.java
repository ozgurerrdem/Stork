package com.example.stork.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
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

import retrofit2.Call;
import retrofit2.Callback;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link IBANTransferFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class IBANTransferFragment extends Fragment {
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
        iban = view.findViewById(R.id.iban_edit);
        name = view.findViewById(R.id.aliciad_edit);
        amount = view.findViewById(R.id.gonderilecek_edit);
        exp = view.findViewById(R.id.aciklama_edit);
        checkBox = view.findViewById(R.id.chechBox);
        button = view.findViewById(R.id.button);

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
                    /* TODO Fonksiyonla bunu   */
                    Services services = new Services();
                    Parameters params = new Parameters();
                    params.amount = Integer.valueOf(amount.getText().toString());
                    params.explanation = exp.getText().toString();
                    params.customerNo = 12695508;
                    params.taxNumber = 0;
                    params.iBANNumber = iban.getText().toString();
                    SourceAccount source = new SourceAccount();
                    source.accountSuffix = 352;
                    source.branchCode = 4420;
                    source.currencyCode = "TRY";
                    source.customerNo = 12695508;
                    params.sourceAccount = source;

                    params.receiverName = name.getText().toString();
                    params.forceDuplicate = true;
                    Header header = new Header("API","API7909c7de460b462aa1d","331eb5f529c74df2b800926b5f34b874","5252012362481156055");

                    Request request = new Request(header, params);

                    RequestWireToIban retrofit = services.createRetrofit().create(RequestWireToIban.class);
                    Call<com.example.stork.API.RequestWireToIban.Response.Response> result = retrofit.GetPostValue(request);
                    result.enqueue(new Callback<Response>() {
                        @Override
                        public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                            Toast.makeText(getContext(),"Tamam abi oldu"+ response.code(),Toast.LENGTH_LONG).show();

                        }

                        @Override
                        public void onFailure(Call<Response> call, Throwable t) {
                            Toast.makeText(getContext(),"Hayir abi olmadi"+t.getMessage(),Toast.LENGTH_LONG).show();
                        }
                    });
                    /* END */
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