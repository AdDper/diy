package com.zilong.findjob.aishangzu.request;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.zilong.findjob.aishangzu.model.Apart;
import com.zilong.findjob.aishangzu.model.Banner_data;

import java.io.UnsupportedEncodingException;

/**
 * Created by 子龙 on 2017/2/22.
 */

public class ApartRequest extends Request<Apart> {
    private final Response.Listener<Apart> mListener;

    /**
     * Creates a new request with the given method.
     *
     * @param method the request {@link Method} to use
     * @param url URL to fetch the string at
     * @param listener Listener to receive the String response
     * @param errorListener Error listener, or null to ignore errors
     */
    public ApartRequest(int method, String url, Response.Listener<Apart> listener,
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
    public ApartRequest(String url, Response.Listener<Apart> listener, Response.ErrorListener errorListener) {
        this(Method.GET, url, listener, errorListener);
    }


    @Override
    protected Response<Apart> parseNetworkResponse(NetworkResponse response) {
        Apart apart;
        Gson gson = new Gson();
        try {
            String jsonData = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
            apart = gson.fromJson(jsonData,Apart.class);
        } catch (UnsupportedEncodingException e) {
            String jsonData = new String(response.data);
            apart  = gson.fromJson(jsonData,Apart.class);
        }
        return Response.success(apart, HttpHeaderParser.parseCacheHeaders(response));
    }

    @Override
    protected void deliverResponse(Apart response) {
        mListener.onResponse(response);
    }
}
