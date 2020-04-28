package com.cn.myapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class MyActivity  extends Activity {

    Button btnStart;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart=(Button) findViewById(R.id.btn_start_sec);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //启动调用第二个activity

                Intent intent=new Intent();
                intent.setClass(MyActivity.this,SecondActivity.class);

                startActivity(intent);
            }
        });
    }
}
