package com.zilong.findjob.aishangzu.content_fragment;

import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zilong.findjob.aishangzu.R;

public class LoginPage extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout linear_login_title;
    private TextView login_text_quick;
    private TextView login_text_password;
    private FragmentTransaction fragmentTransaction;
    private Login_quickFragment fragment_quick;
    private Login_passwordFragment fragment_password;
    private FragmentManager manager;
    private ImageView image_quick;
    private ImageView image_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        initView();
        initEvent();
        fragmentTransaction.commit();

    }

    private void initEvent() {
        login_text_quick.setOnClickListener(this);
        login_text_password.setOnClickListener(this);
    }

    private void initView() {
        linear_login_title = (LinearLayout) findViewById(R.id.linear_login_title);
        login_text_quick = (TextView) findViewById(R.id.login_text_quick);
        login_text_password = (TextView) findViewById(R.id.login_text_password);
        image_quick = (ImageView) findViewById(R.id.image_quick);
        image_password = (ImageView) findViewById(R.id.image_password);

        manager = getSupportFragmentManager();
        fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.add(R.id.fg_login,new Login_quickFragment());
        image_quick.setVisibility(View.VISIBLE);
        login_text_quick.setTextColor(Color.WHITE);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_text_quick:
                FragmentTransaction transaction_quick = manager.beginTransaction();
                transaction_quick.replace(R.id.fg_login,new Login_quickFragment());
                image_quick.setVisibility(View.VISIBLE);
                image_password.setVisibility(View.INVISIBLE);
                login_text_quick.setTextColor(Color.WHITE);
                login_text_password.setTextColor(Color.GRAY);
                transaction_quick.commit();
                break;
            case R.id.login_text_password:
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.fg_login,new Login_passwordFragment());
                image_password.setVisibility(View.VISIBLE);
                image_quick.setVisibility(View.INVISIBLE);
                login_text_password.setTextColor(Color.WHITE);
                login_text_quick.setTextColor(Color.GRAY);
                transaction.commit();
                break;
        }
    }
}
