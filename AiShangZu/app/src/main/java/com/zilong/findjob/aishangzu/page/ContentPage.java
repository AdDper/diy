package com.zilong.findjob.aishangzu.page;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.zilong.findjob.aishangzu.R;

/**
 * Created by 子龙 on 2017/2/24.
 */

public class ContentPage  extends AppCompatActivity{

    private WebView webView;
    private java.lang.String pageUrl;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_page);
        Intent intent = getIntent();
        Log.i("GGG", "onCreate: ok");
        pageUrl = intent.getStringExtra("pageUrl");
        Log.i("GGG", "onCreate: "+pageUrl);
        webView = (WebView) findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                webView.loadUrl(url);
                return true;
            }
        });
        webView.loadUrl(pageUrl);
        Log.i("url", "onCreate: page"+pageUrl);
        webView.getSettings().setJavaScriptEnabled(true);


//        4. 打开页面时， 自适应屏幕：
        WebSettings settings = webView.getSettings();
        settings.setUseWideViewPort(true);//设置此属性，可任意比例缩放
        settings.setLoadWithOverviewMode(true);

        //实现缩放功能
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);//隐藏Zoom缩放按钮
    }
}
