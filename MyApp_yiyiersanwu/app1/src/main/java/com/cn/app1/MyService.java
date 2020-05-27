package com.cn.app1;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    //创造
    @Override
    public void onCreate() {
        super.onCreate();
        Log.v("app1","service create");
    }

    //启动
    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.v("app1","service start");
    }

    //销毁
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.v("app1","service destroy");
    }

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
