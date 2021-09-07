package com.example.stork;


import com.example.stork.API.AccList.GetAccList;
import com.example.stork.API.AccList.Request.Parameters;
import com.example.stork.API.AccList.Request.Request;
import com.example.stork.API.AccList.Response.Response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class MockAccount implements Serializable {

    private final String name =  "ATANALCAR ENOPHRYS";
    private final String citizenshipNumber = "11111"; //80722431894
    private final String customerNo ="18";
    private final String password = "12345";
    private ArrayList<Account> accounts;

    public String getName() {
        return name;
    }

    public String getCitizenshipNumber() {
        return citizenshipNumber;
    }

    public String getCustomerNo() {
        return customerNo;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void readAccountsData(CallWrapperAccounts myCallback){
        List<Account> accs = new ArrayList<>();

        Services services = new Services();
        com.example.stork.API.RequestWireToAccount.Request.Header header = new com.example.stork.API.RequestWireToAccount.Request.Header("API","API7909c7de460b462aa1d","331eb5f529c74df2b800926b5f34b874","5252012362481156055");
        Parameters params = new Parameters();
        params.customerNo = "18";
        Request request = new Request(header, params);

        GetAccList retrofit = services.createRetrofit().create(GetAccList.class);
        Call<Response> result = retrofit.GetPostValue(request);
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
                        Account sa = new Account(response.body().getData().accountList.get(i).accountSuffix,
                                response.body().getData().accountList.get(i).branchCode,
                                18,
                                response.body().getData().accountList.get(i).iBANNo,
                                response.body().getData().accountList.get(i).amountOfBalance,
                                response.body().getData().accountList.get(i).currencyCode,
                                response.body().getData().accountList.get(i).accountName
                        );
                        accs.add(sa);
                    }

                    myCallback.readAccountsDataCallback(accs);

                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                System.out.println("Hatalı.");
            }
        });

    }

}