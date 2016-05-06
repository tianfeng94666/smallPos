package com.example.tianfeng.smallpos.application;

import android.app.Application;

import org.xutils.x;

/**
 * Created by admin on 2016-05-04.
 */
public class LYJApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);//Xutils初始化
    }
}
