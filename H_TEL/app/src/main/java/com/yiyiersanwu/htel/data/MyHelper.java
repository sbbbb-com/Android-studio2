package com.yiyiersanwu.htel.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @author Hexinxiang
 * @date 2020-9-1
 */
public class MyHelper extends SQLiteOpenHelper {
    public MyHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        // contexty:上下文，MainActivity
        // name：数据库的名称
        // factory:null
        // version:数据库的版本号1
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlStr="create table information(_id integer primary key autoincrement,name varchar(20),phone varchar(20))";
        db.execSQL(sqlStr);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
