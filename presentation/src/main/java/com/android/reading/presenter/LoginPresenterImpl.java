package com.android.reading.presenter;

import android.content.Context;

import com.android.reading.R;
import com.android.reading.data.MD5Utils;
import com.android.reading.data.net.UserRequestApiImpl;
import com.android.reading.data.prefenece.Preferences;
import com.android.reading.interactive.ObserverCallback;
import com.android.reading.interactive.RegisterObserver;
import com.android.reading.interactive.UserObserver;
import com.android.reading.mapper.DataMapper;
import com.android.reading.model.UserModel;
import com.android.reading.utils.Utils;
import com.android.reading.view.LoginView;

import java.util.List;

/**
 * Created by Gu FanFan on 2017/3/14 19:32.
 * LoveReading.
 */

public class LoginPresenterImpl implements LoginPresenter, ObserverCallback {

    private Context mContext;
    private LoginView mLoginView;
    private UserRequestApiImpl mRequestApi;
    private Preferences mPreferences;

    public LoginPresenterImpl(Context context, LoginView loginView) {
        mContext = context;
        mLoginView = loginView;
        mRequestApi = UserRequestApiImpl.newInstance();
        mPreferences = Preferences.newInstance(context);
    }

    @Override
    public void getDataList(Object o) {

    }

    @Override
    public void onDestroy() {
        mRequestApi = null;
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onLogin(String name, String pass) {
        mLoginView.showLoadingView();
        mRequestApi.login(name, MD5Utils.MD5(MD5Utils.MD5(pass)), new UserObserver(this));
    }

    @Override
    public void onRegister(String name, String pass, String againPass) {
        if (Utils.isEmpty(name)
                || Utils.isEmpty(pass)
                || Utils.isEmpty(againPass)) {
            mLoginView.showMsg(Utils.getString(mContext, R.string.register_name_or_pass_empty));
            return;
        }

        if (!pass.equals(againPass)) {
            mLoginView.showMsg(Utils.getString(mContext, R.string.register_pass_not_consistent));
            return;
        }

        mRequestApi.register(name, MD5Utils.MD5(MD5Utils.MD5(pass)), new RegisterObserver(this));
    }

    @Override
    public void startForgotPass() {

    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onNext(Object o) {
        mLoginView.dismissLoadingView();
        if (o instanceof UserModel) {
            mLoginView.onLoginSuccess();
            mPreferences.putUserInfo(DataMapper.transFormUser((UserModel) o));
        } else if (o instanceof String) {
            mLoginView.onRegisterSuccess((String) o);
        }
    }

    @Override
    public void onNext(List<?> objects) {
    }

    @Override
    public void onError(String msg) {
        mLoginView.showMsg(msg);
    }
}
