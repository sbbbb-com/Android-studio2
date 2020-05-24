package com.cn.myapplication;

import android.app.Activity;
import android.app.AppComponentFactory;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);


        //绑定第二个activity
        Button button1=(Button) findViewById(R.id.start_button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });

        //绑定自己的退出按钮
        Button butClose=findViewById(R.id.main_finish);
        butClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.finish();
            }
        });
    }

}
