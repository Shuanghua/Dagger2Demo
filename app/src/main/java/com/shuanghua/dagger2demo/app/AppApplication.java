package com.shuanghua.dagger2demo.app;

import android.app.Application;

import com.shuanghua.dagger2demo.interfaces.AppComponent;
import com.shuanghua.dagger2demo.interfaces.DaggerAppComponent;
import com.shuanghua.dagger2demo.module.AppModule;
import com.shuanghua.dagger2demo.module.ApiModule;

/**
 * 1、实例化 AppApplication 对象
 * 2、实例化 AppComponent 对象
 * 3、暴露 这两个对象
 */
public class AppApplication extends Application {
    private static AppApplication sInstance;
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        setupCompoent();
    }

    /**
     * DaggerAppComponent 、gitHubApiModule（）、appModule（） 在编译时自动生成
     */
    private void setupCompoent() {
        appComponent = DaggerAppComponent.builder()
                .apiModule(new ApiModule())
                .appModule(new AppModule(this))
                .build();
    }

    public static AppApplication getsInstance() {
        return sInstance;
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
