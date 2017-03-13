package com.android.reading.widget;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;

/**
 * Created by Gu FanFan on 2017/3/11 5:27.
 * LoveReading.
 */

public class NiftyDialog extends Dialog {

    public NiftyDialog(@NonNull Context context) {
        super(context);
    }

    public NiftyDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
    }
}
