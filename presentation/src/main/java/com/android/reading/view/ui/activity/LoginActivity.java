package com.android.reading.view.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;

import com.android.reading.R;
import com.android.reading.databinding.ActivityLoginBinding;
import com.android.reading.interactive.ClickHandler;
import com.android.reading.presenter.LoginPresenterImpl;
import com.android.reading.utils.AnimatorUtils;
import com.android.reading.utils.DialogUtil;
import com.android.reading.view.LoginView;
import com.android.reading.view.ui.base.BaseActivity;
import com.android.reading.widget.NiftyDialog;

/**
 * Created by Gu FanFan on 2017/3/14 18:00.
 * LoveReading.
 */

public class LoginActivity extends BaseActivity implements LoginView, ClickHandler {

    private ActivityLoginBinding mBinding;
    private LoginPresenterImpl mPresenter;
    private int isLogin = -1;
    private NiftyDialog mDialog;

    public static Intent getCallingIntent(Context context) {
        return new Intent(context, LoginActivity.class);
    }

    @Override
    public void initView() {
        super.initView();
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        mBinding.setClick(this);
        mPresenter = new LoginPresenterImpl(this);
        initAnimator();
    }

    @Override
    public void initData() {
        super.initData();
    }

    @Override
    public void initListener() {
        super.initListener();
    }

    private void initAnimator() {
        AnimatorUtils.startTranslationX(mBinding.prompt, -16f, mBinding.prompt.getTranslationX(), false, 500);
        AnimatorUtils.startTranslationX(mBinding.login, -350f, mBinding.login.getTranslationX(), false, 500);
        AnimatorUtils.startTranslationX(mBinding.register, -350f, mBinding.register.getTranslationX(), false, 700);
    }

    private void startAnimator() {
        AnimatorUtils.startAnimatorSet(
                AnimatorUtils.setObjectAnimator(mBinding.prompt, "scaleY", 1f, 0, true),
                AnimatorUtils.setObjectAnimator(mBinding.prompt, "rotationY", 0, 90, true),
                600);

        AnimatorUtils.startTranslationY(mBinding.login, 0, mBinding.login.getHeight() / 2, false, 500);
        AnimatorUtils.startTranslationY(mBinding.register, 0, -(mBinding.register.getHeight() / 2), false, 500);

        if (isLogin == 0) {
            mBinding.prompt.setText(getString(R.string.dialog_login_btn));
            mDialog = DialogUtil.createLoginDialog(this, mPresenter);
        } else if (isLogin == 1){
            mBinding.prompt.setText(getString(R.string.dialog_register_btn));
            mDialog = DialogUtil.createRegisterDialog(this, mPresenter);
        }

        if (mDialog != null) {
            AnimatorUtils.startAnimatorSet(
                    AnimatorUtils.setObjectAnimator(mDialog.getDialogView(), "alpha", 0f, 1.0f, false),
                    AnimatorUtils.setObjectAnimator(mDialog.getDialogView(), "scaleX", 0.5f, 1.0f, false),
                    AnimatorUtils.setObjectAnimator(mDialog.getDialogView(), "scaleY", 0.5f, 1.0f, false),
                    500);
            mDialog.show();
        }
    }

    private void onReductionAnimator() {
        AnimatorUtils.startAnimatorSet(
                AnimatorUtils.setObjectAnimator(mBinding.prompt, "scaleY", 1f, 0, true),
                AnimatorUtils.setObjectAnimator(mBinding.prompt, "rotationY", 0, 90, true),
                600);
        mBinding.prompt.setText(getString(R.string.welcome));

        AnimatorUtils.startTranslationY(
                mBinding.login, mBinding.login.getHeight() / 2, 0, false, 500);
        AnimatorUtils.startTranslationY(
                mBinding.register, -(mBinding.register.getHeight() / 2), 0, false, 500);

        if (mDialog != null) {
            AnimatorUtils.startAnimatorSet(
                    AnimatorUtils.setObjectAnimator(mDialog.getDialogView(), "alpha", 1.0f, 0f, false),
                    AnimatorUtils.setObjectAnimator(mDialog.getDialogView(), "scaleX", 1.0f, 0.5f, false),
                    AnimatorUtils.setObjectAnimator(mDialog.getDialogView(), "scaleY", 1.0f, 0.5f, false),
                    600);
            mDialog.dismiss();
        }
    }

    @Override
    public void showMsg(Object msg) {

    }

    @Override
    public void onLoginSuccess() {
        Intent intent = HomeActivity.getCallingIntent(this);
        startActivity(intent);
        finish();
    }

    @Override
    public void showCancelView() {
        onReductionAnimator();
    }

    @Override
    public void onClick(Object o) {
        if (o instanceof Integer) {
            isLogin = (int) o;
            startAnimator();
        }
    }

    @Override
    public void onLongClick() {
    }
}
