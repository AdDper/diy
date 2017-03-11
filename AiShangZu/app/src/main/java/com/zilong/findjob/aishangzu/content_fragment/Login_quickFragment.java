package com.zilong.findjob.aishangzu.content_fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zilong.findjob.aishangzu.R;

/**
 * Created by 子龙 on 2017/3/1.
 */
public class Login_quickFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_quick, container, false);
        return view;
    }
}
