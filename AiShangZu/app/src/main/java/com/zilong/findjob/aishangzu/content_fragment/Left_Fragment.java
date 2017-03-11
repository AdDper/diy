package com.zilong.findjob.aishangzu.content_fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.zilong.findjob.aishangzu.R;


/**
 * Created by 子龙 on 2017/3/3.
 */

public class Left_Fragment extends Fragment {
    private ListView fg_list;
    private String[] arr_qu = {"不限","上城区","下城区","江干区","拱墅区","西湖区","滨江区","萧山区","余杭区"};
    private ArrayAdapter<String> arrayAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        fg_list = (ListView) view.findViewById(R.id.fg_list);
        arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, arr_qu);
        fg_list.setAdapter(arrayAdapter);
        fg_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                bundle.putInt("index",position);
                setArguments(bundle);
            }
        });

        return view;
    }
}
