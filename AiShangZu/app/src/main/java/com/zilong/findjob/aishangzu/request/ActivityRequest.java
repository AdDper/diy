package com.zilong.findjob.aishangzu.request;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.zilong.findjob.aishangzu.model.Shequ_Activity;

import java.io.UnsupportedEncodingException;

/**
 * Created by 子龙 on 2017/2/26.
 */

public class ActivityRequest extends Request<Shequ_Activity> {
    private final Response.Listener<Shequ_Activity> mListener;

    /**
     * Creates a new request with the given method.
     *
     * @param method the request {@link Method} to use
     * @param url URL to fetch the string at
     * @param listener Listener to receive the String response
     * @param errorListener Error listener, or null to ignore errors
     */
    public ActivityRequest(int method, String url, Response.Listener<Shequ_Activity> listener,
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
    public ActivityRequest(String url, Response.Listener<Shequ_Activity> listener, Response.ErrorListener errorListener) {
        this(Method.GET, url, listener, errorListener);
    }

    @Override
    protected void deliverResponse(Shequ_Activity response) {
        mListener.onResponse(response);
    }

    @Override
    protected Response<Shequ_Activity> parseNetworkResponse(NetworkResponse response) {
        Shequ_Activity shequ_activity;
        Gson gson = new Gson();
        try {
            String jsonData = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
            shequ_activity = gson.fromJson(jsonData,Shequ_Activity.class);
        } catch (UnsupportedEncodingException e) {
            String jsonData = new String(response.data);
            shequ_activity = gson.fromJson(jsonData,Shequ_Activity.class);
        }
        return Response.success(shequ_activity, HttpHeaderParser.parseCacheHeaders(response));
    }
}
