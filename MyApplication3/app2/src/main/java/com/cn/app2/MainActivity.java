package com.cn.app2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("MainActivity","当前处于的taskid=="+getTaskId());

        Button button=findViewById(R.id.main_start_second);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //指定intentFlag来启动secondActivity；
                Intent intent=new Intent(MainActivity.this,SecondActivity.class);

//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
}
