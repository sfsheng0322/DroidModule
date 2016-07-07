package com.sunfusheng.module;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.orhanobut.logger.Logger;

/**
 * Created by sunfusheng on 16/7/7.
 */
public class BaseActivity extends AppCompatActivity implements View.OnClickListener {

    protected Context mContext;
    protected Activity mActivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.i("log-activity", "(" + getClass().getSimpleName() + ".java:1)");

        mContext = this;
        mActivity = this;
    }

    @Override
    public void onClick(View v) {

    }
}
