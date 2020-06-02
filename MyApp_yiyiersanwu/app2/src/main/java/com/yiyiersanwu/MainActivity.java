package com.yiyiersanwu;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Environment;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    //音乐文件目录
    //获取外部存储路径
    File sdPath= Environment.getExternalStorageDirectory();
    File file=new File(sdPath,"a.mp3");



    private Intent intent;
    //创建ServiceConnection对象
    ServiceConnection conn;
    //内部类的对象
    MusicService.MyBinder binder;
    //定义控件
    TextView  tv_play;
    TextView  tv_pause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化控件
        tv_play=findViewById(R.id.tv_play);
        tv_pause=findViewById(R.id.tv_pause);
        //给控件设置监听器
        //播放音乐
        tv_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //验证播放
                if (file.exists() && file.length()>0){
                    //播放音乐
                    //返回文件的完整路径  file.getAbsolutePath()
                    binder.play(file.getAbsolutePath());
                }else {
                    Toast.makeText(MainActivity.this, "找不到音乐文件", Toast.LENGTH_SHORT).show();
                }

            }
        });
        //暂停音乐
        tv_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binder.pause(file.getAbsolutePath());

            }
        });

        //通过bindService启动Service
        //创建一个Intent对象
        intent=new Intent(this,MusicService.class);
        //创建ServiceConnection 对象，用来监听MainActivity 调用者与 Service(被调用者)之间的连接状态
        conn=new Myconn();
        bindService(intent,conn,BIND_AUTO_CREATE);


        //通过ServiceConnection方式断开Service
    }

    //定义ServiceConnection的实现类
    private  class Myconn implements ServiceConnection{

        //当MainActivity与Service连接成功时，将执行方法
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            //该方法用于获得从Service 返回的代理对象
            //参数service就是Service的代理对象
            binder= (MusicService.MyBinder) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    }
}
