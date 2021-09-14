package com.example.stork.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.example.stork.API.GetRate.GetRate;
import com.example.stork.API.GetRate.Response.Response;
import com.example.stork.Adapter.CurrencyAdapter;
import com.example.stork.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;

public class MarketActivity extends AppCompatActivity {
    private RelativeLayout bar;
    private RecyclerView rView;
    private ArrayList<Currency> currencies = new ArrayList<>();
    private CurrencyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);
        ImageButton backButton = findViewById(R.id.back_btn77);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

            }
        });
        bar = findViewById(R.id.loadingPanel);
        adapter = new CurrencyAdapter(currencies,this);
        rView = findViewById(R.id.recyclerView);
        rView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        rView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        new MyAsyncTask().execute();

    }
    private class MyAsyncTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params) {

            getCurr();
            System.out.println("Run finished..");
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            bar.setVisibility(View.GONE);
            adapter.notifyDataSetChanged();
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //TODO Progress bar
            bar.setVisibility(View.VISIBLE);
        }
    }

    private void getCurr() {
        GetRate get = new GetRate();
        get.getResponse(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {

                for (int i = 0; i < 10; i++) {
                    System.out.println("---------------------------------------------");
                    System.out.println(response.body().result.get(i).name + " Satış : " + response.body().result.get(i).selling + " Alış : " + response.body().result.get(i).buying);
                    currencies.add(new Currency(response.body().result.get(i).name, Double.parseDouble(response.body().result.get(i).buying), Double.parseDouble(response.body().result.get(i).selling)));
                }

            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {

            }
        });
    }

    public class Currency {
        private String name;
        private Double alis;
        private Double satis;

        public Currency(String name, double alis, double satis) {
            this.name = name;
            this.alis = alis;
            this.satis = satis;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Double getAlis() {
            return alis;
        }

        public void setAlis(double alis) {
            this.alis = alis;
        }

        public Double getSatis() {
            return satis;
        }

        public void setSatis(double satis) {
            this.satis = satis;
        }
    }
}