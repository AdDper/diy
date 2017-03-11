package com.zilong.findjob.aishangzu.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.zilong.findjob.aishangzu.MyApp;
import com.zilong.findjob.aishangzu.MyImageCache;
import com.zilong.findjob.aishangzu.R;
import com.zilong.findjob.aishangzu.content_fragment.ShouyeFragment;
import com.zilong.findjob.aishangzu.model.Banner_data;
import com.zilong.findjob.aishangzu.page.ContentPage;

import java.util.ArrayList;
import java.util.List;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by 子龙 on 2017/2/22.
 */

public class Banner_PagerAdapter extends PagerAdapter {
    private List<Banner_data.ObjBean> imageList  = new ArrayList<>();
    private Context context;
    private String TAG = "AAA";
    private List<ImageView> list_imageView = new ArrayList<>();


    public Banner_PagerAdapter(List<Banner_data.ObjBean> imageList, List<ImageView> list_imageView, Context context) {
        this.imageList = imageList;
        this.list_imageView = list_imageView;
        this.context = context;
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Log.i(TAG, "instantiateItem: here is ok"+position);
        Log.i("POI", "instantiateItem: "+position);
        Log.i("POI", " "+imageList.size());
        ImageView imageView = list_imageView.get(position);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        //加载轮播图图片
        if (position == list_imageView.size() - 1) {
            position = 1;
        }
        if (position == list_imageView.size() - 2) {
            position = 0;
        }
        Picasso.with(context).load(imageList.get(position).getImg()).into(imageView);
        container.addView(imageView);
        final int finalCurrentposition = position;
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ContentPage.class);
                intent.putExtra("pageUrl",imageList.get(finalCurrentposition).getUrl());
                Log.i(TAG, "onClick: url is "+imageList.get(finalCurrentposition).getUrl());
                context.startActivity(intent);
            }
        });
        return imageView;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(list_imageView.get(position));
    }


    @Override
    public int getCount() {
        Log.i(TAG, "getCount: itemcount:"+list_imageView.size());
        return list_imageView.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }


}
