package com.zilong.findjob.aishangzu.request;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.zilong.findjob.aishangzu.model.Banner_data;

import java.io.UnsupportedEncodingException;

/**
 * Created by 子龙 on 2017/2/22.
 */

public class BannerDataRequest extends Request<Banner_data> {
    private final Response.Listener<Banner_data> mListener;

    /**
     * Creates a new request with the given method.
     *
     * @param method the request {@link Method} to use
     * @param url URL to fetch the string at
     * @param listener Listener to receive the String response
     * @param errorListener Error listener, or null to ignore errors
     */
    public BannerDataRequest(int method, String url, Response.Listener<Banner_data> listener,
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
    public BannerDataRequest(String url, Response.Listener<Banner_data> listener, Response.ErrorListener errorListener) {
        this(Method.GET, url, listener, errorListener);
    }


    @Override
    protected Response<Banner_data> parseNetworkResponse(NetworkResponse response) {
        Banner_data banner_data;
        Gson gson = new Gson();
        try {
            String jsonData = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
            banner_data = gson.fromJson(jsonData,Banner_data.class);
        } catch (UnsupportedEncodingException e) {
            String jsonData = new String(response.data);
            banner_data  = gson.fromJson(jsonData,Banner_data.class);
        }
        return Response.success(banner_data, HttpHeaderParser.parseCacheHeaders(response));
    }

    @Override
    protected void deliverResponse(Banner_data response) {
        mListener.onResponse(response);
    }
}
