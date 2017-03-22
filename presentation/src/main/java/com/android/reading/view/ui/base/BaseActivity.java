package com.android.reading.view.ui.base;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.android.reading.R;
import com.android.reading.data.Constants;
import com.android.reading.data.prefenece.Preferences;
import com.android.reading.utils.DialogUtil;
import com.android.reading.widget.StyleToast;

/**
 * Created by Gu FanFan on 2017/3/2 12:34.
 * BaseActivity.
 */

public class BaseActivity extends AppCompatActivity implements BaseFunction {

    private boolean mIsNight;
    private int mThemeId;
    private StyleToast mStyleToast;
    protected Preferences mPreferences;
    private Dialog mLoadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initTheme();
        super.onCreate(savedInstanceState);
        mPreferences = Preferences.newInstance(this);
        mStyleToast = new StyleToast(this);
        initView();
        initData();
        initListener();
    }

    @Override
    public void initView() {
    }

    @Override
    public void initData() {
    }

    @Override
    public void initListener() {
    }

    private void initTheme() {
        mIsNight = Preferences.newInstance(this)
                .getBooleanData(Constants.PREFERENCE_THEME_NIGHT, false);
        mThemeId = Preferences.newInstance(this).getIntData(Constants.PREFERENCE_THEME, -1);
        if (mIsNight) {
            setTheme(R.style.AppTheme_Night);
        } else {
            setTheme(R.style.AppTheme);
        }

        getTheme().applyStyle(mThemeId, true);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    protected void showShortToast(String toastMsg) {
        if (mStyleToast == null)
            mStyleToast = new StyleToast(this);
        mStyleToast.setToastMsg(toastMsg);
        mStyleToast.setDuration(Toast.LENGTH_SHORT);
        mStyleToast.show();
    }

    protected void showLongToast(String toastMsg) {
        if (mStyleToast == null)
            mStyleToast = new StyleToast(this);
        mStyleToast.setToastMsg(toastMsg);
        mStyleToast.setDuration(Toast.LENGTH_LONG);
        mStyleToast.show();
    }

    protected void showShortToast(String toastMsg, int icon) {
        if (mStyleToast == null)
            mStyleToast = new StyleToast(this);

        mStyleToast.setToastMsg(toastMsg);
        mStyleToast.setIconRes(icon);
        mStyleToast.setDuration(Toast.LENGTH_SHORT);
        mStyleToast.show();
    }

    protected void showLongToast(String toastMsg, int icon) {
        if (mStyleToast == null)
            mStyleToast = new StyleToast(this);

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
        showShortCustomToast(msg, R.drawable.ic_error, ContextCompat.getColor(this, R.color.colorRed));
    }

    protected void showSuccessToast(String msg) {
        showShortCustomToast(msg, R.drawable.ic_success, ContextCompat.getColor(this, R.color.colorPrimary));
    }

    protected void showLoading() {
        if (mLoadingDialog == null)
            mLoadingDialog = DialogUtil.startLoadingDialog(this);
        mLoadingDialog.show();
    }

    protected void dismissLoading() {
        if (mLoadingDialog != null)
            mLoadingDialog.dismiss();
    }
}
