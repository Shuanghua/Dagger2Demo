package com.shuanghua.dagger2demo.app;

import android.app.Application;

import com.shuanghua.dagger2demo.interfaces.AppComponent;
import com.shuanghua.dagger2demo.interfaces.DaggerAppComponent;
import com.shuanghua.dagger2demo.module.AppModule;
import com.shuanghua.dagger2demo.module.GitHubApiModule;

public class AppApplication extends Application {
    private static AppApplication sInstance;
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        this.sInstance = this;
        setupCompoent();
    }

    /**
     * DaggerAppComponent 、gitHubApiModule（）、appModule（） 在编译时生成
     */
    private void setupCompoent() {
        appComponent = DaggerAppComponent.builder()
                .gitHubApiModule(new GitHubApiModule())
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
