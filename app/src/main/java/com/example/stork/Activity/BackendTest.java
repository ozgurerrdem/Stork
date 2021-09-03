package com.example.stork.Activity;

/*import com.example.stork.API.GetRate.GetCurrencyRatesForSpecificDay;
import com.example.stork.API.GetRate.Request.Parameters;
import com.example.stork.API.GetRate.Request.Request;
import com.example.stork.API.GetRate.Response.Response;
import com.example.stork.API.ProcessEftRequestToIban.Request.Header;*/
import com.example.stork.API.ExchangeRateApi.*;
import com.example.stork.API.ExchangeRateApi.Response.Response;
import com.example.stork.Database.CallWrapperCustomer;
import com.example.stork.Database.DatabaseUtil;
import com.example.stork.Database.Models.SavedCustomer;
import com.example.stork.Database.Models.SavedTransaction;
import com.example.stork.Database.CallWrapperTransaction;
import com.example.stork.Services;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class BackendTest {

    List<SavedCustomer> customersa = new ArrayList<SavedCustomer>();

    public void run() {

        Services services = new Services();
        ExchangeRateApi RetrofitClient =services.createExchangeRetrofit().create(ExchangeRateApi.class);
        Call<Response> res = RetrofitClient.GetCurrencyValues();
        res.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {

                System.out.println("HTTP KODU --> "+response.code());
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {

            }

        });

     /*   //First test.
        readCustomersFromDatabaseTest();
        int i= 0;
        System.out.println("SİZEAAA:" + customersa.size());
        for(SavedCustomer sc : customersa){
            System.out.print(i + ":");
            System.out.println(customersa.get(i).getName() + " " + customersa.get(i).getIBAN());
            i++;
        }
*/
    }

    private void GetDailyCurrencyRate() {
        /*Services services = new Services();
        Header header = new Header("API","API7909c7de460b462aa1d","331eb5f529c74df2b800926b5f34b874","5252012362481156055");
        Parameters params = new Parameters();
        Request request = new Request(header,params);
        GetCurrencyRatesForSpecificDay RetrofitClient =services.createRetrofit().create(GetCurrencyRatesForSpecificDay.class);
        Call<Response> res = RetrofitClient.GetPostValue(request);
        res.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {

                System.out.println("HTTP KODU --> "+response.code());

            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {

            }

        });*/
    }

    public void addCustomerToDatabaseTest(){

        DatabaseUtil db = new DatabaseUtil();
        SavedCustomer nc1 = new SavedCustomer("Doruk ERGÜN", "67888888","link");
        SavedCustomer nc2 = new SavedCustomer("sadsadsad", "1","link");
        SavedCustomer nc3 = new SavedCustomer("LMAOOO", "673333","link");
        SavedCustomer nc4 = new SavedCustomer("Dorsdsd", "672","link");
        db.addSavedCustomer(nc1);
        db.addSavedCustomer(nc2);
        db.addSavedCustomer(nc3);
        db.addSavedCustomer(nc4);

    }

    public void readTransactionsFromDatabaseTest(){
        DatabaseUtil db = new DatabaseUtil();
        db.readTransactionData(new CallWrapperTransaction() {
            @Override
            public void readTransactionDataCallback(List<SavedTransaction> transactions) {
                System.out.println(transactions.get(0).getAmount() + " " + transactions.get(0).getExplanation() + " " + transactions.get(0).getExplanation() + " " + transactions.get(0).getReceiverName() + " ");
            }
        });
    }


    public void readCustomersFromDatabaseTest(){

        DatabaseUtil db = new DatabaseUtil();
        db.readCustomerData(new CallWrapperCustomer() {
            @Override
            public void readCustomerDataCallback(List<SavedCustomer> customers) {
                System.out.println("asdasdsads size: " + customers.size());
                for(SavedCustomer cs : customers){
                    customersa.add(new SavedCustomer(cs.getName(), cs.getIBAN(), "link..."));
                }
                //customersa = customers;
            }
        });
        /*
        db.readCustomerData(new CallWrapperCustomer() {
            @Override
            public void readCustomerDataCallback(List<SavedCustomer> customers) {
                int i = 0;
                for(SavedCustomer sc : customers){
                    System.out.print(i + ":");
                    System.out.println(customers.get(i).getName() + " " + customers.get(i).getIBAN());
                    i++;
                }
            }
        });*/
    }
    public void controlExchangeRate(){

    }

    /**
     * Yeni test fonksiyonlarının tanımlara aşağıya, run() içinde çağırmayı unutmayın..
     */

}
