package com.zilong.findjob.aishangzu.content_fragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.zilong.findjob.aishangzu.R;

public class Layout_main_image extends AppCompatActivity {

    private TextView text_cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main_center);
        text_cancel = (TextView) findViewById(R.id.text_cancel);

        text_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
