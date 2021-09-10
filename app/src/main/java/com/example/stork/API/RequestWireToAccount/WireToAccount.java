package com.example.stork.API.RequestWireToAccount;


import com.example.stork.API.Header;
import com.example.stork.API.RequestWireToAccount.Request.Parameters;
import com.example.stork.API.RequestWireToAccount.Request.Request;
import com.example.stork.API.RequestWireToAccount.Response.Response;
import com.example.stork.Services;

import retrofit2.Call;
import retrofit2.Callback;

public class WireToAccount {
    Services services = new Services();
    RequestWireToAccount requestWireToAccount = services.createRetrofit().create(RequestWireToAccount.class);

    public void getResponse (Parameters param, final Callback<Response> responseCallback){
        Call<Response> res = requestWireToAccount.GetPostValue(new Request(new Header(),param));
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
