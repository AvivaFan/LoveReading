package com.android.reading.presenter;

/**
 * Created by Gu FanFan on 2017/3/14 19:32.
 * LoveReading.
 */

public interface LoginPresenter extends BasePresenter {

    void onCreate();

    void onLogin(String name, String pass, boolean isRemember);

    void onRegister(String name, String pass, String againPass);

    void startForgotPass();

    void onCancel();
}
