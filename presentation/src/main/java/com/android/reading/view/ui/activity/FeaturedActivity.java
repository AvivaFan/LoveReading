package com.android.reading.view.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.LinearLayoutManager;
import android.view.MenuItem;

import com.android.reading.R;
import com.android.reading.databinding.ActivityCommonListBinding;
import com.android.reading.interactive.ClickHandler;
import com.android.reading.model.FeaturedModel;
import com.android.reading.presenter.FeaturedPresenterImpl;
import com.android.reading.utils.Constants;
import com.android.reading.view.BaseView;
import com.android.reading.widget.RecyclerViewDivider;
import com.android.reading.view.ui.adapter.FeaturedAdapter;
import com.android.reading.view.ui.base.BaseActivity;

import java.util.List;

/**
 * Created by Gu FanFan on 2017/3/10 23:01.
 * LoveReading.
 */

public class FeaturedActivity extends BaseActivity implements BaseView, ClickHandler {

    private FeaturedAdapter mAdapter;
    private FeaturedPresenterImpl mPresenter;
    private int mPage = 1;

    public static Intent getCallingIntent(Context context) {
        return new Intent(context, FeaturedActivity.class);
    }

    @Override
    public void initView() {
        super.initView();
        ActivityCommonListBinding binding =
                DataBindingUtil.setContentView(FeaturedActivity.this, R.layout.activity_common_list);
        setSupportActionBar(binding.toolbar);
        setTitle(R.string.nav_featured);

        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recycleView.setLayoutManager(layoutManager);
        binding.recycleView.addItemDecoration(new RecyclerViewDivider(
                this, RecyclerViewDivider.HORIZONTAL));
        mAdapter = new FeaturedAdapter();
        mAdapter.setHandler(this);
        binding.recycleView.setAdapter(mAdapter);
    }

    @Override
    public void initData() {
        super.initData();
        mPresenter = new FeaturedPresenterImpl(this, this);
        mPresenter.getDataList(mPage);
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
    public void onClick(Object o) {
        FeaturedModel featuredModel = (FeaturedModel) o;
        Intent intent = new Intent();
        intent.setClass(this, DetailsActivity.class);
        intent.putExtra(Constants.BUNDLE_MODEL, featuredModel);
        intent.putExtra(Constants.BUNDLE_URL, featuredModel.getUrl());
        intent.putExtra(Constants.BUNDLE_TYPE, getString(R.string.nav_featured));
        startActivity(intent);
    }

    @Override
    public void onLongClick() {
    }

    @Override
    public void showData(List<?> data) {
        if (mAdapter == null) {
            mAdapter = new FeaturedAdapter();
            mAdapter.setHandler(this);
        }

        mAdapter.addAll((List<FeaturedModel>) data);
    }

    @Override
    public void showMsg(Object msg) {

    }
}
