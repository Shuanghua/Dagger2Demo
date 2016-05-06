package com.shuanghua.dagger2demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.shuanghua.dagger2demo.activity.BaseActivity;
import com.shuanghua.dagger2demo.activity.MeiZiActivity;
import com.shuanghua.dagger2demo.adapter.RepoAdapter;
import com.shuanghua.dagger2demo.bean.Repo;
import com.shuanghua.dagger2demo.interfaces.ApiService;
import com.shuanghua.dagger2demo.interfaces.AppComponent;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Named;

import butterknife.InjectView;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends BaseActivity {

    @InjectView(R.id.repos_rv_list)
    RecyclerView mRecyclerView;

    @InjectView(R.id.pbLoading)
    ProgressBar mProgressBar;

    @Named("GitHub")
    @Inject
    ApiService githubApiService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(manager);

        RepoAdapter adapter = new RepoAdapter();
        mRecyclerView.setAdapter(adapter);
        loadData(adapter);
    }

    private void loadData(final RepoAdapter adapter) {
        showLoading(true);
        if (null != githubApiService) {
            githubApiService.getRepoData("Shuanghua")
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new MyObserver<ArrayList<Repo>>() {

                        @Override
                        public void onError(Throwable e) {
                            showLoading(false);
                        }

                        @Override
                        public void onNext(ArrayList<Repo> repos) {
                            showLoading(false);
                            adapter.setRepos(repos);
                        }
                    });
        }
    }

    public void showLoading(boolean loading) {
        mProgressBar.setVisibility(loading ? View.VISIBLE : View.GONE);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        appComponent.inject(this);
    }

    public void seeMeiZi(View view) {
        startActivity(new Intent(MainActivity.this, MeiZiActivity.class));
    }
}
