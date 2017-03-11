package com.zilong.findjob.aishangzu.request;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.zilong.findjob.aishangzu.model.Banner_data;
import com.zilong.findjob.aishangzu.model.Content1_theme1;

import java.io.UnsupportedEncodingException;

/**
 * Created by 子龙 on 2017/2/24.
 */

public class Content1theme1Request extends Request<Content1_theme1> {
    private final Response.Listener<Content1_theme1> mListener;

    /**
     * Creates a new request with the given method.
     *
     * @param method the request {@link Method} to use
     * @param url URL to fetch the string at
     * @param listener Listener to receive the String response
     * @param errorListener Error listener, or null to ignore errors
     */
    public Content1theme1Request(int method, String url, Response.Listener<Content1_theme1> listener,
                             Response.ErrorListener errorListener) {
        super(method, url, errorListener);
        mListener = listener;
    }

    /**
     * Creates a new GET request.
     *
     * @param url URL to fetch the string at
     * @param listener Listener to receive the String response
     * @param errorListener Error listener, or null to ignore errors
     */
    public Content1theme1Request(String url, Response.Listener<Content1_theme1> listener, Response.ErrorListener errorListener) {
        this(Method.GET, url, listener, errorListener);
    }


    @Override
    protected Response<Content1_theme1> parseNetworkResponse(NetworkResponse response) {
        Content1_theme1 content1_theme1;
        Gson gson = new Gson();
        try {
            String jsonData = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
            content1_theme1 = gson.fromJson(jsonData,Content1_theme1.class);
        } catch (UnsupportedEncodingException e) {
            String jsonData = new String(response.data);
            content1_theme1  = gson.fromJson(jsonData,Content1_theme1.class);
        }
        return Response.success(content1_theme1, HttpHeaderParser.parseCacheHeaders(response));
    }

    @Override
    protected void deliverResponse(Content1_theme1 response) {
        mListener.onResponse(response);
    }
}
