package com.android.reading.view.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewStubProxy;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager;

import com.android.reading.R;
import com.android.reading.databinding.ActivityLoginBinding;
import com.android.reading.databinding.LayoutLoginBinding;
import com.android.reading.databinding.LayoutRegisterBinding;
import com.android.reading.interactive.LoginHandler;
import com.android.reading.presenter.LoginPresenterImpl;
import com.android.reading.utils.AnimatorUtils;
import com.android.reading.utils.Utils;
import com.android.reading.view.LoginView;
import com.android.reading.view.ui.base.BaseActivity;

/**
 * Created by Gu FanFan on 2017/3/14 18:00.
 * LoveReading.
 */

public class LoginActivity extends BaseActivity implements LoginView, LoginHandler {

    private ActivityLoginBinding mBinding;
    private LayoutLoginBinding mLoginBinding;
    private LayoutRegisterBinding mRegisterBinding;
    private LoginPresenterImpl mPresenter;
    private View mLoginView;
    private View mRegisterView;

    public static Intent getCallingIntent(Context context) {
        return new Intent(context, LoginActivity.class);
    }

    @Override
    public void initView() {
        super.initView();
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        if (Utils.hasJellyBean()) {
            getWindow().getDecorView().setBackground(ContextCompat.getDrawable(this, R.drawable.login_window_background));
        }
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        mPresenter = new LoginPresenterImpl(this, this);

        mBinding.loginViewStub.setOnInflateListener(new ViewStub.OnInflateListener() {
            @Override
            public void onInflate(ViewStub stub, View inflated) {
                mLoginBinding = DataBindingUtil.bind(inflated);
                mLoginBinding.setLoginClick(LoginActivity.this);
            }
        });

        mBinding.registerViewStub.setOnInflateListener(new ViewStub.OnInflateListener() {
            @Override
            public void onInflate(ViewStub stub, View inflated) {
                mRegisterBinding = DataBindingUtil.bind(inflated);
                mRegisterBinding.setLoginClick(LoginActivity.this);
            }
        });

        mLoginView = setViewInflate(mBinding.loginViewStub);
        setViewVisibility(mLoginView, View.VISIBLE);
        setViewVisibility(mRegisterView, View.GONE);
    }

    @Override
    public void initData() {
        super.initData();
    }

    @Override
    public void initListener() {
        super.initListener();
    }

    @Override
    public void showMsg(Object msg) {
        showErrorToast((String) msg);
    }

    @Override
    public void onLoginSuccess() {
        showSuccessToast(getString(R.string.login_success));
        Intent intent = HomeActivity.getCallingIntent(this);
        startActivity(intent);
        finish();
    }

    @Override
    public void onRegisterSuccess(String msg) {
        showSuccessToast(msg);
        onStartLogin();
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
    public void onStartRegister() {
        setViewVisibility(mLoginView, View.GONE);
        if (mRegisterView == null) {
            mRegisterView = setViewInflate(mBinding.registerViewStub);
        }
        AnimatorUtils.startRotationY(mRegisterView, 180f, 0f, false, 400);
        setViewVisibility(mRegisterView, View.VISIBLE);
    }

    @Override
    public void onStartLogin() {
        setViewVisibility(mRegisterView, View.GONE);
        if (mLoginView == null)
            mLoginView = setViewInflate(mBinding.loginViewStub);
        setViewVisibility(mLoginView, View.VISIBLE);
        AnimatorUtils.startRotationY(mLoginView, -180f, 0f, false, 400);
    }

    @Override
    public void onLogin() {
        if (mLoginBinding != null) {
            String name = mLoginBinding.name.getText().toString();
            String passWord = mLoginBinding.password.getText().toString();
            mPresenter.onLogin(name, passWord);
        } else {
            showErrorToast(getString(R.string.login_app_error));
        }
    }

    @Override
    public void onRegister() {
        if (mRegisterBinding != null) {
            String name = mRegisterBinding.name.getText().toString();
            String passWord = mRegisterBinding.password.getText().toString();
            String againPass = mRegisterBinding.againPassword.getText().toString();
            mPresenter.onRegister(name, passWord, againPass);
        } else {
            showErrorToast(getString(R.string.login_app_error));
        }
    }

    @Override
    public void onClose() {
        finish();
    }

    private void setViewVisibility(View view, int visibility) {
        if (view != null)
            view.setVisibility(visibility);
    }

    private View setViewInflate(ViewStubProxy stubProxy) {
        View view = null;
        ViewStub viewStub = stubProxy.getViewStub();
        if (!stubProxy.isInflated())
            view = viewStub.inflate();
        return view;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }
}
