package com.zilong.findjob.aishangzu.page;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.zilong.findjob.aishangzu.R;

public class Complex_page extends AppCompatActivity {

    private WebView webView_module;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.complex_page);
        webView_module = (WebView) findViewById(R.id.webView_part);
        Intent intent = getIntent();
        String content = intent.getStringExtra("content");
        String url = intent.getStringExtra("url");
        webView_module.loadDataWithBaseURL(url,content,"text/html","UTF-8",null);
        webView_module.getSettings().setJavaScriptEnabled(true);


//        4. 打开页面时， 自适应屏幕：
        WebSettings settings = webView_module.getSettings();
        settings.setUseWideViewPort(true);//设置此属性，可任意比例缩放
        settings.setLoadWithOverviewMode(true);

        //实现缩放功能
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);//隐藏Zoom缩放按钮
    }
}
