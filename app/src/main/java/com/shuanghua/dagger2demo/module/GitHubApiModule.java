package com.shuanghua.dagger2demo.module;

import android.app.Application;
import com.shuanghua.dagger2demo.R;
import com.shuanghua.dagger2demo.interfaces.GitHubApiService;
import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * 在被 @Module 注解修饰的类，使用 @Procides 注解来表明可以提供的依赖对象
 * Created by ShuangHua on 2016/5/4.
 */
@Module
public class GitHubApiModule {

    @Provides
    public OkHttpClient provideOkHttpClient() {
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setConnectTimeout(60 * 1000, TimeUnit.MILLISECONDS);
        okHttpClient.setReadTimeout(60 * 1000, TimeUnit.MILLISECONDS);
        return okHttpClient;
    }

    @Provides
    public Retrofit provideRetrofit(Application application, OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(application.getString(R.string.api_github))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        return retrofit;
    }

    @Provides
    protected GitHubApiService provideGitHubService(Retrofit retrofit) {
        return retrofit.create(GitHubApiService.class);
    }
}
