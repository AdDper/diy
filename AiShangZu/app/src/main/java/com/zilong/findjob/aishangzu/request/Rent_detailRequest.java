package com.zilong.findjob.aishangzu.request;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.zilong.findjob.aishangzu.model.Rent_detail;
import com.zilong.findjob.aishangzu.model.Renter;

import java.io.UnsupportedEncodingException;

/**
 * Created by 子龙 on 2017/2/24.
 */

public class Rent_detailRequest extends Request<Rent_detail> {
    private final Response.Listener<Rent_detail> mListener;

    /**
     * Creates a new request with the given method.
     *
     * @param method the request {@link Method} to use
     * @param url URL to fetch the string at
     * @param listener Listener to receive the String response
     * @param errorListener Error listener, or null to ignore errors
     */
    public Rent_detailRequest(int method, String url, Response.Listener<Rent_detail> listener,
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
    public Rent_detailRequest(String url, Response.Listener<Rent_detail> listener, Response.ErrorListener errorListener) {
        this(Method.GET, url, listener, errorListener);
    }


    @Override
    protected Response<Rent_detail> parseNetworkResponse(NetworkResponse response) {
        Rent_detail rent_detail;
        Gson gson = new Gson();
        try {
            String jsonData = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
            rent_detail = gson.fromJson(jsonData,Rent_detail.class);
        } catch (UnsupportedEncodingException e) {
            String jsonData = new String(response.data);
            rent_detail  = gson.fromJson(jsonData,Rent_detail.class);
        }
        return Response.success(rent_detail, HttpHeaderParser.parseCacheHeaders(response));
    }

    @Override
    protected void deliverResponse(Rent_detail response) {
        mListener.onResponse(response);
    }
}
