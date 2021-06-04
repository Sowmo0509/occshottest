package com.example.occshottest;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class package_pricing extends AppCompatActivity {

    // WebView List
    private WebView pkgWv;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_pricing);

        if(!isConnected(this)){
            showCustomDialogue();
        }

        pkgWv = (WebView) findViewById(R.id.pkgWv);
        pkgWv.setWebViewClient(new WebViewClient());
        pkgWv.loadUrl("https://occshot.weeblysite.com/#FEWvRM");
        WebSettings webSettings = pkgWv.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }

    @Override
    public void onBackPressed() {
        if(pkgWv.canGoBack()){
            pkgWv.goBack();
        }else{
            super.onBackPressed();
        }
    }

    private void showCustomDialogue() {
        /*AlertDialog.Builder builder = new AlertDialog.Builder(packages.this);
        builder.setMessage("Please connect to the internet.").setCancelable(false).setPositiveButton("Connect", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
            }
        })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        finish();
                    }
                });*/
        Toast.makeText(this, "NO INTERNET", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, noInternet.class));
    }

    private boolean isConnected(package_pricing package_pricing) {
        ConnectivityManager connectivityManager = (ConnectivityManager) package_pricing.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo wifiConnection = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobileConnection = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

        if((wifiConnection != null && wifiConnection.isConnected()) || (mobileConnection != null && mobileConnection.isConnected())){
            return true;
        }else{
            return false;
        }

    }
}