package com.cn.yiyiersanwu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_send;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //初始化控件
        btn_send=findViewById(R.id.but_send);
        //注册监听器
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //发送一条求救广播
                Toast.makeText(MainActivity.this, "救命啊", Toast.LENGTH_SHORT).show();
            }
        });
        
    }
}
