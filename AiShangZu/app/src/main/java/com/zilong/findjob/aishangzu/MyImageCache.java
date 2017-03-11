package com.zilong.findjob.aishangzu;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

import com.android.volley.toolbox.ImageLoader;

/**
 * Created by 子龙 on 2017/2/22.
 */

//缓存图片
public class MyImageCache implements ImageLoader.ImageCache {

    private final LruCache<String, Bitmap> lruCache;

    public MyImageCache() {
        int cacheSize = (int)Runtime.getRuntime().maxMemory()/8/1024;
        lruCache = new LruCache<String,Bitmap>(cacheSize) {
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getByteCount()/1024;
            }
        };
    }

    @Override
    public Bitmap getBitmap(String url) {
        return lruCache.get(url);
    }

    @Override
    public void putBitmap(String url, Bitmap bitmap) {
        lruCache.put(url,bitmap);
    }
}
