package com.example.stork.API.GetAccountTransactionList;



import com.example.stork.API.GetAccountTransactionList.Request.Parameters;
import com.example.stork.API.GetAccountTransactionList.Request.Request;
import com.example.stork.API.GetAccountTransactionList.Response.Response;
import com.example.stork.API.Header;
import com.example.stork.Services;

import retrofit2.Call;
import retrofit2.Callback;

public class TransactionList {
    Services services = new Services();
    GetAccountTransactionList getAccountTransactionList = services.createRetrofit().create(GetAccountTransactionList.class);

    public void getResponse (Parameters param, final Callback<Response> responseCallback){
        Call<Response> res = getAccountTransactionList.GetPostValue(new Request(new Header(),param));
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
