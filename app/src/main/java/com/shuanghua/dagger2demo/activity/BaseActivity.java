package com.shuanghua.dagger2demo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.shuanghua.dagger2demo.app.AppApplication;
import com.shuanghua.dagger2demo.interfaces.AppComponent;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.inject(this);
        setupActivityComponent(AppApplication.getsInstance().getAppComponent());
    }

    protected abstract void setupActivityComponent(AppComponent appComponent);

    protected abstract int getLayoutId();
}
