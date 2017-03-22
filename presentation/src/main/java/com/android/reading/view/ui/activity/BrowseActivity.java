package com.android.reading.view.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.LinearLayoutManager;

import com.android.reading.R;
import com.android.reading.databinding.ActivityBrowseBinding;
import com.android.reading.model.ChannelListModel;
import com.android.reading.model.NewsModel;
import com.android.reading.presenter.BrowsePresenterImpl;
import com.android.reading.utils.Constants;
import com.android.reading.view.ui.BrowseView;
import com.android.reading.view.ui.adapter.NewsAdapter;
import com.android.reading.view.ui.base.BaseActivity;
import com.android.reading.widget.RecyclerViewDivider;

import java.util.List;

/**
 * Created by Gu FanFan on 2017/3/20 20:57.
 * LoveReading.
 */

public class BrowseActivity extends BaseActivity implements BrowseView {

    private int mMaxPage;
    private int mCurrentPage = 1;
    private ChannelListModel mChannelListModel;
    private BrowsePresenterImpl mPresenter;
    private NewsAdapter mNewsAdapter;
    private ActivityBrowseBinding mBinding;

    public static Intent getCallingIntent(Context context, ChannelListModel label) {
        Intent intent = new Intent();
        intent.setClass(context, BrowseActivity.class);
        intent.putExtra(Constants.BUNDLE_MODEL, label);
        return intent;
    }

    @Override
    public void initView() {
        super.initView();
        mChannelListModel = getIntent().getParcelableExtra(Constants.BUNDLE_MODEL);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_browse);
        mBinding.setLabel(mChannelListModel.getName());
    }

    @Override
    public void initData() {
        super.initData();
        mPresenter = new BrowsePresenterImpl(this);
        mPresenter.getNewsList(mChannelListModel.getChannelId(),
                mChannelListModel.getName(), String.valueOf(mCurrentPage));
        mNewsAdapter = new NewsAdapter();
        mBinding.newRecycler.setLayoutManager(new LinearLayoutManager(this));
        mBinding.newRecycler.addItemDecoration(new RecyclerViewDivider(this, RecyclerViewDivider.HORIZONTAL));
        mBinding.newRecycler.setAdapter(mNewsAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }

    @Override
    public void showData(List<?> data) {
        mNewsAdapter.addAll((List<NewsModel.ContentListBean>) data);
    }

    @Override
    public void showMsg(Object msg) {
        showErrorToast((String) msg);
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

    @Override
    public void setMaxPage(int maxPage) {
        mMaxPage = maxPage;
    }

    @Override
    public void setCurrentPage(int currentPage) {
        mCurrentPage = currentPage;
    }
}
