package com.yyesw.app2;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;

public class MyContentProvider extends ContentProvider {

    private SQLiteDatabase db;
    private Context context;
    private PersonDBOpenHelper helper;
    //定义uri路径的匹配器，如果匹配不成功返回-1
    private static UriMatcher matcher = new UriMatcher(-1);

    //添加路径匹配规则
    static {
        matcher.addURI("com.yyesw.app2", "info", 1);
    }


    public MyContentProvider() {
        //构造方法
    }

    //向外暴露一个用于删除数据表记录的方法
    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {

        //判断查询的uri路径是否匹配
        int code = matcher.match(uri);
        if (code == 1) {
            db = helper.getReadableDatabase();
            int info = db.delete("info", selection, selectionArgs);
            db.close();
            return info;
        } else {
            //匹配失败
            throw new IllegalArgumentException("路径不正确，请检查路径后重启app，禁止删除数据！");
        }
    }

    //用于返回指定Url代表的MIME类型
    @Override
    public String getType(Uri uri) {

        return null;
    }

    //向外暴露一个添加数据表记录的方法
    @Override
    public Uri insert(Uri uri, ContentValues values) {

        //判断查询的uri路径是否匹配
        int code = matcher.match(uri);
        if (code == 1) {
            //匹配成功
            db = helper.getWritableDatabase();
            long rowId = db.insert("info", null, values);
            db.close();
            if (rowId > 0) {
                Log.i("db", "数据插入成功");
                return uri;
            } else {
                Log.e("db", "数据插入失败");
            }

        } else {
            //匹配失败
            throw new IllegalArgumentException("路径不正确，请检查路径后重启app，禁止添加数据！");
        }
        return uri;
    }

    //当内容提供者被创建的时候，执行此方法
    @Override
    public boolean onCreate() {
        context = getContext();
        helper = new PersonDBOpenHelper(context);
        db = helper.getWritableDatabase();
        //在数据表中添加初始数据
        db.execSQL("delete from info");
        db.execSQL("insert into  info values(1,'张三')");
        db.execSQL("insert into  info values(2,'李四')");
        db.execSQL("insert into  info values(3,'王五')");
        db.execSQL("insert into  info values(4,'赵六')");
        db.close();
        return true;
    }

    //向外暴露一个用于查询的数据表记录的方法
    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        //判断查询的uri路径是否匹配
        int code = matcher.match(uri);
        if (code == 1) {
            db = helper.getReadableDatabase();
            Cursor info = db.query("info", projection, selection, selectionArgs, null, null, sortOrder);
            //db.close();
            return info;
        } else {
            //匹配失败
            throw new IllegalArgumentException("路径不正确，请检查路径后重启app，我是不会给你提供数据的！");
        }
    }

    //向外暴露一个用于数据表记录修改的方法
    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {

        //判断查询的uri路径是否匹配
        int code = matcher.match(uri);
        if (code == 1) {
            db = helper.getReadableDatabase();
            int info = db.update("info", values, selection, selectionArgs);
            db.close();
            return  info;
        } else {
            //匹配失败
            throw new IllegalArgumentException("路径不正确，请检查路径后重启app，禁止修改数据！");
        }

    }

}
