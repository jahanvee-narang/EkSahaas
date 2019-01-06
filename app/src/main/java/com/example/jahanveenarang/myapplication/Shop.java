package com.example.jahanveenarang.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class Shop extends AppCompatActivity {

    WebView shop ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        shop = findViewById(R.id.shop);

        shop.loadUrl("http://www.womenonguard.com/");
        // enable / disable javascript
        shop.getSettings().setJavaScriptEnabled(true);

        shop.getSettings().setSupportZoom(true);
        shop.getSettings().setBuiltInZoomControls(true);
        shop.getSettings().setDisplayZoomControls(true);
    }
}
