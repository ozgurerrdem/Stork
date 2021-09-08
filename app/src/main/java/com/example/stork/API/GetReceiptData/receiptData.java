package com.example.stork.API.GetReceiptData;


import com.example.stork.API.GetReceiptData.GetReceiptData;
import com.example.stork.API.GetReceiptData.Request.Header;
import com.example.stork.API.GetReceiptData.Request.Parameters;
import com.example.stork.API.GetReceiptData.Request.Request;
import com.example.stork.API.GetReceiptData.Response.Response;
import com.example.stork.Services;

import retrofit2.Call;
import retrofit2.Callback;

public class receiptData {
    Services services = new Services();
    GetReceiptData getReceiptData = services.createRetrofit().create(GetReceiptData.class);

    public void getResponse (Parameters param, final Callback<Response> responseCallback){
        Header header = new Header("API7909c7de460b462aa1d","API","331eb5f529c74df2b800926b5f34b874","5252012362481156055");
        Call<Response> res = getReceiptData.GetPostValue(new Request(header,param));
        res.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                responseCallback.onResponse(call,response);
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {

            }
        });
    }
}
