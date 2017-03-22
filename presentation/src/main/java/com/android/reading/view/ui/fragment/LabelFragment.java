package com.android.reading.view.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.android.reading.R;
import com.android.reading.data.prefenece.Preferences;
import com.android.reading.databinding.LayoutLabelBinding;
import com.android.reading.interactive.ClickHandler;
import com.android.reading.model.ChannelListModel;
import com.android.reading.presenter.LabelPresenterImpl;
import com.android.reading.utils.Constants;
import com.android.reading.utils.Utils;
import com.android.reading.view.BaseView;
import com.android.reading.view.ui.activity.BrowseActivity;
import com.android.reading.view.ui.adapter.LabelAdapter;
import com.android.reading.view.ui.adapter.MineAdapter;
import com.android.reading.view.ui.base.BasePageFragment;
import com.android.reading.widget.RecyclerViewDivider;

import java.util.List;

/**
 * Created by Gu FanFan on 2017/3/20 11:42.
 * LoveReading.
 */

public class LabelFragment extends BasePageFragment implements BaseView {

    private String mLabel;
    private LabelAdapter mLabelAdapter;
    private MineAdapter mMineAdapter;
    private LayoutLabelBinding mBinding;
    private LabelPresenterImpl mPresenter;
    private int mUserId = -1;

    public static LabelFragment newInstance(String label) {
        Bundle args = new Bundle();
        args.putString(Constants.BUNDLE_TYPE, label);
        LabelFragment fragment = new LabelFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initView() {
        mBinding = (LayoutLabelBinding) mViewBinding;
        mLabel = getArguments().getString(Constants.BUNDLE_TYPE);
        RecyclerView.LayoutManager manager;

        if (mLabel.equals(getString(R.string.mine))) {
            manager = new LinearLayoutManager(mActivity);
            mMineAdapter = new MineAdapter();
            mBinding.recycleView.setAdapter(mMineAdapter);
        } else {
            manager = new GridLayoutManager(mActivity, 3);
            mBinding.recycleView.addItemDecoration(new RecyclerViewDivider(mActivity, RecyclerViewDivider.GRID));
            mLabelAdapter = new LabelAdapter(mLabel);
            mLabelAdapter.setClickHandler(mLabelClickHandler);
            mBinding.recycleView.setAdapter(mLabelAdapter);
        }

        mBinding.recycleView.setLayoutManager(manager);
    }

    @Override
    public void initData() {
        mUserId = Preferences.newInstance(mActivity)
                .getIntData(com.android.reading.data.Constants.USER_ID, -1);
        mPresenter = new LabelPresenterImpl(mActivity, this);
        if (mLabel.equals(getString(R.string.favorite_label))) {
            if (mUserId != -1)
                mPresenter.getFavoriteList(mUserId, true);
        } else {
            mPresenter.getDataList(mLabel);
        }
    }

    @Override
    public void initListener() {
    }

    @Override
    public int getLayoutID() {
        return R.layout.layout_label;
    }

    @Override
    protected boolean needLazyLoad() {
        return true;
    }

    @Override
    public void showData(List<?> data) {
        if (mLabelAdapter == null)
            mLabelAdapter = new LabelAdapter(mLabel);

        if (data != null) {
            if (mBinding.emptyView.getVisibility() == View.VISIBLE)
                mBinding.emptyView.setVisibility(View.GONE);
            mLabelAdapter.addAll((List<ChannelListModel>) data);
        }
    }

    @Override
    public void showMsg(Object msg) {
        showErrorToast((String) msg);
    }

    @Override
    public void showEmptyView(String msg) {
        mBinding.setMessage(msg);
        mBinding.emptyView.setVisibility(View.VISIBLE);
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
    public void onResume() {
        super.onResume();
        if (!Utils.isEmpty(mLabel) && mUserId != -1) {
            if (mLabel.equals(getString(R.string.favorite_label))){
                    mPresenter.getFavoriteList(mUserId, false);
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null)
            mPresenter.onDestroy();
    }

    private ClickHandler mLabelClickHandler = new ClickHandler() {
        @Override
        public void onClick(Object o) {
            ChannelListModel listModel = (ChannelListModel) o;
            Intent intent = BrowseActivity.getCallingIntent(mActivity, listModel);
            startActivity(intent);
        }

        @Override
        public void onLongClick() {
        }
    };
}
