package com.example.stork.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Base64;

import com.example.stork.API.GetReceiptData.GetReceiptData;
import com.example.stork.API.GetReceiptData.Request.Parameters;
import com.example.stork.API.GetReceiptData.Request.Request;
import com.example.stork.API.GetReceiptData.Response.Response;
import com.example.stork.API.GetReceiptData.receiptData;
import com.example.stork.R;
import com.example.stork.Services;
import com.github.barteksc.pdfviewer.PDFView;

import retrofit2.Call;
import retrofit2.Callback;

public class PdfActivity extends AppCompatActivity {
    private PDFView pdfView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);
        Services services = new Services();

        Parameters param = new Parameters();
        param.branchCode = 9142;
        param.isPdf = true;
        param.customerNo = 123;
        param.referenceNo = 3411;
        param.transactionDate = "2021-01-28";

        receiptData rData = new receiptData();
        rData.getResponse(param, new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                String code = response.body().data.getContent().get$value();
                pdfView = findViewById(R.id.pdfView);
                byte[] decodedString = Base64.decode(code, Base64.DEFAULT);
                pdfView.fromBytes(decodedString).load();
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {

            }
        });
    }
}