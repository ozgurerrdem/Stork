package com.example.stork.Activity;

import android.widget.Toast;

import com.example.stork.API.RequestWireToName.Request.Header;
import com.example.stork.API.RequestWireToName.Request.Parameters;
import com.example.stork.API.RequestWireToName.Request.Request;
import com.example.stork.API.RequestWireToName.Request.SourceAccount;
import com.example.stork.API.RequestWireToName.RequestWireToName;
import com.example.stork.API.RequestWireToName.Response.Response;
import com.example.stork.Database.DatabaseUtil;
import com.example.stork.Database.Models.SavedTransaction;
import com.example.stork.Database.CallWrapper;
import com.example.stork.Services;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class BackendTest {

    public void run() {

        //First test.
        //readToDatabaseTest();
        //testRequestWireToName();

    }

    public void readToDatabaseTest(){
        DatabaseUtil db = new DatabaseUtil();
        db.readData(new CallWrapper() {
            @Override
            public void readDataCallback(List<SavedTransaction> transactions) {
                System.out.println(transactions.get(0).getAmount() + " " + transactions.get(0).getExplanation() + " " + transactions.get(0).getExplanation() + " " + transactions.get(0).getReceiverName() + " ");
            }
        });
    }

    /**
     * Yeni test fonksiyonlarının tanımlara aşağıya, run() içinde çağırmayı unutmayın..
     */

    public void testRequestWireToName(){
        Services services = new Services();

        SourceAccount sourceAccount = new SourceAccount();
        sourceAccount.setAccountSuffix(355);
        sourceAccount.setBranchCode(9142);
        sourceAccount.setCustomerNo(3374562);

        //System.out.println("OLDUUUUUUUUUAAAAAAAAAA11111");

        Parameters parameters = new Parameters();
        parameters.setDestinationBranchCode(9300);
        parameters.setDestinationName("BEOR THE OLD");
        parameters.setDestinationLastName("ANGUİLLİFORMES");
        parameters.setDestinationPhoneNo("5468996863");
        parameters.setDestinationMotherName("GUĞU ÇİÇEĞİ");
        parameters.setDestinationFatherName("RAPHANUS RAPHANİSTRUM");
        parameters.setDestinationBirthDate("1936-07-19 14:43:24.480");
        parameters.setReceiverName("ali");
        parameters.setForceDuplicate(true);
        parameters.setCustomerNo(3374562);
        parameters.setSourceAccount(sourceAccount);
        parameters.setExplanation("test");
        parameters.setAmount(1);

        Header header = new Header("API7909c7de460b462aa1d","API","54dsaf4ds3h2g1jhg651d","a7f77648-dfb7-42ef-a4b8-db6b79c1cfab");

        Request Request1 =  new Request(header,parameters);

        RequestWireToName RetrofitClient = services.createRetrofit().create(RequestWireToName.class);

        Call<Response> res = RetrofitClient.GetPostValue(Request1);
        //System.out.println("OLDUUUUUUUUUAAAAAAAAAA2222");
        res.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                //System.out.println("OLDUUUUUUUUUAAAAAAAAAA3333");
                System.out.println("HTTP STATUS"+response.code());
                if(response.body().getData()!=null){
                    System.out.println(response.body().getData().getTransactionID());
                }else{
                    System.out.println("OLMADDDDIII!!!");
                }

            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                System.out.println(t.getCause()  +"FAILLLLLLLLLL!!!!!!!!!!");
            }
        });
    }

}
