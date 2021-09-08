package com.example.stork.API.RequestWireToName;


import com.example.stork.API.RequestWireToName.Request.Header;
import com.example.stork.API.RequestWireToName.Request.Parameters;
import com.example.stork.API.RequestWireToName.Request.Request;
import com.example.stork.API.RequestWireToName.RequestWireToName;
import com.example.stork.API.RequestWireToName.Response.Response;
import com.example.stork.Services;

import retrofit2.Call;
import retrofit2.Callback;

public class wireToName {
    Services services = new Services();
    RequestWireToName requestWireToName = services.createRetrofit().create(RequestWireToName.class);

    public void getResponse (Parameters param, final Callback<Response> responseCallback){
        Header header = new Header("c1c2a508fdf64c14a7b44edc9241c9cd","API","331eb5f529c74df2b800926b5f34b874","a9058690-a286-40b7-b610-dbf477201501");
        Call<Response> res = requestWireToName.GetPostValue(new Request(header,param));
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
