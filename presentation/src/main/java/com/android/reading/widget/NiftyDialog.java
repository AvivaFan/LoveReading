package com.android.reading.widget;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.view.View;

/**
 * Created by Gu FanFan on 2017/3/14 22:59.
 * LoveReading.
 */

public class NiftyDialog extends Dialog {

    private View mDialogView;

    public NiftyDialog(@NonNull Context context) {
        super(context);
    }

    public NiftyDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
    }

    public void setDialogView(View view) {
        setContentView(view);
        mDialogView = view;
    }

    public View getDialogView() {
        return mDialogView;
    }
}
