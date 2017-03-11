package com.zilong.findjob.aishangzu.content_fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.zilong.findjob.aishangzu.R;

/**
 * Created by 子龙 on 2017/2/21.
 */

public class WoFragment extends Fragment implements View.OnClickListener {
    private ImageView image_icon;
    private LinearLayout linear_message;
    private LinearLayout linear_collections;
    private LinearLayout linear_activity_manage;
    private LinearLayout linear_safe;
    private LinearLayout linear_renzheng;
    private LinearLayout linear_help;
    private LinearLayout linear_more_settings;

    public WoFragment() {
        super();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.wo, container, false);
        initView(view);
        initEvent();
        return view;
    }

    private void initEvent() {
        image_icon.setOnClickListener(this);
        linear_message.setOnClickListener(this);
        linear_collections.setOnClickListener(this);
        linear_activity_manage.setOnClickListener(this);
        linear_safe.setOnClickListener(this);
        linear_renzheng.setOnClickListener(this);
        linear_help.setOnClickListener(this);
        linear_more_settings.setOnClickListener(this);
    }

    private void initView(View view) {
        image_icon = (ImageView) view.findViewById(R.id.login_icon);
        linear_message = (LinearLayout) view.findViewById(R.id.linear_message);
        linear_collections = (LinearLayout) view.findViewById(R.id.linear_collections);
        linear_activity_manage = (LinearLayout) view.findViewById(R.id.linear_activity_manage);
        linear_safe = (LinearLayout) view.findViewById(R.id.linear_safe);
        linear_renzheng = (LinearLayout) view.findViewById(R.id.linear_renzheng);
        linear_help = (LinearLayout) view.findViewById(R.id.linear_help);
        linear_more_settings = (LinearLayout) view.findViewById(R.id.linear_more_settings);

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
        Intent intent = new Intent(getContext(), LoginPage.class);
        switch (v.getId()){
            case R.id.login_icon:
                break;
            case R.id.linear_message:
                break;
            case R.id.linear_collections:
                break;
            case R.id.linear_activity_manage:
                break;
            case R.id.linear_safe:
                break;
            case R.id.linear_renzheng:
                break;
            case R.id.linear_help:
                break;
            case R.id.linear_more_settings:
                break;
        }
        startActivity(intent);
    }
}
