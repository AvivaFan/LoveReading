package com.android.reading.view.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.LinearLayoutManager;
import android.view.MenuItem;

import com.android.reading.R;
import com.android.reading.databinding.ActivityCommonListBinding;
import com.android.reading.interactive.ClickHandler;
import com.android.reading.model.CollectionModel;
import com.android.reading.presenter.CollectionPresenterImpl;
import com.android.reading.utils.Constants;
import com.android.reading.utils.Utils;
import com.android.reading.view.BaseView;
import com.android.reading.view.ui.adapter.CollectionAdapter;
import com.android.reading.view.ui.base.BaseActivity;

import java.util.List;

/**
 * Created by Gu FanFan on 2017/3/10 23:22.
 * LoveReading.
 */

public class CollectionActivity extends BaseActivity implements BaseView, ClickHandler {

    private CollectionAdapter mAdapter;
    private CollectionPresenterImpl mPresenter;

    public static Intent getCallingIntent(Context context) {
        return new Intent(context, CollectionActivity.class);
    }

    @Override
    public void initView() {
        super.initView();
        ActivityCommonListBinding binding =
                DataBindingUtil.setContentView(CollectionActivity.this, R.layout.activity_common_list);
        setSupportActionBar(binding.toolbar);
        setTitle(R.string.nav_collection);

        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        binding.recycleView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new CollectionAdapter();
        mAdapter.setClickHandler(this);
        binding.recycleView.setAdapter(mAdapter);
    }

    @Override
    public void initData() {
        super.initData();
        mPresenter = new CollectionPresenterImpl(this, this);
    }

    @Override
    protected void onResume() {
        super.onResume();
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
    public void onClick(Object o) {
        CollectionModel collectionModel = (CollectionModel) o;

        if (!collectionModel.getType().equals(Constants.NAV_JOKE)) {
            Intent intent = new Intent();
            intent.setClass(this, DetailsActivity.class);
            intent.putExtra(Constants.BUNDLE_MODEL, collectionModel);
            intent.putExtra(Constants.BUNDLE_URL, collectionModel.getUrl());
            intent.putExtra(Constants.BUNDLE_TYPE, getString(R.string.nav_collection));
            startActivity(intent);
        } else {

        }
    }

    @Override
    public void onLongClick() {

    }

    @Override
    public void showData(List<?> data) {
        if (!Utils.isEmpty(data)) {
            mAdapter.addAll((List<CollectionModel>) data);
        } else {

        }
    }

    @Override
    public void showMsg(Object msg) {

    }
}
