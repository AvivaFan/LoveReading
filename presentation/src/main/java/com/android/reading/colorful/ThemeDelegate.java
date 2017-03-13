package com.android.reading.colorful;

import android.content.Context;
import android.support.annotation.StyleRes;

import com.android.reading.R;

public class ThemeDelegate {

    @StyleRes private int styleResPrimary;
    @StyleRes private int styleResBase;

    ThemeDelegate(Context context, int index, boolean dark) {
        styleResPrimary = context.getResources().
                getIdentifier("Primary" + index, "style", context.getPackageName());
        styleResBase = dark ? R.style.AppTheme : R.style.AppTheme_Night;
    }


    public int getStyleResPrimary() {
        return styleResPrimary;
    }

    public int getStyleResBase() {
        return styleResBase;
    }
}
