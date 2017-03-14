package com.android.reading.presenter;

import com.android.reading.view.LoginView;

/**
 * Created by Gu FanFan on 2017/3/14 19:32.
 * LoveReading.
 */

public class LoginPresenterImpl implements LoginPresenter {

    private LoginView mLoginView;

    public LoginPresenterImpl(LoginView loginView) {
        mLoginView = loginView;
    }

    @Override
    public void getDataList(Object o) {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onLogin(String name, String pass, boolean isRemember) {
        mLoginView.onLoginSuccess();
    }

    @Override
    public void onRegister(String name, String pass, String againPass) {

    }

    @Override
    public void startForgotPass() {

    }

    @Override
    public void onCancel() {
        mLoginView.showCancelView();
    }
}
