package com.yiyiersanwu.te;

import android.content.ClipData;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

/**
 * @author 何心想
 * @date  2020-9-1
 * 第一天创建
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //注册首页邮箱按钮及绑定信息
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "点击邮箱了", Toast.LENGTH_SHORT).show();
            }
        });
        
        //如果用户对设置菜单进行点击
        View viewById = findViewById(R.id.quit);
        viewById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "点击退出了", Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 膨胀菜单；这会将项目添加到操作栏（如果有）。
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //单击处理操作栏项。只要您在AndroidManifest.xml中指定父活动，
        // 操作栏就会自动处理Home
        // Up按钮上的单击。
        int id = item.getItemId();

        //无检查SimplifiableIf声明
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}