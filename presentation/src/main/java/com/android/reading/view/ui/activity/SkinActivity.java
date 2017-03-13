package com.android.reading.view.ui.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.view.MenuItem;

import com.android.reading.R;
import com.android.reading.colorful.Colorful;
import com.android.reading.colorful.ThemeColor;
import com.android.reading.databinding.ActivityCommonListBinding;
import com.android.reading.interactive.ClickHandler;
import com.android.reading.presenter.SkinPresenterImpl;
import com.android.reading.view.BaseView;
import com.android.reading.view.ui.adapter.SkinAdapter;
import com.android.reading.view.ui.base.BaseActivity;
import com.android.reading.widget.RecyclerViewDivider;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Created by Gu FanFan on 2017/3/10 23:49.
 * LoveReading.
 */

public class SkinActivity extends BaseActivity implements BaseView, ClickHandler {

    private ActivityCommonListBinding mBinding;
    private SkinAdapter mAdapter;
    private SkinPresenterImpl mPresenter;
    private ProgressDialog mProgressDialog;

    public static Intent getCallingIntent(Context context) {
        return new Intent(context, SkinActivity.class);
    }

    @Override
    public void initView() {
        super.initView();
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_common_list);
        setSupportActionBar(mBinding.toolbar);
        setTitle(R.string.nav_colorful);

        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        mAdapter = new SkinAdapter();
        mAdapter.setClickHandler(this);
        mBinding.recycleView.setLayoutManager(layoutManager);
        mBinding.recycleView.addItemDecoration(new
                RecyclerViewDivider(this, DividerItemDecoration.HORIZONTAL));
        mBinding.recycleView.setAdapter(mAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void initData() {
        super.initData();
        mPresenter = new SkinPresenterImpl(this, this);
        mPresenter.getDataList(null);
    }

    @Override
    public void showData(List<?> data) {
        mAdapter.addAll((List<Integer>) data);
    }

    @Override
    public void showMsg(Object msg) {

    }

    @Override
    public void onClick(Object o) {
        int colorIndex = mPresenter.getColorIndex((Integer) o);
        if (colorIndex != -1) {
            Colorful.newInstance(getApplicationContext())
                    .setNight(false)
                    .setThemeColor(ThemeColor.values()[colorIndex])
                    .apply();
        }

        recreate();
    }

    @Override
    public void onLongClick() {
    }

    private class MyHandler extends Handler {
        private WeakReference<SkinActivity> mActivity;

        public MyHandler(SkinActivity activity) {
            mActivity = new WeakReference<SkinActivity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            SkinActivity activity = mActivity.get();
            if (activity != null) {
                mProgressDialog.dismiss();
            }
        }
    }
}
