package com.shuanghua.dagger2demo.interfaces;


import com.shuanghua.dagger2demo.MainActivity;
import com.shuanghua.dagger2demo.module.AppModule;
import com.shuanghua.dagger2demo.module.GitHubApiModule;

import dagger.Component;

@Component(modules = {AppModule.class, GitHubApiModule.class})
public interface AppComponent {
    //注入 ReposListActivity
    void inject(MainActivity activity);
}
