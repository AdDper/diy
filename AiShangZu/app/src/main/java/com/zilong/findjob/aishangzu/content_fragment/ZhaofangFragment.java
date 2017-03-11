package com.zilong.findjob.aishangzu.content_fragment;

import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;

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
import com.zilong.findjob.aishangzu.adapter.MyRecyclerviewAdapter;
import com.zilong.findjob.aishangzu.model.Recycler_DataBean;
import com.zilong.findjob.aishangzu.model.Rent_detail;
import com.zilong.findjob.aishangzu.request.Rent_detailRequest;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by 子龙 on 2017/2/21.
 */
public class ZhaofangFragment extends Fragment implements View.OnClickListener {
    private List<String> list = new ArrayList<>();
    private LinearLayout linear_default;
    private LinearLayout linear_rental;
    private LinearLayout linear_more;
    private PopupWindow popupWindow;
    private View view;
    private LinearLayout linear_area;
    private LinearLayout linear_pop;
    private int page = 1;
    private Rent_detailRequest rent_detailRequest;
    private RequestQueue requestQueue;
    private List<Rent_detail.DataBean> dataBeanList =new ArrayList<>();
    private LuRecyclerView luRecyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private List<Rent_detail.DataBean> list_count;

    /**服务器端一共多少条数据*/

    private static final int TOTAL_COUNTER = 10000;



    /**每一页展示多少条数据*/

    private static final int REQUEST_COUNT = 10;



    /**已经获取到多少条数据了*/

    private static int mCurrentCounter = 0;
    private MyRecyclerviewAdapter recyclerviewAdapter;
    private LuRecyclerViewAdapter mLuRecyclerViewAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_zhaofang, container, false);
               Log.i("sub", "onCreateView: "+AiUrl.rent_detai_url.substring(0, 56));
        Log.i("sub", "onCreateView: "+AiUrl.rent_detai_url.substring(56, AiUrl.rent_detai_url.length()));


        initView(view);
        initData();

        recyclerviewAdapter =new MyRecyclerviewAdapter(getContext(),dataBeanList);
        mLuRecyclerViewAdapter = new LuRecyclerViewAdapter(recyclerviewAdapter);

        luRecyclerView.setAdapter(mLuRecyclerViewAdapter);
        initEvent();
        return view;
    }

    private void initEvent() {
        /**
         * 筛选条件的点击弹出布局事件
         */
        linear_default.setOnClickListener(this);
        linear_rental.setOnClickListener(this);
        linear_more.setOnClickListener(this);
        linear_area.setOnClickListener(this);

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
                    Log.i("curr", "onResponse: count_list size "+dataBeanList.size());
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
//                page++;
                dataBeanList.removeAll(dataBeanList);
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
        rent_detailRequest = new Rent_detailRequest(Request.Method.GET, AiUrl.rent_detai_url.substring(0, 55) + page + AiUrl.rent_detai_url.substring(56, AiUrl.rent_detai_url.length()), new Response.Listener<Rent_detail>() {
            @Override
            public void onResponse(Rent_detail response) {
                /**
                 * 因为数据加载每页显示的数据条数是固定的，所以这里判断加载的条数总数是否等于要显示的条数个数
                 * 如果小于，则说明已加载完毕。即设置不再更新。
                 */
                list_count = response.getData();
                Log.i("shuju", "onResponse: "+list_count.size());
                if (REQUEST_COUNT>list_count.size()) {
                    Log.i("curr", "onResponse: count_list size 2"+list_count.size());
                    luRecyclerView.setNoMore(true);
                }
                dataBeanList.addAll(response.getData());

                luRecyclerView.refreshComplete(REQUEST_COUNT);
                mLuRecyclerViewAdapter.notifyDataSetChanged();
                /**
                 * 已加载的数据个数要随着数据的请求不断增加。
                 */
                mCurrentCounter = dataBeanList.size();
                Log.i("curr", "onResponse: "+mCurrentCounter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        rent_detailRequest.setTag("rent_detail");
        requestQueue.add(rent_detailRequest);


    }


    /**
     * 初始化控件
     * @param view
     */
    private void initView(View view) {
        linear_default = (LinearLayout) view.findViewById(R.id.linear_default);
        linear_area = (LinearLayout) view.findViewById(R.id.linear_area);
        linear_rental = (LinearLayout) view.findViewById(R.id.linear_rental);
        linear_more = (LinearLayout) view.findViewById(R.id.linear_more);
        linear_pop = (LinearLayout) view.findViewById(R.id.linear_pop);


        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_layout);

        luRecyclerView = (LuRecyclerView) view.findViewById(R.id.luRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        luRecyclerView.setLayoutManager(layoutManager);
    }

    @Nullable
    @Override
    public View getView() {
        return super.getView();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onClick(View v) {
        View view = null;
        switch (v.getId()){
            case  R.id.linear_area:
                view= View.inflate(getContext(), R.layout.layout_area, null);

                break;
            case R.id.linear_rental:
                view= View.inflate(getContext(), R.layout.layout_rental, null);
                break;
            case R.id.linear_default:
                view= View.inflate(getContext(), R.layout.layout_default, null);
                break;
            case R.id.linear_more:
                view= View.inflate(getContext(), R.layout.layout_more, null);
                break;
        }


        popupWindow = new PopupWindow(view,ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0xffffffff));

        //设置点击窗口以外的位置,可以关闭窗口,需要给窗口设置Background
        popupWindow.setOutsideTouchable(true);
        popupWindow.showAsDropDown(linear_pop);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        requestQueue = MyApp.getRequestQueue();
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onDestroy() {
        if(requestQueue!=null){
            requestQueue.cancelAll("rent_detail");
        }
        super.onDestroy();
    }
}
