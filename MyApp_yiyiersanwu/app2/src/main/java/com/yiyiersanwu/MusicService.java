package com.yiyiersanwu;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;

public class MusicService extends Service {
    private MediaPlayer mediaPlayer=null;
    public MusicService() {
    }


    //提供两个方法，播放音乐，暂停音乐
    //创建服务代理 目的是让main 可以成功调用service中的这两个方法
    class MyBinder extends Binder{
        //定义播放音乐的方法
        public void play(String path){
            //path，音乐文件路径
            Log.i("play","play执行了------m----正在播放音乐"+path);

            try {
                if (mediaPlayer==null){
                    //第一次点击播放按钮
                    //创建播放器
                    mediaPlayer=new MediaPlayer();
                    //指定参数为音频文件
                    mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    //指定播放文件
                    mediaPlayer.setDataSource(path);
                    //准备播放  加载音频流 加载完后才可以播放
                    mediaPlayer.prepare();
                    //加载完后，才可以播放
                    mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mp) {
                            //加载成功，开始播放
                            mp.start();
                        }
                    });
                }else {
                    //不是第一次加载
                    //获得当前播放的位置
                    int position = mediaPlayer.getCurrentPosition();
                    //定位到播放位置
                    mediaPlayer.seekTo(position); //寻找位置定位到
                    //继续播放
                    mediaPlayer.start();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //定义暂停音乐的方法
        public void pause(String path){
            //path，音乐文件
            Log.i("pause","play执行了------m----暂停音乐"+path);
             if (mediaPlayer!=null && mediaPlayer.isPlaying()){
                 //暂停
                 mediaPlayer.pause();
             }else if (mediaPlayer!=null && !mediaPlayer.isPlaying()){
                 //播放
                 mediaPlayer.start();
             }
        }
    }

    //第一次创建服务时执行
    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("Service生命周期onCreate","onCreate执行了");
    }

    //当mainactivity通过bindService启动时执行
    @Override
    public IBinder onBind(Intent intent) {
        Log.i("Service生命周期onBind","onCreate执行了");
        //返回代理对象 返回给main activity
        return  new MyBinder();
    }

    //当activity通过unBindService断开服务绑定的时候执行
    @Override
    public boolean onUnbind(Intent intent) {

        Log.i("Service生命周期onUnbind","onUnbind执行了");
        return super.onUnbind(intent);
    }

    //服务被销毁时执行
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("Service生命周期onDestroy","onDestroy");
    }


}
