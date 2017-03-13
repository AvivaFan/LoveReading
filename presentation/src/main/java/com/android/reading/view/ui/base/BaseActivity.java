package com.android.reading.view.ui.base;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.android.reading.R;
import com.android.reading.colorful.Colorful;
import com.android.reading.data.Constants;
import com.android.reading.data.prefenece.Preferences;
import com.android.reading.utils.LogUtils;

/**
 * Created by Gu FanFan on 2017/3/2 12:34.
 * BaseActivity.
 */

public class BaseActivity extends AppCompatActivity implements BaseFunction {

    private boolean mIsNight;
    private int mThemeId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initTheme();
        super.onCreate(savedInstanceState);
        initView();
        initData();
        initListener();
    }

    @Override
    public void initView() {
    }

    @Override
    public void initData() {
    }

    @Override
    public void initListener() {
    }

    private void initTheme() {
        mIsNight = Preferences.newInstance(this)
                .getBooleanData(Constants.PREFERENCE_THEME_NIGHT, false);
        mThemeId = Preferences.newInstance(this).getIntData(Constants.PREFERENCE_THEME, -1);
        if (mIsNight) {
            setTheme(R.style.AppTheme_Night);
        } else {
            setTheme(R.style.AppTheme);
        }

        getTheme().applyStyle(mThemeId, true);
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtils.e("onResume");
        Colorful colorful = Colorful.newInstance(this);

        if (colorful != null && colorful.getThemeRes() > -1 && colorful.getThemeRes() != mThemeId) {
            Handler handler = new Handler();
            handler.post(new Runnable() {
                @Override
                public void run() {
                    recreate();
                }
            });
        }
    }
}
