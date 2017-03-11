package com.zilong.findjob.aishangzu;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.zilong.findjob.aishangzu.content_fragment.Layout_main_image;
import com.zilong.findjob.aishangzu.content_fragment.ShequFragment;
import com.zilong.findjob.aishangzu.content_fragment.ShouyeFragment;
import com.zilong.findjob.aishangzu.content_fragment.WoFragment;
import com.zilong.findjob.aishangzu.content_fragment.ZhaofangFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup_part;
    private ViewPager viewPager_content;
    private List<Fragment> fragmentList = new ArrayList<>();
    private RadioButton radio_shouye;
    private ShouyeFragment fragment1;
    private ZhaofangFragment fragment2;
    private ShequFragment fragment3;
    private WoFragment fragment4;
    private ImageView image_center_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup_part = (RadioGroup) findViewById(R.id.radioGroup_part);
        radio_shouye = (RadioButton) findViewById(R.id.radio_shouye);
        radioGroup_part.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                selectFragment(checkedId);
            }
        });
        selectFragment(R.id.radio_shouye);
        radio_shouye.setChecked(true);

        image_center_main = (ImageView) findViewById(R.id.image_center_main);
        image_center_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Layout_main_image.class);
                startActivity(intent);
            }
        });


    }

    private void selectFragment(int checkedId) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        hideFragment(fragmentTransaction);
        switch (checkedId){
            case R.id.radio_shouye:
                if(fragment1==null){
                    fragment1 = new ShouyeFragment();
                    fragmentTransaction.add(R.id.fg_content,fragment1);
                }else {
                    fragmentTransaction.show(fragment1);
                }
                break;
            case R.id.radio_zhaofang:
                if(fragment2==null){
                    fragment2 = new ZhaofangFragment();
                    fragmentTransaction.add(R.id.fg_content,fragment2);
                }else {
                    fragmentTransaction.show(fragment2);
                }
                break;
            case R.id.radio_shequ:
                if(fragment3==null){
                    fragment3 = new ShequFragment();
                    fragmentTransaction.add(R.id.fg_content,fragment3);
                }else{
                    fragmentTransaction.show(fragment3);
                }
                break;
            case R.id.radio_wo:

                if(fragment4 == null){
                    fragment4 = new WoFragment();
                    fragmentTransaction.add(R.id.fg_content,fragment4);
                }else {
                    fragmentTransaction.show(fragment4);
                }
                break;
        }
        fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
    }

    private void hideFragment(FragmentTransaction fragmentTransaction) {
        if(fragment1!=null){
            fragmentTransaction.hide(fragment1);
        }
        if(fragment2!=null){
            fragmentTransaction.hide(fragment2);
        }
        if(fragment3!=null){
            fragmentTransaction.hide(fragment3);
        }
        if(fragment4!=null){
            fragmentTransaction.hide(fragment4);
        }
    }
}
