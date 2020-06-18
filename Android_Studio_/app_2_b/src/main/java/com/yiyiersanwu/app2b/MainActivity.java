package com.yiyiersanwu.app2b;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ContentResolver resolver;
    private Uri uri;
    private ContentValues values;

    private Button  btn_search;
    private EditText et_name;
    private Button btn_add;
    private Button btn_del;
    private Button btn_updata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化控件
        et_name=findViewById(R.id.et_name);
        btn_search=findViewById(R.id.btn_search);
        btn_add=findViewById(R.id.btn_add);
        btn_del=findViewById(R.id.btn_del);
        btn_updata=findViewById(R.id.btn_updata);
        //注册监听器  查询按钮
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //查询操作
                resolver=getContentResolver();
                String userName=et_name.getText().toString();
                uri=Uri.parse("content://com.yyesw.app2/info");
                //调用a程序中的query接口
                Cursor infoCursor = null;
                if (userName!=null && !"".equals(userName)){
                    infoCursor=resolver.query(uri, new String[]{"_id", "name"}, "name=?", new String[]{userName}, null);
                }else {
                    infoCursor=resolver.query(uri,  new String[]{"_id", "name"}, null, null, null);
                }

                //遍历Cursor
                if (infoCursor!=null){
                    while (infoCursor.moveToNext()){
                        int id=infoCursor.getInt(0);
                        String name=infoCursor.getString(1);
                        Log.i("id="+id,"user"+name);
                        Toast.makeText(MainActivity.this, "id="+id+"name="+name, Toast.LENGTH_SHORT).show();
                    }
                    infoCursor.close();
                }else {
                    Toast.makeText(MainActivity.this, "请检查路径后重启应用", Toast.LENGTH_SHORT).show();
                    Log.e("id+路径错误","请检查路径后，应用后重启");
                }
            }
        });

        //注册监听器  添加按钮
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //调用项目a的接口 添加一条数据
                resolver=getContentResolver();
                values=new ContentValues();
                values.put("name",et_name.getText().toString());
                uri=Uri.parse("content://com.yyesw.app2/info");
                resolver.insert(uri,values);
                Toast.makeText(MainActivity.this, "添加成功", Toast.LENGTH_SHORT).show();
                Log.i("db","添加成功");
            }
        });

        //注册监听器  删除按钮
        btn_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //调用项目a的接口 根据条件 删除数据
                resolver=getContentResolver();
                uri=Uri.parse("content://com.yyesw.app2/info");
                int del = resolver.delete(uri, "name=?", new String[]{et_name.getText().toString()});
                Toast.makeText(MainActivity.this, "删除成功", Toast.LENGTH_SHORT).show();
            }
        });

        //注册监听器  修改按钮
        btn_updata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //调用项目a的接口 根据条件 修改数据
                resolver=getContentResolver();
                uri=Uri.parse("content://com.yyesw.app2/info");
                values=new ContentValues();
                values.put("name",et_name.getText().toString());
                resolver.update(uri,values,"_id=?",new String[]{"2"});
                Toast.makeText(MainActivity.this, "修改成功", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
