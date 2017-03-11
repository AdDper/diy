package com.zilong.findjob.aishangzu.content_fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.zilong.findjob.aishangzu.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 子龙 on 2017/3/3.
 */

public class Right_Fragment extends Fragment {
    private ListView fg_list;
    private List<String> list = new ArrayList<>();
    private ArrayAdapter<String> adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        fg_list = (ListView) view.findViewById(R.id.fg_list);
        Bundle bundle = getArguments();
        int index = bundle.getInt("index");
        switch (index){
            case 0:
                list.add("不限");
                adapter.notifyDataSetChanged();
                break;
            case 1:
                list.add("不限");
                list.add("四季青");
                adapter.notifyDataSetChanged();
                break;
            case 2:
                break;
            case 3:
                break;
        }
        adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, list);
        fg_list.setAdapter(adapter);

        return view;
    }
}
