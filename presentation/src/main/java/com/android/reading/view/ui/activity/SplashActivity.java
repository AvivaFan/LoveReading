package com.android.reading.view.ui.activity;

import android.content.Intent;

import com.android.reading.view.ui.base.BaseActivity;

/**
 * Created by Gu FanFan on 2017/3/14 17:45.
 * LoveReading.
 */

public class SplashActivity extends BaseActivity {

    @Override
    public void initData() {
        super.initData();
        Intent intent = LoginActivity.getCallingIntent(this);
        startActivity(intent);
        finish();
    }
}
