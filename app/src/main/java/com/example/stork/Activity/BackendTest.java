package com.example.stork.Activity;

/*import com.example.stork.API.GetRate.GetCurrencyRatesForSpecificDay;
import com.example.stork.API.GetRate.Request.Parameters;
import com.example.stork.API.GetRate.Request.Request;
import com.example.stork.API.GetRate.Response.Response;
import com.example.stork.API.ProcessEftRequestToIban.Request.Header;*/

import com.example.stork.API.AccList.GetAccList;
import com.example.stork.API.AccList.Request.Parameters;
import com.example.stork.API.AccList.Request.Request;
import com.example.stork.API.AccList.Response.Response;
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


    public void fillTestData(){
        DatabaseUtil db = new DatabaseUtil();
        SavedCustomer nc1 = new SavedCustomer("CİHAT TAVLI", "TR920013400001366661900001","https://img.a.transfermarkt.technology/portrait/big/3139-1459504284.jpg?lm=1");
        SavedCustomer nc2 = new SavedCustomer("HASAN GÜVEN", "TR900001002533034585185045","https://ichef.bbci.co.uk/news/640/cpsprodpb/CE17/production/_116395725_55588050.jpg");
        db.addSavedCustomer(nc1);
        db.addSavedCustomer(nc2);
    }


    public void run(){

    }

    public void initMockAccount() {

        /*Services services = new Services();
        com.example.stork.API.RequestWireToAccount.Request.Header header = new com.example.stork.API.RequestWireToAccount.Request.Header("API","API7909c7de460b462aa1d","331eb5f529c74df2b800926b5f34b874","5252012362481156055");
        Parameters params = new Parameters();
        params.customerNo = "18";
        Request request = new Request(header, params);

        GetAccList retrofit = services.createRetrofit().create(GetAccList.class);
        Call<com.example.stork.API.AccList.Response.Response> result = retrofit.GetPostValue(request);
        result.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                for(int i=0; i<response.body().getData().accountList.size(); i++){
                    if((response.body().getData().accountList.get(i).accountSuffix == 10 && response.body().getData().accountList.get(i).branchCode == 1000) ||
                            (response.body().getData().accountList.get(i).accountSuffix == 32 && response.body().getData().accountList.get(i).branchCode == 1000) ||
                            (response.body().getData().accountList.get(i).accountSuffix == 352 && response.body().getData().accountList.get(i).branchCode == 9142) ||
                            (response.body().getData().accountList.get(i).accountSuffix == 35215 && response.body().getData().accountList.get(i).branchCode == 9142) ||
                            (response.body().getData().accountList.get(i).accountSuffix == 357 && response.body().getData().accountList.get(i).branchCode == 9142 && response.body().getData().accountList.get(i).currencyCode.equals("EUR"))
                    ) {
                        System.out.println(response.body().getData().accountList.get(i).accountName);
                        System.out.println(response.body().getData().accountList.get(i).currencyCode);
                        System.out.println(response.body().getData().accountList.get(i).accountSuffix);
                        System.out.println(response.body().getData().accountList.get(i).branchCode);
                        System.out.println(response.body().getData().accountList.get(i).iBANNo);
                        System.out.println(response.body().getData().accountList.get(i).amountOfBalance);
                        System.out.println("***************************");
                    }

                }
                //System.out.println("Response:" + response.body().getData().accountList.toString());
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                System.out.println("Hatalı.");
            }
        });*/

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
