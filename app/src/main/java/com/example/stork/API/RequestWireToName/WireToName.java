package com.example.stork.API.RequestWireToName;


import com.example.stork.API.Header;
import com.example.stork.API.RequestWireToName.Request.Parameters;
import com.example.stork.API.RequestWireToName.Request.Request;
import com.example.stork.API.RequestWireToName.Response.Response;
import com.example.stork.Services;

import retrofit2.Call;
import retrofit2.Callback;

public class WireToName {
    Services services = new Services();
    RequestWireToName requestWireToName = services.createRetrofit().create(RequestWireToName.class);

    public void getResponse (Parameters param, final Callback<Response> responseCallback){
        Call<Response> res = requestWireToName.GetPostValue(new Request(new Header(),param));
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
