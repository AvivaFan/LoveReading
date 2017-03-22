package com.android.reading.view.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v4.app.Fragment;

import com.android.reading.R;
import com.android.reading.data.Constants;
import com.android.reading.databinding.ActivityHomeBinding;
import com.android.reading.presenter.HomePresenterImpl;
import com.android.reading.utils.DateUtils;
import com.android.reading.utils.Utils;
import com.android.reading.view.BaseView;
import com.android.reading.view.ui.adapter.LabelPagerAdapter;
import com.android.reading.view.ui.base.BaseActivity;

import java.util.List;

public class HomeActivity extends BaseActivity
        implements BaseView {

    private ActivityHomeBinding mBinding;
    private String[] mLabelStrings;

    public static Intent getCallingIntent(Context context) {
        return new Intent(context, HomeActivity.class);
    }

    @Override
    public void initView() {
        super.initView();
        mBinding = DataBindingUtil.setContentView(HomeActivity.this, R.layout.activity_home);
    }

    @Override
    public void initData() {
        super.initData();
        mLabelStrings = getResources().getStringArray(R.array.tab_label);
        HomePresenterImpl presenter = new HomePresenterImpl(mLabelStrings, this);
        presenter.getDataList(null);
        String userName = mPreferences.getStringData(Constants.USER_REAL_NAME, null);
        if (Utils.isEmpty(userName))
            userName = mPreferences.getStringData(Constants.USER_NAME, "AvivaFan");

        mBinding.nameText.setText(userName);
        mBinding.dataText.setText(DateUtils.millis2String(System.currentTimeMillis(), DateUtils.MD_E));
    }

    @Override
    public void showData(List<?> data) {
        mBinding.labelViewPage.setAdapter(new LabelPagerAdapter(
                getSupportFragmentManager(), (List<Fragment>) data, mLabelStrings));
        mBinding.labelViewPage.setOffscreenPageLimit(data.size() - 1);
        mBinding.labelLayout.setupWithViewPager(mBinding.labelViewPage);
    }

    @Override
    public void showMsg(Object msg) {
    }

    @Override
    public void showEmptyView(String msg) {

    }

    @Override
    public void showLoadingView() {
        showLoading();
    }

    @Override
    public void dismissLoadingView() {
        dismissLoading();
    }
}
