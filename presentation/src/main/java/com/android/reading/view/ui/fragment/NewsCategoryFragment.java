package com.android.reading.view.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;

import com.android.reading.R;
import com.android.reading.databinding.FragmentCommonRecycleBinding;
import com.android.reading.interactive.ClickHandler;
import com.android.reading.model.NewsModel;
import com.android.reading.presenter.CategoryPresenterImpl;
import com.android.reading.utils.Constants;
import com.android.reading.view.BaseView;
import com.android.reading.widget.RecyclerViewDivider;
import com.android.reading.view.ui.activity.DetailsActivity;
import com.android.reading.view.ui.adapter.NewsCategoryAdapter;
import com.android.reading.view.ui.base.BasePageFragment;

import java.util.List;

/**
 * Created by Gu FanFan on 2017/3/3 0:25.
 * 新闻类别Fragment.
 */

public class NewsCategoryFragment extends BasePageFragment implements BaseView, ClickHandler {

    private FragmentCommonRecycleBinding mBinding;
    private NewsCategoryAdapter mCategoryAdapter;
    private CategoryPresenterImpl mPresenter;


    public static NewsCategoryFragment newInstance(String type) {
        Bundle args = new Bundle();
        args.putString(Constants.BUNDLE_TYPE, type);
        NewsCategoryFragment fragment = new NewsCategoryFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutID() {
        return R.layout.fragment_common_recycle;
    }

    @Override
    protected boolean needLazyLoad() {
        return true;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (mPresenter != null && !isVisibleToUser) {
            mPresenter.onDestroy();
        }
    }

    @Override
    public void initView() {
        mBinding = (FragmentCommonRecycleBinding) mViewBinding;
        LinearLayoutManager layoutManager = new LinearLayoutManager(mActivity);
        mBinding.recycleView.setLayoutManager(layoutManager);
        mBinding.recycleView.addItemDecoration(new RecyclerViewDivider(
                mActivity, RecyclerViewDivider.HORIZONTAL));
        mBinding.refreshLayout.setColorSchemeColors(
                ContextCompat.getColor(mActivity, R.color.color_scheme_1),
                ContextCompat.getColor(mActivity, R.color.color_scheme_2),
                ContextCompat.getColor(mActivity, R.color.color_scheme_3),
                ContextCompat.getColor(mActivity, R.color.color_scheme_4));
        mBinding.refreshLayout.setRefreshing(true);
    }

    @Override
    public void initData() {
        String categoryType = getArguments().getString(Constants.BUNDLE_TYPE, Constants.NEWS_TOP);
        mCategoryAdapter = new NewsCategoryAdapter();
        mCategoryAdapter.setClickHandler(this);
        mBinding.recycleView.setAdapter(mCategoryAdapter);
        mPresenter = new CategoryPresenterImpl(mActivity, this);
        mPresenter.getDataList(categoryType);
    }

    @Override
    public void initListener() {
    }

    @Override
    public void showData(List<?> data) {
        if (mCategoryAdapter == null) {
            mCategoryAdapter = new NewsCategoryAdapter();
            mCategoryAdapter.setClickHandler(this);
        }

        if (mBinding.refreshLayout.isRefreshing())
            mBinding.refreshLayout.setRefreshing(false);

        mBinding.refreshLayout.setEnabled(false);
        mCategoryAdapter.addAll((List<NewsModel>) data);
    }

    @Override
    public void showMsg(Object msg) {
    }

    @Override
    public void onClick(Object o) {
        NewsModel newsModel = (NewsModel) o;
        Intent intent = new Intent();
        intent.setClass(mActivity, DetailsActivity.class);
        intent.putExtra(Constants.BUNDLE_MODEL, newsModel);
        intent.putExtra(Constants.BUNDLE_URL, newsModel.getUrl());
        intent.putExtra(Constants.BUNDLE_TYPE, getString(R.string.nav_news));
        getActivity().startActivity(intent);
    }

    @Override
    public void onLongClick() {
    }
}
