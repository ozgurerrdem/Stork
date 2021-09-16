package com.example.stork.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.example.stork.API.CurrencyRate.GetCripto;
import com.example.stork.API.CurrencyRate.GetCryptoCurrency;
import com.example.stork.API.GetRate.GetCurrencyRatesForSpecificDay;
import com.example.stork.API.GetRate.GetRate;
import com.example.stork.API.GetRate.Response.Response;
import com.example.stork.API.GoldRate.GetGold;
import com.example.stork.API.GoldRate.GetGoldRate;
import com.example.stork.Adapter.CurrencyAdapter;
import com.example.stork.R;
import com.example.stork.Services;

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
            getGold();
            getCrypto();
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

    private void getCrypto() {
        Services serv = new Services();
        GetCryptoCurrency cryp = serv.createExchangeRetrofit().create(GetCryptoCurrency.class);
        Call<com.example.stork.API.CurrencyRate.Response.Response> res = cryp.GetPostValue();
        try
        {
            retrofit2.Response<com.example.stork.API.CurrencyRate.Response.Response> response =res.execute();
            com.example.stork.API.CurrencyRate.Response.Response apiResponse = response.body();

            //API response
            System.out.println("------------------------------");
            System.out.println("KOD: "+response.code());
            for (int i = 0; i < apiResponse.result.size(); i++) {
                System.out.println("---------------------------------------------");
                if (apiResponse.result.get(i).code.equals("ETH") || apiResponse.result.get(i).code.equals("BTC") ){
                System.out.println(response.body().result.get(i).name + " Satış : " + response.body().result.get(i).marketCapstr + " Alış : " + response.body().result.get(i).pricestr);
                currencies.add(new Currency(response.body().result.get(i).name, response.body().result.get(i).marketCapstr, response.body().result.get(i).pricestr));}
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

    }

    private void getGold() {
        Services serv = new Services();
        GetGoldRate cryp = serv.createExchangeRetrofit().create(GetGoldRate.class);
        Call<com.example.stork.API.GoldRate.Response.Response> res = cryp.GetPostValue();
        try
        {
            retrofit2.Response<com.example.stork.API.GoldRate.Response.Response> response =res.execute();
            com.example.stork.API.GoldRate.Response.Response apiResponse = response.body();

            //API response
            System.out.println("------------------------------");
            System.out.println("KOD: "+response.code());
            for (int i = 0; i < apiResponse.result.size(); i++) {
                System.out.println("---------------------------------------------");
                System.out.println(response.body().result.get(i).name + " Satış : " + response.body().result.get(i).sell + " Alış : " + response.body().result.get(i).buy);
               // currencies.add(new Currency(response.body().result.get(i).name, Double.parseDouble(response.body().result.get(i).buy), Double.parseDouble(response.body().result.get(i).sell)));
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

    }

    private void getCurr() {
        Services serv = new Services();
    GetCurrencyRatesForSpecificDay cryp = serv.createExchangeRetrofit().create(GetCurrencyRatesForSpecificDay.class);
    Call<com.example.stork.API.GetRate.Response.Response> res = cryp.GetPostValue();
        try
        {
            retrofit2.Response<com.example.stork.API.GetRate.Response.Response> response =res.execute();
           Response apiResponse = response.body();

            //API response
            System.out.println("------------------------------");
            System.out.println("KOD: "+response.code());
            for (int i = 0; i < apiResponse.result.size(); i++) {


                System.out.println("---------------------------------------------");
                System.out.println(response.body().result.get(i).name + " Satış : " + response.body().result.get(i).selling + " Alış : " + response.body().result.get(i).buying);
                if (response.body().result.get(i).name.isEmpty() || response.body().result.get(i).name == null) {
                    currencies.add(new Currency("Birim", response.body().result.get(i).buying, response.body().result.get(i).selling));
                } else {
                    currencies.add(new Currency(response.body().result.get(i).name, response.body().result.get(i).buying, response.body().result.get(i).selling));
                }
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }



     /*    GetRate get = new GetRate();
       get.getResponse(new Callback<com.example.stork.API.GetRate.Response.Response>() {
           @Override
           public void onResponse(Call<com.example.stork.API.GetRate.Response.Response> call, retrofit2.Response<com.example.stork.API.GetRate.Response.Response> response) {
               for (int i = 0; i < 10; i++) {
                   System.out.println("---------------------------------------------");
                   System.out.println(response.body().result.get(i).name + " Satış : " + response.body().result.get(i).selling + " Alış : " + response.body().result.get(i).buying);
                   currencies.add(new Currency(response.body().result.get(i).name, Double.parseDouble(response.body().result.get(i).buying), Double.parseDouble(response.body().result.get(i).selling)));
               }
           }

           @Override
           public void onFailure(Call<com.example.stork.API.GetRate.Response.Response> call, Throwable t) {

           }
       });*/
      /*  GetGold gold = new GetGold();
        gold.getResponse(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
                System.out.println(response.body().result.get(0).name);
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                System.out.println("Altın Yok");
            }
        });*/

    }

    public class Currency {
        private String name;
        private String alis;
        private String satis;

        public Currency(String name, String alis, String satis) {
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

        public String getAlis() {
            return alis;
        }

        public void setAlis(String alis) {
            this.alis = alis;
        }

        public String getSatis() {
            return satis;
        }

        public void setSatis(String satis) {
            this.satis = satis;
        }
    }
}