package com.android.reading.view.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.MenuItem;

import com.android.reading.R;
import com.android.reading.databinding.ActivityJokeBinding;
import com.android.reading.model.JokeModel;
import com.android.reading.presenter.JokePresenterImpl;
import com.android.reading.view.BaseView;
import com.android.reading.view.ui.adapter.JokeAdapter;
import com.android.reading.view.ui.base.BaseActivity;
import com.android.reading.widget.RecyclerViewDivider;

import java.util.List;

/**
 * Created by Gu FanFan on 2017/3/10 22:35.
 * LoveReading.
 */

public class JokeActivity extends BaseActivity implements BaseView,
        SwipeRefreshLayout.OnRefreshListener {

    private ActivityJokeBinding mBinding;
    private JokeAdapter mJokeAdapter;
    private JokePresenterImpl mPresenter;

    public static Intent getCallingIntent(Context context) {
        return new Intent(context, JokeActivity.class);
    }

    @Override
    public void initView() {
        super.initView();
        mBinding = DataBindingUtil.setContentView(JokeActivity.this, R.layout.activity_joke);
        setSupportActionBar(mBinding.toolbar);
        setTitle(R.string.nav_joke);

        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        LinearLayoutManager mManager = new LinearLayoutManager(this);
        mBinding.recycleView.setLayoutManager(mManager);
        mBinding.recycleView.addItemDecoration(new RecyclerViewDivider(
                this, RecyclerViewDivider.HORIZONTAL));
        mBinding.refreshLayout.setColorSchemeColors(
                ContextCompat.getColor(this, R.color.color_scheme_1),
                ContextCompat.getColor(this, R.color.color_scheme_2),
                ContextCompat.getColor(this, R.color.color_scheme_3),
                ContextCompat.getColor(this, R.color.color_scheme_4));
        mBinding.refreshLayout.setOnRefreshListener(this);
    }

    @Override
    public void initData() {
        super.initData();
        mJokeAdapter = new JokeAdapter();
        mBinding.recycleView.setAdapter(mJokeAdapter);
        mPresenter = new JokePresenterImpl(this, this);
        mPresenter.getDataList(null);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null)
            mPresenter.onDestroy();
    }

    @Override
    public void onRefresh() {
        mPresenter.getDataList(null);
    }

    @Override
    public void showData(List<?> data) {
        if (mBinding.refreshLayout.isRefreshing())
            mBinding.refreshLayout.setRefreshing(false);

        mJokeAdapter.addAll((List<JokeModel>) data);
            mBinding.recycleView.scrollToPosition(0);
    }

    @Override
    public void showMsg(Object msg) {

    }
}
