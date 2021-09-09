package com.example.stork.API.RequestWireToIban;


import com.example.stork.API.RequestWireToIban.Request.Header;
import com.example.stork.API.RequestWireToIban.Request.Parameters;
import com.example.stork.API.RequestWireToIban.Request.Request;
import com.example.stork.API.RequestWireToIban.RequestWireToIban;
import com.example.stork.API.RequestWireToIban.Response.Response;
import com.example.stork.Services;

import retrofit2.Call;
import retrofit2.Callback;

public class WireToIban {
    Services services = new Services();
    RequestWireToIban requestWireToIban = services.createRetrofit().create(RequestWireToIban.class);

    public void getResponse (Parameters param, final Callback<Response> responseCallback){
        Header header = new Header("c1c2a508fdf64c14a7b44edc9241c9cd","API","331eb5f529c74df2b800926b5f34b874","a9058690-a286-40b7-b610-dbf477201501");
        Call<Response> res = requestWireToIban.GetPostValue(new Request(header,param));
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
