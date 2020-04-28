package com.cn.myapptest1;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class MyActivity extends Activity {
    Button butStart;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        //打印日志测试
        Log.e("MyActivity","MyActivity_onCreate");

        butStart=(Button) findViewById(R.id.but_start_second);
        butStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //启动第二个activity

                //显示启动的第一种方法
                /*Intent intent=new Intent(MyActivity.this,SecondActivity.class);
                startActivity(intent);*/

                //显示启动的第二种方法
               /* Intent intent1=new Intent();
                intent1.setClass(MyActivity.this,com.cn.myapptest1.SecondActivity.class);
                startActivity(intent1);*/

               //显示启动的第三种方法
                /*Intent intent2=new Intent();
                ComponentName componentName=new ComponentName(MyActivity.this,SecondActivity.class);
                intent2.setComponent(componentName);
                startActivity(intent2);*/

                //隐式启动的第一种方法
                /*Intent intent3=new Intent();
                intent3.setAction("abcd.SecondActivity");
                startActivity(intent3);*/

                //隐式启动的第二种方法
                Intent intent4=new Intent("abcd.SecondActivity");
                startActivity(intent4);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("MyActivity","MyActivity_onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("MyActivity","MyActivity_onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("MyActivity","MyActivity_onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("MyActivity","MyActivity_onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("MyActivity","MyActivity_onDestroy");
    }
}
