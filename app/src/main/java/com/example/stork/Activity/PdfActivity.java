package com.example.stork.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Base64;
import android.widget.TextView;

import com.example.stork.API.GetReceiptData.Request.Parameters;
import com.example.stork.API.GetReceiptData.Response.Response;
import com.example.stork.API.GetReceiptData.ReceiptData;
import com.example.stork.R;
import com.github.barteksc.pdfviewer.PDFView;

import retrofit2.Call;
import retrofit2.Callback;

public class PdfActivity extends AppCompatActivity {
    private PDFView pdfView;
    ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);

        /* Parameters param = new Parameters(9142,"2021-01-28",3411,123,true);
        param.branchCode = 9142;
        param.isPdf = true;
        param.customerNo = 123;
        param.referenceNo = 3411;
        param.transactionDate = "2021-01-28";
        */


        ReceiptData rData = new ReceiptData();
        Parameters param = (Parameters) getIntent().getExtras().getSerializable("pdf_key");
        System.out.println(param);
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