package com.shuanghua.dagger2demo.interfaces;

import com.shuanghua.dagger2demo.bean.MeiZi;
import com.shuanghua.dagger2demo.bean.Repo;

import java.util.ArrayList;

import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;

public interface ApiService {
    // https://api.github.com/users/Shuanghua/repos
    @GET("users/{user}/repos")
    Observable<ArrayList<Repo>> getRepoData(@Path("user") String user);

    // http://route.showapi.com/197-1
    // num=10
    // &page=1
    // &showapi_appid=18718
    // &showapi_sign=add54986163b423d9111738a679e93d6
    @GET("197-1")
    Observable<MeiZi> getMeiZiData(@Query("num") String num, @Query("page") String page
            , @Query("showapi_appid") String showapi_appid, @Query("showapi_sign") String showapi_sign);
}
