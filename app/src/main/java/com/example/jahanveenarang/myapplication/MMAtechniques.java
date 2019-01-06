package com.example.jahanveenarang.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class MMAtechniques extends AppCompatActivity {

    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mmatechniques);

        webView = findViewById(R.id.mmatech);

        webView.loadUrl("https://www.theguardian.com/sport/ng-interactive/2016/jul/09/mixed-martial-arts-fighting-techniques-guide-ufc");
        // enable / disable javascript
        webView.getSettings().setJavaScriptEnabled(true);

        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(true);
    }
}
