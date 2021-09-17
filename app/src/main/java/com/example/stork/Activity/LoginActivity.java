package com.example.stork.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.stork.MockAccount;
import com.example.stork.R;

public class LoginActivity extends AppCompatActivity {
    private Button login_btn;
    private RelativeLayout bar;
    private EditText numba;
    private EditText pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bar = findViewById(R.id.loadingPanel);
        numba = findViewById(R.id.editText3);
        pass = findViewById(R.id.editText2);
        bar.setVisibility(View.GONE);

        login_btn = findViewById(R.id.login_btn);

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pass.onEditorAction(EditorInfo.IME_ACTION_DONE);
                if (numba.getText().toString().isEmpty() || pass.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Bütün alanların doldurulması zorunludur!", Toast.LENGTH_LONG).show();
                } else if ((numba.getText().toString().equals(MockAccount.citizenshipNumber) || numba.getText().toString().equals(MockAccount.customerNo)) && pass.getText().toString().equals(MockAccount.password)) {
                    new MyAsyncTask().execute();
                } else {
                    Toast.makeText(getApplicationContext(), "Bilgilerinizi kontrol edin!", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private class MyAsyncTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params) {
            MockAccount ma = new MockAccount();
            System.out.println("Run finished..");
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            bar.setVisibility(View.GONE);
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //TODO Progress bar
            bar.setVisibility(View.VISIBLE);
        }
    }
}