package com.example.stork.Activity;

import com.example.stork.API.ProcessEftRequestToIban.Request.Header;
import com.example.stork.API.SendFastMoneyOrder.Request.Parameters;
import com.example.stork.API.SendFastMoneyOrder.Request.Request;
import com.example.stork.API.SendFastMoneyOrder.Request.SourceAccount;
import com.example.stork.API.SendFastMoneyOrder.Response.Response;
import com.example.stork.API.SendFastMoneyOrder.SendFastMoneyOrder;
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
        readToDatabaseTest();
        SendfastMoneyOrder();

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

    private void SendfastMoneyOrder() {
        Services services = new Services();
        com.example.stork.API.ProcessEftRequestToIban.Request.Header header = new Header("API7909c7de460b462aa1d","API","331eb5f529c74df2b800926b5f34b874","5252012362481156055");
        Parameters params = new Parameters();
        params.paymentReason="07";
        params.paymentSource="M";
        params.senderAccountNumber="TR690013400093772246300352";
        params.senderIdentityNumber="88982218590";
        params.receiverCode="0046";
        params.receiverAccountNumber="TR300004600883888000386809";
        params.receiverIdentityNumber="-";
        params.senderAddress="-";
        params.senderName="GLOREDHEL PRYSTELLA";
        params.senderPassportNo="-";
        params.senderBirthPlace="-";
        params.senderBirthDate="-";
        params.explanation="test";
        params.kolasAddressType="T";
        params.kolasAddressValue="5306512288";
        params.amount=100;
        SourceAccount source = new SourceAccount();
        source.accountSuffix=352;
        source.branchCode=9142;
        source.customerNo=64473;
        source.currencyCode="TRY";
        source.iBANNo="TR690013400093772246300352";
        params.sourceAccount=source;
        params.receiverName="BTCHBYR EGELYF";
        params.customerIdentity=101096290;
        params.customerNo=64473;



        Request request = new Request(header,params);
        SendFastMoneyOrder Retrofit = services.createRetrofit().create(SendFastMoneyOrder.class);
        Call<Response> res = Retrofit.GetPostValue(request);
        res.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                System.out.println("---------------");
                System.out.println("CEVAPPPP "+response.code());

            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                System.out.println("hataaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            }
        });
    }
    /**
     * Yeni test fonksiyonlarının tanımlara aşağıya, run() içinde çağırmayı unutmayın..
     */

}
