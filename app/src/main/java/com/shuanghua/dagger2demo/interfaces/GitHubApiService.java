package com.shuanghua.dagger2demo.interfaces;

import com.shuanghua.dagger2demo.bean.Repo;

import java.util.ArrayList;

import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

/**
 * Created by ShuangHua on 2016/5/4.
 */
public interface GitHubApiService {
    //https://api.github.com/users/Shuanghua/repos
    @GET("/users/{user}/repos")
    Observable<ArrayList<Repo>> getRepoData(@Path("user") String user);
}
