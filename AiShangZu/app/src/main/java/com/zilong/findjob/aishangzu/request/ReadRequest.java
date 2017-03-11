package com.zilong.findjob.aishangzu.request;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.zilong.findjob.aishangzu.model.Shequ_Read;

import java.io.UnsupportedEncodingException;

/**
 * Created by 子龙 on 2017/2/26.
 */

public class ReadRequest extends Request<Shequ_Read>{
    private final Response.Listener<Shequ_Read> mListener;

    /**
     * Creates a new request with the given method.
     *
     * @param method the request {@link Method} to use
     * @param url URL to fetch the string at
     * @param listener Listener to receive the String response
     * @param errorListener Error listener, or null to ignore errors
     */
    public ReadRequest(int method, String url, Response.Listener<Shequ_Read> listener,
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
    public ReadRequest(String url, Response.Listener<Shequ_Read> listener, Response.ErrorListener errorListener) {
        this(Method.GET, url, listener, errorListener);
    }

    @Override
    protected void deliverResponse(Shequ_Read response) {
        mListener.onResponse(response);
    }

    @Override
    protected Response<Shequ_Read> parseNetworkResponse(NetworkResponse response) {
        Shequ_Read shequ_read;
        Gson gson = new Gson();
        try {
            String jsonData = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
            shequ_read = gson.fromJson(jsonData,Shequ_Read.class);
        } catch (UnsupportedEncodingException e) {
            String jsonData = new String(response.data);
            shequ_read = gson.fromJson(jsonData,Shequ_Read.class);
        }
        return Response.success(shequ_read, HttpHeaderParser.parseCacheHeaders(response));
    }
}
