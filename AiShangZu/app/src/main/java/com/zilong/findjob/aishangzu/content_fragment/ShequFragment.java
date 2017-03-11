package com.zilong.findjob.aishangzu.content_fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.zilong.findjob.aishangzu.R;
import com.zilong.findjob.aishangzu.adapter.MyFragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 子龙 on 2017/2/21.
 */

public class ShequFragment extends Fragment {
    private Toolbar toolbar;
    private ViewPager viewPager;
    private List<Fragment> fragmentList = new ArrayList<>();
    private TextView title_activity;
    private TextView title_read;
    private LinearLayout linear_title;
    private ImageView bg_shequ_toolbar;
    private int lastPosition = 0;
    private int linear_titleWidth;
    private int start_width;
    private RelativeLayout relative_getWidth;
    private boolean b = false;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_shequ, container, false);
        initView(view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        toolbar.setTitle("");

        ActivityFragment activityFragment = new ActivityFragment();
        ReadFragment readFragment = new ReadFragment();
        fragmentList.add(activityFragment);
        fragmentList.add(readFragment);

        viewPager.setAdapter(new MyFragmentPagerAdapter(getFragmentManager(),getContext(),fragmentList));


        start_width = relative_getWidth.getLeft();

        linear_title.post(new Runnable() {
            @Override
            public void run() {
                linear_titleWidth = linear_title.getWidth();
            }
        });


        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {


            public TranslateAnimation translateAnimationing;
            public boolean c = false;
            public boolean a = false;
            public int refreshPisition;

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.i("position", "onPageScrolled: "+positionOffset);
                Log.i("position", "position---------: "+position);
            }

            @Override
            public void onPageSelected(int position) {
                Log.i("position", "onPageScrolled:position "+position);
                switch (position){
                    case 0:
                        a = true;
                        c = false;
                        title_read.setTextColor(Color.BLACK);
                        title_activity.setTextColor(Color.WHITE);
                        TranslateAnimation ac_translateAnimation = new TranslateAnimation(0,0, 0, 0);
                        Log.i("width", "onPageSelected: "+linear_titleWidth/2);
                        ac_translateAnimation.setDuration(0);
                        ac_translateAnimation.setFillAfter(true);// 移动完后停留到终点
                        bg_shequ_toolbar.startAnimation(ac_translateAnimation);

                        break;
                    case 1:
                        c = true;
                        a = false;
                        title_read.setTextColor(Color.WHITE);
                        title_activity.setTextColor(Color.BLACK);
                        TranslateAnimation translateAnimation = new TranslateAnimation(0, linear_titleWidth/2, 0, 0);
                        Log.i("width", "onPageSelected: "+linear_titleWidth/2);
                        translateAnimation.setDuration(0);
                        translateAnimation.setFillAfter(true);// 移动完后停留到终点
                        bg_shequ_toolbar.startAnimation(translateAnimation);
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if(state == 2){
                    b = true;
                }else {
                    b = false;
                }
                if(state==1){
                    refreshPisition = 0;
                }
            }
        });


        for (int i = 0; i < linear_title.getChildCount();) {
            TextView tv_title;
            tv_title = (TextView) linear_title.getChildAt(i);
            tv_title.setTag(i);
            linear_title.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    viewPager.setCurrentItem((Integer) v.getTag());
                }
            });
            i++;
        }
    }

    @Nullable
    @Override
    public View getView() {
        return super.getView();
    }

    private void initView(View view) {
        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        title_activity = (TextView) view.findViewById(R.id.title_activity);
        title_read = (TextView) view.findViewById(R.id.title_read);
        linear_title = (LinearLayout) view.findViewById(R.id.linear_title);
        bg_shequ_toolbar = (ImageView) view.findViewById(R.id.bg_shequ_toolbar);
        relative_getWidth = (RelativeLayout) view.findViewById(R.id.relative_getWidth);
    }






}
