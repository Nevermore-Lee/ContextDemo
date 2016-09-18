package com.example.lee.contextdemo;

import android.app.Application;
import android.content.Context;
import android.util.Log;

/**
 * Created by Administrator on 2016/9/18.
 */
public class MyApplication extends Application{
    public MyApplication(){
//        String packageName =getPackageName();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        String packageName = getPackageName();
        Log.d("leehao",packageName);
    }
}
