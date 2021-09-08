package com.example.stork.API.ProcessEftRequestToIban;


import com.example.stork.API.ProcessEftRequestToIban.Request.Header;
import com.example.stork.API.ProcessEftRequestToIban.Request.Parameters;
import com.example.stork.API.ProcessEftRequestToIban.Request.Request;
import com.example.stork.API.ProcessEftRequestToIban.Response.Response;
import com.example.stork.Services;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class eftToIban {
    Services services = new Services();
    ProcessEftRequestToIban processEftRequestToIban = services.createRetrofit().create(ProcessEftRequestToIban.class);

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
