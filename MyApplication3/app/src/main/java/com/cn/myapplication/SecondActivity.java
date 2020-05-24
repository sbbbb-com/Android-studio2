package com.cn.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class SecondActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        //按钮，绑定自己
        Button butStart=findViewById(R.id.second_start);
        butStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SecondActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });

        Button but_third=findViewById(R.id.third_start);
        but_third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SecondActivity.this,ThirdActivity.class);
                startActivity(intent);
            }
        });
    }
}
