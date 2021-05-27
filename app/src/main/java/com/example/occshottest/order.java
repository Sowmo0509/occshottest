package com.example.occshottest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class order extends AppCompatActivity {

    private WebView orderWv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        orderWv = (WebView) findViewById(R.id.orderWv);
        orderWv.setWebViewClient(new WebViewClient());
        orderWv.loadUrl("https://occshot.weeblysite.com/book-an-event");

        WebSettings webSettings = orderWv.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }

    @Override
    public void onBackPressed() {
        if(orderWv.canGoBack()){
            orderWv.goBack();
        }else{
            super.onBackPressed();
        }
    }
}