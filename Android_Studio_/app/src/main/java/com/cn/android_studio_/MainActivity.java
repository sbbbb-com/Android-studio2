package com.cn.android_studio_;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btn_readSMS;
    TextView tv_sms;
    private TextView tvDes;
    private  String text="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //绑定控件并且初始化
        btn_readSMS=findViewById(R.id.btn_readSMS);
        tv_sms=findViewById(R.id.tv_sms);
        tvDes = (TextView) findViewById(R.id.tv_des);

        btn_readSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取短信内容

                //查询系统信息的uri
                Uri uri = Uri.parse("content://sms/");
                //获取ContentResolver对象
                ContentResolver resolver = getContentResolver();
                //通过ContentResolver对象查询系统短信
                Cursor cursor = resolver.query(uri, new String[]{ "_id","address",
                        "type","body", "date"}, null, null, null);
                List<SmsInfo> smsInfos = new ArrayList<SmsInfo>();

                if (cursor != null && cursor.getCount() > 0) {
                    tvDes.setVisibility(View.VISIBLE);
                    while (cursor.moveToNext()) {
                        int _id = cursor.getInt(0);
                        String address = cursor.getString(1);
                        int type = cursor.getInt(2);
                        String body = cursor.getString(3);
                        long date = cursor.getLong(4);
                        SmsInfo smsInfo = new SmsInfo(_id, address, type, body, date);
                        smsInfos.add(smsInfo);
                    }
                    cursor.close();
                }
                //将查询到的短信内容显示到界面上
                for (int i = 0; i < smsInfos.size(); i++) {
                    text += "手机号码：" + smsInfos.get(i).getAddress() + "\n";
                    text += "短信内容：" + smsInfos.get(i).getBody() + "\n\n";
                    tv_sms.setText(text);
                }

            }
        });
    }
}