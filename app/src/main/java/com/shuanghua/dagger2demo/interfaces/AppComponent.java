package com.shuanghua.dagger2demo.interfaces;


import com.shuanghua.dagger2demo.MainActivity;
import com.shuanghua.dagger2demo.activity.MeiZiActivity;
import com.shuanghua.dagger2demo.module.AppModule;
import com.shuanghua.dagger2demo.module.ApiModule;

import dagger.Component;

/**
 * 其向外公布对象
 * <p>
 * 负责链接的作用
 * 链接 ApiModule 和 MainActivity
 */
@Component(
        modules = {//使用者在哪个类中寻找依赖
                AppModule.class
                , ApiModule.class
        }
)
public interface AppComponent {
    //将生产的依赖对象注入到 MainActivity 中使用
    void inject(MainActivity mainActivity);//在使用处调用

    void inject(MeiZiActivity meiZiActivity);
}
