package com.android.reading.view.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;

import com.android.reading.R;
import com.android.reading.databinding.ActivityReadBinding;
import com.android.reading.view.ui.base.BaseActivity;

/**
 * Created by Gu FanFan on 2017/3/20 17:23.
 * LoveReading.
 */

public class ReadActivity extends BaseActivity {

    private ActivityReadBinding mBinding;

    public static Intent getCallingIntent(Context context) {
        return new Intent(context, ReadActivity.class);
    }

    @Override
    public void initView() {
        super.initView();
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_read);
    }
}
