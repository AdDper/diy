package com.zilong.findjob.aishangzu.request;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.zilong.findjob.aishangzu.model.Content1_theme1;
import com.zilong.findjob.aishangzu.model.Content1_theme2;

import java.io.UnsupportedEncodingException;

/**
 * Created by 子龙 on 2017/2/24.
 */

public class Content1theme2Request extends Request<Content1_theme2> {
    private final Response.Listener<Content1_theme2> mListener;

    /**
     * Creates a new request with the given method.
     *
     * @param method the request {@link Method} to use
     * @param url URL to fetch the string at
     * @param listener Listener to receive the String response
     * @param errorListener Error listener, or null to ignore errors
     */
    public Content1theme2Request(int method, String url, Response.Listener<Content1_theme2> listener,
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
    public Content1theme2Request(String url, Response.Listener<Content1_theme2> listener, Response.ErrorListener errorListener) {
        this(Method.GET, url, listener, errorListener);
    }


    @Override
    protected Response<Content1_theme2> parseNetworkResponse(NetworkResponse response) {
        Content1_theme2 content1_theme2;
        Gson gson = new Gson();
        try {
            String jsonData = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
            content1_theme2 = gson.fromJson(jsonData,Content1_theme2.class);
        } catch (UnsupportedEncodingException e) {
            String jsonData = new String(response.data);
            content1_theme2  = gson.fromJson(jsonData,Content1_theme2.class);
        }
        return Response.success(content1_theme2, HttpHeaderParser.parseCacheHeaders(response));
    }

    @Override
    protected void deliverResponse(Content1_theme2 response) {
        mListener.onResponse(response);
    }
}
