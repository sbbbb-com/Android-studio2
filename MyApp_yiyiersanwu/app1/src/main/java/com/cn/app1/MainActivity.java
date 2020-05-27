package com.cn.app1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button but_start;
    private Button but_stop;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //对启动按钮的设置
        intent=new Intent(MainActivity.this,MyService.class);
        //intent=new Intent();
        //intent.setAction("HH_service");
        //intent.setAction(getPackageName());
        but_start=findViewById(R.id.but_start);
        but_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //启动服务
                startService(MainActivity.this.intent);
                startService(intent);
            }
        });

        //对关闭按钮的设置
        but_stop=findViewById(R.id.but_stop);
        but_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //关闭服务
                stopService(MainActivity.this.intent);
            }
        });
    }
}
