package com.android.reading.utils;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.android.reading.R;
import com.android.reading.presenter.LoginPresenterImpl;
import com.android.reading.widget.NiftyDialog;

/**
 * Created by Gu FanFan on 2017/3/14 21:19.
 * LoveReading.
 */

public class DialogUtil {

    public static NiftyDialog createDialog(Context context, int layoutId, int themeId) {
        View view = View.inflate(context, layoutId, null);
        NiftyDialog dialog;
        dialog = new NiftyDialog(context, themeId);
        dialog.setDialogView(view);
        dialog.setCancelable(false);

        /*WindowManager.LayoutParams params = dialog.getWindow().getAttributes();
        params.height = ScreenUtils.getScreenHeight(context) / 3;
        params.width = ScreenUtils.getScreenWidth(context);
        params.gravity = Gravity.CENTER;
        dialog.getWindow().setAttributes(params);*/
        return dialog;
    }

    public static NiftyDialog createRegisterDialog(final Context context, final LoginPresenterImpl presenter) {
        NiftyDialog dialog = createDialog(context, R.layout.dialog_register, R.style.CustomDialog_Translucent);
        final EditText nameEditText = (EditText) dialog.findViewById(R.id.name);
        final EditText passEditText = (EditText) dialog.findViewById(R.id.pass);
        final EditText againPassEditText = (EditText) dialog.findViewById(R.id.againPass);
        Button registerButton = (Button) dialog.findViewById(R.id.register);
        Button cancelButton = (Button) dialog.findViewById(R.id.cancel);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString().trim();
                String pass = passEditText.getText().toString().trim();
                String againPass = againPassEditText.getText().toString().trim();

                presenter.onRegister(name, pass, againPass);
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onCancel();
            }
        });
        return dialog;
    }

    public static NiftyDialog createLoginDialog(final Context context, final LoginPresenterImpl presenter) {
        NiftyDialog dialog = createDialog(context, R.layout.dialog_login, R.style.CustomDialog_Translucent);
        final EditText nameEditText = (EditText) dialog.findViewById(R.id.name);
        final EditText passEditText = (EditText) dialog.findViewById(R.id.pass);
        Button loginButton = (Button) dialog.findViewById(R.id.login);
        final CheckBox rememberCheckBox = (CheckBox) dialog.findViewById(R.id.remember);
        TextView forgotTextView = (TextView) dialog.findViewById(R.id.forgotPass);
        Button cancelButton = (Button) dialog.findViewById(R.id.cancel);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString().trim();
                String pass = passEditText.getText().toString().trim();

                presenter.onLogin(name, pass, rememberCheckBox.isChecked());
            }
        });

        forgotTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.startForgotPass();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onCancel();
            }
        });
        return dialog;
    }
}
