package com.zilong.findjob.aishangzu;

import android.app.Application;
import android.view.View;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by 子龙 on 2017/2/22.
 */

public class MyApp extends Application {

    private static RequestQueue requestQueue;

    @Override
    public void onCreate() {
        super.onCreate();
        requestQueue = Volley.newRequestQueue(this);
    }

    public static RequestQueue getRequestQueue(){
        return requestQueue;
    }
}
