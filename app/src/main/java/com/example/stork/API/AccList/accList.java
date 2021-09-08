package com.example.stork.API.AccList;

import com.example.stork.API.RequestWireToAccount.Request.Header;
import com.example.stork.API.AccList.GetAccList;
import com.example.stork.API.AccList.Request.Parameters;
import com.example.stork.API.AccList.Request.Request;
import com.example.stork.API.AccList.Response.Response;
import com.example.stork.Services;

import retrofit2.Call;
import retrofit2.Callback;

public class accList {
    Services services = new Services();
    GetAccList processEftRequestToIban = services.createRetrofit().create(GetAccList.class);

    public void getResponse (Parameters param, final Callback<Response> responseCallback){
        Header header = new Header("API7909c7de460b462aa1d","API","331eb5f529c74df2b800926b5f34b874","5252012362481156055");
        Call<Response> res = processEftRequestToIban.GetPostValue(new Request(header,param));
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
