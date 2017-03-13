package com.android.reading.view.ui.base;

import android.app.Activity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.reading.utils.LogUtils;

/**
 * Created by Gu FanFan on 2017/3/5 17:27.
 * Viewpager + Fragment 实现数据懒加载.
 */

public abstract class BasePageFragment extends Fragment implements BaseFunction {

    protected ViewDataBinding mViewBinding;
    protected Activity mActivity;
    protected  boolean isInit = false;
    protected boolean isVisible = false;

    /**
     * 可见
     */
    protected void onVisible() {
        LogUtils.e("i am on Visible");
        if (isInit){
            init();
            LogUtils.e(" i am to init");
            isInit = false;
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mViewBinding = DataBindingUtil.inflate(inflater, getLayoutID(), container, false);
        return mViewBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        isInit = true;
        if (needLazyLoad()) {
            if (isVisible)
                onVisible();
        } else {
            onVisible();
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        isVisible = isVisibleToUser;
        if (isVisible)
            onVisible();
    }

    public abstract int getLayoutID();

    protected boolean needLazyLoad(){
        return false;
    }

    protected void init() {
        initView();
        initData();
        initListener();
    }
}
