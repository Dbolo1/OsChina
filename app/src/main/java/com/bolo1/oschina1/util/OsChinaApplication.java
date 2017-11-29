package com.bolo1.oschina1.util;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Process;

/**
 * Created by 菠萝 on 2017/11/17.
 */

public class OsChinaApplication extends Application {
    private static Context context;
    private static Handler handler;
    private static int mainThreadId;


    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        handler = new Handler();
        mainThreadId = Process.myTid();

    }

    public static Context getContext() {
        return context;
    }

    public static Handler getHandler() {
        return handler;
    }

    public static int getMainThreadId() {
        return mainThreadId;
    }



}
