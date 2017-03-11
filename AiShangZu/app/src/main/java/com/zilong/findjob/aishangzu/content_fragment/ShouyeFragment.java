package com.zilong.findjob.aishangzu.content_fragment;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.StringRequest;
import com.zilong.findjob.aishangzu.AiUrl;
import com.zilong.findjob.aishangzu.MyApp;
import com.zilong.findjob.aishangzu.MyImageCache;
import com.zilong.findjob.aishangzu.R;
import com.zilong.findjob.aishangzu.adapter.Banner_PagerAdapter;
import com.zilong.findjob.aishangzu.model.Apart;
import com.zilong.findjob.aishangzu.model.Banner_data;
import com.zilong.findjob.aishangzu.model.Content1_theme1;
import com.zilong.findjob.aishangzu.model.Content1_theme2;
import com.zilong.findjob.aishangzu.model.Renter;
import com.zilong.findjob.aishangzu.page.Complex_page;
import com.zilong.findjob.aishangzu.page.ContentPage;
import com.zilong.findjob.aishangzu.request.ApartRequest;
import com.zilong.findjob.aishangzu.request.BannerDataRequest;
import com.zilong.findjob.aishangzu.request.Content1theme1Request;
import com.zilong.findjob.aishangzu.request.Content1theme2Request;
import com.zilong.findjob.aishangzu.request.RenterRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by 子龙 on 2017/2/21.
 */

public class ShouyeFragment extends Fragment implements View.OnClickListener, ViewPager.OnPageChangeListener {

    private RequestQueue requestQueue;
    private StringRequest stringRequest;
    private List<String> bannerImageList = new ArrayList<>();
    private ImageLoader imageLoader;
    private ViewPager viewPager_banner;
    private Banner_PagerAdapter banner_pagerAdapter;
//    private Handler handler;
    int index = 0;

    private List<Banner_data.ObjBean> banner_data_list = new ArrayList<>();
    private List<Content1_theme1.ObjBean>  content1_theme1_list = new ArrayList<>();
    private List<Content1_theme2.ObjBean>  content1_theme2_list = new ArrayList<>();
    private List<Renter.ObjBean>  renter_list = new ArrayList<>();
    private BannerDataRequest bannerDataRequest;

    private List<Apart.ObjBean> apart_list = new ArrayList<>();
    private ApartRequest apartRequest;
    private ImageView imageView_company,imageView_tongqin,imageView_pinpai,imageView_zhengzu,imageView_hezu,content1_imageView,theme2_mainImg,zuke_img;
    private ImageLoader.ImageListener imageListener;
    private TextView text_gongsi_title,text_tongqin_title,text_pinpai_title,text_zhengzu_title,text_hezu_title,text_content1_title1,text_content1_title2,text_theme2_title,text_theme2_classifyName,text_theme2_viceTitle,text_zuke_content,text_zuke_title;
    private Content1theme1Request content1theme1Request;
    private Content1theme2Request content1theme2Request;
    private RenterRequest renterRequest;
    private RelativeLayout content1_theme1;
    private String theme1_url;
    private RelativeLayout content1_theme2;
    private Button btn_yezhu;
    private List<ImageView> list_imageView = new ArrayList<>();
    private int currentPosition = 0;
    private Timer timer;
    private LinearLayout liear_indicator;


    /**
     * 自动轮播。
     */
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if(msg.what==1){
                currentPosition++;
                viewPager_banner.setCurrentItem(currentPosition,true);
            }
        }
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        requestQueue = MyApp.getRequestQueue();
        super.onCreate(savedInstanceState);
        imageLoader = new ImageLoader(requestQueue, new MyImageCache());
    }

    @Nullable
    @Override
    public View getView() {

        return super.getView();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_main,container,false);
        initView(view);
        initData();



        initEvent();

        return view;

    }

    /**
     * 所有控件的点击事件
     */
    private void initEvent() {
        content1_theme1.setOnClickListener(this);
        content1_theme2.setOnClickListener(this);
        btn_yezhu.setOnClickListener(this);
    }

    /**
     * 实例化所有控件
     * @param view
     */
    private void initView(View view) {
        imageView_company = (ImageView) view.findViewById(R.id.image_company);
        imageView_tongqin = (ImageView) view.findViewById(R.id.tongqin);
        imageView_pinpai = (ImageView) view.findViewById(R.id.pinpai);
        imageView_zhengzu = (ImageView) view.findViewById(R.id.zhengzu);
        imageView_hezu = (ImageView) view.findViewById(R.id.hezu);
        text_gongsi_title = (TextView) view.findViewById(R.id.gongsi_title);
        text_tongqin_title = (TextView) view.findViewById(R.id.tongqin_title);
        text_pinpai_title = (TextView) view.findViewById(R.id.text_pinpai_title);
        text_zhengzu_title = (TextView) view.findViewById(R.id.text_zhengzu_title);
        text_hezu_title = (TextView) view.findViewById(R.id.text_hezu_title);


        content1_imageView = (ImageView) view.findViewById(R.id.content1_imageView);
        text_content1_title1 = (TextView) view.findViewById(R.id.content1_title1);
        text_content1_title2 = (TextView) view.findViewById(R.id.contetn1_title2);


        theme2_mainImg = (ImageView) view.findViewById(R.id.theme2_mainImg);
        text_theme2_title = (TextView) view.findViewById(R.id.theme2_title);
        text_theme2_classifyName = (TextView) view.findViewById(R.id.theme2_classifyName);
        text_theme2_viceTitle = (TextView) view.findViewById(R.id.theme2_viceTitle);

        zuke_img = (ImageView) view.findViewById(R.id.zuke_img);
        text_zuke_content = (TextView) view.findViewById(R.id.zuke_content);
        text_zuke_title = (TextView) view.findViewById(R.id.zuke_title);

        content1_theme1 = (RelativeLayout) view.findViewById(R.id.content1_theme1);
        content1_theme2 = (RelativeLayout) view.findViewById(R.id.content1_theme2);

        btn_yezhu = (Button) view.findViewById(R.id.yezhu);

        viewPager_banner = (ViewPager) view.findViewById(R.id.viewPager_banner);

        liear_indicator = (LinearLayout) view.findViewById(R.id.liear_indicator);

    }

    /**
     * 首页的所有数据请求。这里我用的是volley框架。
     */
    private void initData() {


        /**
         * 轮播图数据请求
         */
        bannerDataRequest = new BannerDataRequest(Request.Method.POST, AiUrl.banner_url, new Response.Listener<Banner_data>() {
            @Override
            public void onResponse(Banner_data response) {
                Log.i("TAG", "onResponse: ------------------------oone"+response);
                banner_data_list.removeAll(banner_data_list);
                banner_data_list.addAll(response.getObj());
                setData();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap map = new HashMap();
                map.put("clientNum", "864895028548061");
                map.put("recommendPosition", "003");
                map.put("cityName", "杭州");
                map.put("version", "3.3");
                return map;
            }
        };
        bannerDataRequest.setTag("MainActivity");

        /**
         * 公司找房、通勤找房数据请求
         * 1、先解析数据，创建model对象
         * 2、创建对应的request对象
         *
         * 这里我需要的是图片资源，所以我需要进行缓存。
         *
         */

        Log.i("TAG", "initData:  its ok");
        apartRequest = new ApartRequest(Request.Method.POST, AiUrl.apart_url, new Response.Listener<Apart>() {
            @Override
            public void onResponse(Apart response) {
                Log.i("TAG", "onResponse: ------------------------"+response);
                apart_list.removeAll(apart_list);
                apart_list.addAll(response.getObj());
                initRentData();
                Log.i("YYY", "initData: "+apart_list.get(4).getImg());
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        })

        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap map = new HashMap();
                map.put("clientNum", "864895028548061");
                map.put("layoutPosition", "009");
                map.put("version", "3.3");
                return map;
            }
        };
        apartRequest.setTag("apart");

        /**
         * 第一个主题模块的请求
         */
        content1theme1Request = new Content1theme1Request(Request.Method.POST, AiUrl.theme1_url, new Response.Listener<Content1_theme1>() {
            @Override
            public void onResponse(Content1_theme1 response) {
                content1_theme1_list.add(response.getObj());
                initTheme1();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap map = new HashMap();
                map.put("clientNum", "864895028548061");
                map.put("projectType ", "3");
                map.put("version", "3.3");
                return map;
            }
        };
        content1theme1Request.setTag("theme1");

        /**
         * 第二个主题模块的请求
         */
        content1theme2Request = new Content1theme2Request(Request.Method.POST, AiUrl.theme2_url, new Response.Listener<Content1_theme2>() {
            @Override
            public void onResponse(Content1_theme2 response) {
                content1_theme2_list.removeAll(content1_theme2_list);
                content1_theme2_list.add(response.getObj());
                initTheme2();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap map = new HashMap();
                map.put("clientNum", "864895028548061");
                map.put("id", "360");
                map.put("version", "3.3");
                return map;
            }
        };
        content1theme2Request.setTag("theme2");

        /**
         * 最后一个模块，租客模块的数据请求
         */
        renterRequest = new RenterRequest(Request.Method.POST, AiUrl.renter_url, new Response.Listener<Renter>() {
            @Override
            public void onResponse(Renter response) {
                renter_list.removeAll(renter_list);
                renter_list.add(response.getObj());
                initRenter();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap map = new HashMap();
                map.put("clientNum", "864895028548061");
                map.put("projectType", "1");
                map.put("version","3.3");
                return map;
            }
        };
        renterRequest.setTag("renter");


        requestQueue.add(apartRequest);
        requestQueue.add(bannerDataRequest);
        requestQueue.add(content1theme1Request);
        requestQueue.add(content1theme2Request);
        requestQueue.add(renterRequest);

    }

    private void setData() {
        for (int i = 0; i < banner_data_list.size()+2; i++) {
            ImageView imageView = new ImageView(getContext());
            list_imageView.add(imageView);
        }
            liear_indicator.setPadding(10,0,10,0);
        for (int i = 0; i < banner_data_list.size(); i++) {
            ImageView imageView = new ImageView(getContext());
            imageView.setImageResource(R.drawable.selector_home);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(13, 13);
            layoutParams.leftMargin = 10;
            layoutParams.rightMargin = 10;
            imageView.setLayoutParams(layoutParams);
            liear_indicator.addView(imageView);
            imageView.setEnabled(false);
        }

        banner_pagerAdapter = new Banner_PagerAdapter(banner_data_list,list_imageView,getContext());
        viewPager_banner.setAdapter(banner_pagerAdapter);

        viewPager_banner.setOnPageChangeListener(this);
        startTimer();
    }

    private void startTimer() {
        timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                Log.i("TAG", "定时器任务线程："+Thread.currentThread().getName());
                Message msg = Message.obtain();
                msg.what = 1;
                handler.sendEmptyMessage(msg.what);
            }
        }, 0, 3000);
    }

    /**
     * 主题3——租客
     */
    private void initRenter() {
        Picasso.with(getContext()).load(renter_list.get(0).getImg()).into(zuke_img);
        text_zuke_content.setText(renter_list.get(0).getContent());
        text_zuke_title.setText(renter_list.get(0).getTitle());
    }

    /**
     * 主题2-生活研究报告
     */
    private void initTheme2() {
        if(requestQueue==null){
            Log.i("SSS","its null");
        }
        Picasso.with(getContext()).load(content1_theme2_list.get(0).getArticle().getMainImg()).into(theme2_mainImg);
        text_theme2_title.setText(content1_theme2_list.get(0).getArticle().getTitle());
        text_theme2_classifyName.setText(content1_theme2_list.get(0).getArticle().getClassifyName());
        text_theme2_viceTitle.setText(content1_theme2_list.get(0).getArticle().getViceTitle());
    }

    /**
     * 主题1-爱上租房生活模块
     */
    private void initTheme1() {

        Picasso.with(getContext()).load(content1_theme1_list.get(0).getImg()).into(content1_imageView);
        final String theme1_url = content1_theme1_list.get(0).getUrl();
        Log.i("GGG", "onClick:====== "+theme1_url);

    }

    /**
     * 公寓模块代码重复，可以写一个类，然后将控件和position作为参数传入。
     */
    private void initRentData() {

        /**
         * 公司找房模块
         */
        Picasso.with(getContext()).load(apart_list.get(4).getImg()).into(imageView_company);
        Log.i("YYY", "initData: "+apart_list.get(4).getImg());
        text_gongsi_title.setText(apart_list.get(4).getTitle());


        /**
         * 通勤找房模块
         */
        Picasso.with(getContext()).load(apart_list.get(3).getImg()).into(imageView_tongqin);
        text_tongqin_title.setText(apart_list.get(3).getTitle());

        /**
         * 品牌公寓模块
         */
        Picasso.with(getContext()).load(apart_list.get(2).getImg()).into(imageView_pinpai);
        text_pinpai_title.setText(apart_list.get(2).getTitle());

        /**
         * 整租公寓模块
         */
        Picasso.with(getContext()).load(apart_list.get(1).getImg()).into(imageView_zhengzu);
        Log.i("YYY", "initData: "+apart_list.get(1).getImg());
        text_zhengzu_title.setText(apart_list.get(1).getTitle());

        /**
         * 合租公寓
         */
        Picasso.with(getContext()).load(apart_list.get(0).getImg()).into(imageView_hezu);
        Log.i("YYY", "initData: "+apart_list.get(0).getImg());
        text_hezu_title.setText(apart_list.get(0).getTitle());

    }

    @Override
    public void onDestroy() {
        if(requestQueue!=null){
            requestQueue.cancelAll("MainActivity");
            requestQueue.cancelAll("apart");
            requestQueue.cancelAll("theme1");
            requestQueue.cancelAll("theme2");
        }
        if(timer!=null){
            timer.cancel();
            timer = null;
        }
        super.onDestroy();
    }



    /**
     * 所有控件的点击事件
     * @param v
     */
    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()){
            case R.id.content1_theme1:
                intent.putExtra("url",content1_theme1_list.get(0).getUrl());
                intent.putExtra("content",content1_theme1_list.get(0).getContent());
                intent.setClass(getContext(), Complex_page.class);
                break;
            case R.id.content1_theme2:
                intent.putExtra("url", content1_theme2_list.get(0).getArticle().getUrl().toString());
                intent.putExtra("content",content1_theme2_list.get(0).getArticle().getContent().toString());
                intent.setClass(getContext(), Complex_page.class);
                break;
            case R.id.yezhu:
                intent.putExtra("pageUrl",AiUrl.entrust_url);
                intent.setClass(getContext(),ContentPage.class);
                break;
        }

        startActivity(intent);
    }


    /**
     * viewpager滚动监听
     * @param position
     * @param positionOffset
     * @param positionOffsetPixels
     */
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        for (int i = 0; i < liear_indicator.getChildCount(); i++) {
            liear_indicator.getChildAt(i).setEnabled(false);
        }
        if (position == list_imageView.size() - 1) {
            position = 1;
        }
        if (position == list_imageView.size() - 2) {
            position = 0;
        }
        liear_indicator.getChildAt(position).setEnabled(true);
    }

    @Override
    public void onPageSelected(int position) {
        currentPosition=position;
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        switch (state){
            case ViewPager.SCROLL_STATE_DRAGGING:
                if(timer!=null){
                    timer.cancel();
                    timer=null;
                }
                break;
            case ViewPager.SCROLL_STATE_IDLE:
                if(currentPosition==0){
                    viewPager_banner.setCurrentItem(list_imageView.size()-2,false);
                }else if(currentPosition == list_imageView.size()-1){
                    viewPager_banner.setCurrentItem(1,false);
                }
                if(timer==null){
                    currentPosition--;
                    startTimer();
                }
                break;
            default:
                break;

        }
    }

}
