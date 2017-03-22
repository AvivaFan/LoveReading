package com.android.reading.utils;

import android.app.Dialog;
import android.content.Context;
import android.view.View;

import com.android.reading.R;

/**
 * Created by Gu FanFan on 2017/3/14 21:19.
 * LoveReading.
 */

public class DialogUtil {

    public static Dialog createDialog(Context context, int layoutId, int themeId) {
        View view = View.inflate(context, layoutId, null);
        Dialog dialog;
        dialog = new Dialog(context, themeId);
        dialog.setContentView(view);
        dialog.setCancelable(false);
        return dialog;
    }

    public static Dialog startLoadingDialog(Context context) {
        return createDialog(context, R.layout.layout_loading, R.style.CustomDialog);
    }
}
