package com.cn.app10;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv_sms;
    Button btn_readSMS;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化控件
        btn_readSMS=findViewById(R.id.btn_readSMS);
        tv_sms=findViewById(R.id.tv_sms);

        //给按钮注册监听器
        btn_readSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取系统短信
            }
        });
    }
}
