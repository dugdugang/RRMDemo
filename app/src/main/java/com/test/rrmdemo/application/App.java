package com.test.rrmdemo.application;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by Administrator on 2017/9/19 0019.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
    }
}
