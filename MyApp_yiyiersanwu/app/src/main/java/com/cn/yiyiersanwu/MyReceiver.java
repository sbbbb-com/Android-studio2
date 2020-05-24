package com.cn.yiyiersanwu;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
       //由这个接收者拯救
        Toast.makeText(context, "求你一下", Toast.LENGTH_SHORT).show();
    }
}
