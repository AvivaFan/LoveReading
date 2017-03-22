package com.android.reading.view.ui.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.reading.R;
import com.android.reading.utils.DialogUtil;
import com.android.reading.utils.LogUtils;
import com.android.reading.widget.StyleToast;

/**
 * Created by Gu FanFan on 2017/3/5 17:27.
 * Viewpager + Fragment 实现数据懒加载.
 */

public abstract class BasePageFragment extends Fragment implements BaseFunction {

    protected ViewDataBinding mViewBinding;
    protected Activity mActivity;
    protected  boolean isInit = false;
    protected boolean isVisible = false;
    private Dialog mLoadingDialog;
    private StyleToast mStyleToast;

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
        mStyleToast = new StyleToast(mActivity);
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

    protected void showLoading() {
        if (mLoadingDialog == null)
            mLoadingDialog = DialogUtil.startLoadingDialog(getActivity());
        mLoadingDialog.show();
    }

    protected void dismissLoading() {
        if (mLoadingDialog != null)
            mLoadingDialog.dismiss();
    }

    protected void showShortToast(String toastMsg) {
        if (mStyleToast == null)
            mStyleToast = new StyleToast(mActivity);
        mStyleToast.setToastMsg(toastMsg);
        mStyleToast.setDuration(Toast.LENGTH_SHORT);
        mStyleToast.show();
    }

    protected void showLongToast(String toastMsg) {
        if (mStyleToast == null)
            mStyleToast = new StyleToast(mActivity);
        mStyleToast.setToastMsg(toastMsg);
        mStyleToast.setDuration(Toast.LENGTH_LONG);
        mStyleToast.show();
    }

    protected void showShortToast(String toastMsg, int icon) {
        if (mStyleToast == null)
            mStyleToast = new StyleToast(mActivity);

        mStyleToast.setToastMsg(toastMsg);
        mStyleToast.setIconRes(icon);
        mStyleToast.setDuration(Toast.LENGTH_SHORT);
        mStyleToast.show();
    }

    protected void showLongToast(String toastMsg, int icon) {
        if (mStyleToast == null)
            mStyleToast = new StyleToast(mActivity);

        mStyleToast.setToastMsg(toastMsg);
        mStyleToast.setIconRes(icon);
        mStyleToast.setDuration(Toast.LENGTH_LONG);
        mStyleToast.show();
    }

    protected void showLongCustomToast(String toastMsg, int icon, int toastBgColor) {
        mStyleToast.setToastMsg(toastMsg);
        mStyleToast.setIconRes(icon);
        mStyleToast.setDuration(Toast.LENGTH_LONG);
        mStyleToast.setToastBgColor(toastBgColor);
        mStyleToast.show();
    }

    protected void showShortCustomToast(String toastMsg, int icon, int toastBgColor) {
        mStyleToast.setToastMsg(toastMsg);
        mStyleToast.setIconRes(icon);
        mStyleToast.setDuration(Toast.LENGTH_SHORT);
        mStyleToast.setToastBgColor(toastBgColor);
        mStyleToast.show();
    }

    protected void showErrorToast(String msg) {
        showShortCustomToast(msg, R.drawable.ic_error, ContextCompat.getColor(mActivity, R.color.colorRed));
    }

    protected void showSuccessToast(String msg) {
        showShortCustomToast(msg, R.drawable.ic_success, ContextCompat.getColor(mActivity, R.color.colorPrimary));
    }
}
