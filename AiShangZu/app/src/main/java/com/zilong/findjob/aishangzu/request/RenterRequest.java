package com.zilong.findjob.aishangzu.request;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.zilong.findjob.aishangzu.model.Content1_theme2;
import com.zilong.findjob.aishangzu.model.Renter;

import java.io.UnsupportedEncodingException;

/**
 * Created by 子龙 on 2017/2/24.
 */

public class RenterRequest extends Request<Renter> {
    private final Response.Listener<Renter> mListener;

    /**
     * Creates a new request with the given method.
     *
     * @param method the request {@link Method} to use
     * @param url URL to fetch the string at
     * @param listener Listener to receive the String response
     * @param errorListener Error listener, or null to ignore errors
     */
    public RenterRequest(int method, String url, Response.Listener<Renter> listener,
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
    public RenterRequest(String url, Response.Listener<Renter> listener, Response.ErrorListener errorListener) {
        this(Method.GET, url, listener, errorListener);
    }


    @Override
    protected Response<Renter> parseNetworkResponse(NetworkResponse response) {
        Renter renter;
        Gson gson = new Gson();
        try {
            String jsonData = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
            renter = gson.fromJson(jsonData,Renter.class);
        } catch (UnsupportedEncodingException e) {
            String jsonData = new String(response.data);
            renter  = gson.fromJson(jsonData,Renter.class);
        }
        return Response.success(renter, HttpHeaderParser.parseCacheHeaders(response));
    }

    @Override
    protected void deliverResponse(Renter response) {
        mListener.onResponse(response);
    }
}
