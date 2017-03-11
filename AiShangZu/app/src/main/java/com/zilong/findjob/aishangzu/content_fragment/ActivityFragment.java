package com.zilong.findjob.aishangzu.content_fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.zilong.findjob.aishangzu.AiUrl;
import com.zilong.findjob.aishangzu.MyApp;
import com.zilong.findjob.aishangzu.R;
import com.zilong.findjob.aishangzu.adapter.Activity_MyRecyclerviewAdapter;
import com.zilong.findjob.aishangzu.model.Shequ_Activity;
import com.zilong.findjob.aishangzu.request.ActivityRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 子龙 on 2017/2/28.
 */
public class ActivityFragment extends Fragment{
    private ActivityRequest activityRequest;
    private List<Shequ_Activity.ObjBean.ActivityListBean> activityListBeanList = new ArrayList<>();
    private int page = 1;
    private RequestQueue requestQueue;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private LuRecyclerView luRecyclerView;

    /**服务器端一共多少条数据*/

    private static final int TOTAL_COUNTER = 10000;



    /**每一页展示多少条数据*/

    private static final int REQUEST_COUNT = 6;



    /**已经获取到多少条数据了*/

    private static int mCurrentCounter = 0;
    private LuRecyclerViewAdapter mLuRecyclerViewAdapter;
    private Activity_MyRecyclerviewAdapter recyclerviewAdapter;
    private List<Shequ_Activity.ObjBean.ActivityListBean> list_count;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_activity, container, false);
        initView(view);
        initData();

        recyclerviewAdapter =new Activity_MyRecyclerviewAdapter(getContext(),activityListBeanList);
        mLuRecyclerViewAdapter = new LuRecyclerViewAdapter(recyclerviewAdapter);
        luRecyclerView.setAdapter(mLuRecyclerViewAdapter);
        initEvent();
        return view;
    }

    private void initEvent() {
        //设置底部加载颜色

//        luRecyclerView.setFooterViewColor(R.color.colorAccent, android.R.color.black ,android.R.color.white);
        /**
         * 自动加载数据
         */
        luRecyclerView.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override

            public void onLoadMore() {

                /**
                 * 判断现在加载的数据条数是否等于服务器数据总条数
                 * 如果小于，则page加1，加载新一页的数据
                 * 如果等于，设置不再加载更多。
                 */
                if (mCurrentCounter < TOTAL_COUNTER) {
                    Log.i("sub", "onLoadMore: click");
                    Log.i("curr", "onResponse:  if "+mCurrentCounter);
                    Log.i("curr", "onResponse: count_list size "+activityListBeanList.size());
                    page++;
                    Log.i("sub", "onCreateView: page"+page);
                    Log.i("sub", "onCreateView: page"+AiUrl.rent_detai_url.substring(0, 55) + page + AiUrl.rent_detai_url.substring(56, AiUrl.rent_detai_url.length()));
                    initData();

                } else {
                    //the end
                    luRecyclerView.setNoMore(true);
                }
            }
        });
        //设置底部加载文字提示
        luRecyclerView.setFooterViewHint("拼命加载中","————  已经全部为你呈现了  ————","网络不给力啊，点击再试一次吧");



        /**
         * 下拉刷新，加载第一页数据
         */
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                activityListBeanList.removeAll(activityListBeanList);
                page=1;
                initData();
                mSwipeRefreshLayout.setRefreshing(false);
                luRecyclerView.setNoMore(false);
            }
        });
    }

    /**
     * 加载数据
     */
    private void initData() {
        activityRequest = new ActivityRequest(Request.Method.POST, AiUrl.shequ_activity_url, new Response.Listener<Shequ_Activity>() {
            @Override
            public void onResponse(Shequ_Activity response) {
                /**
                 * 因为数据加载每页显示的数据条数是固定的，所以这里判断加载的条数总数是否等于要显示的条数个数
                 * 如果小于，则说明已加载完毕。即设置不再更新。
                 */
                list_count = response.getObj().getActivityList();
                Log.i("shuju", "onResponse: "+list_count.size());
                if (REQUEST_COUNT>list_count.size()) {
                    Log.i("curr", "onResponse: count_list size 2"+list_count.size());
                    luRecyclerView.setNoMore(true);
                }
                activityListBeanList.addAll(response.getObj().getActivityList());

                luRecyclerView.refreshComplete(REQUEST_COUNT);
                mLuRecyclerViewAdapter.notifyDataSetChanged();
                /**
                 * 已加载的数据个数要随着数据的请求不断增加。
                 */
                mCurrentCounter = activityListBeanList.size();

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
                map.put("page", String.valueOf(page));
                map.put("cityName", "杭州市");
                map.put("version", "3.3");
                map.put("size", "6");
                return map;
            }
        };
        activityRequest.setTag("activity");
        requestQueue.add(activityRequest);

    }

    /**
     * 初始化控件
     * @param view
     */
    private void initView(View view) {
        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.activity_swipe_refresh_layout);
        luRecyclerView = (LuRecyclerView) view.findViewById(R.id.activity_luRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        luRecyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        requestQueue = MyApp.getRequestQueue();
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onDestroy() {
        if(requestQueue!=null){
            requestQueue.cancelAll("activity");
        }
        super.onDestroy();
    }
}
