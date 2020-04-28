package com.cn.myapptest1;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class SecondActivity extends Activity {
    /**
     * 创建的三个方法
     */

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Log.e("SecondActivity","SecondActivity_onCreate");

        Button btnFinish=(Button)findViewById(R.id.btn_finish_self);
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //关闭自己secondActivity  类似返回键
                SecondActivity.this.finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("SecondActivity","SecondActivity_onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("SecondActivity","SecondActivity_onResume");
    }

    /*
    销毁的三个方法
     */
    @Override
    protected void onPause() {
        super.onPause();
        Log.e("SecondActivity","SecondActivity_onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("SecondActivity","SecondActivity_onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("SecondActivity","SecondActivity_onDestroy");
    }
}
