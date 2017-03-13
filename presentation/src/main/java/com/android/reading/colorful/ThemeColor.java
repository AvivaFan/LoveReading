package com.android.reading.colorful;

import com.android.reading.R;

/**
 * Created by Gu FanFan on 2017/3/11 1:48.
 * LoveReading.
 */

public enum ThemeColor {
    COLOR_1(R.color.primary_color_1), COLOR_2(R.color.primary_color_2),
    COLOR_3(R.color.primary_color_3), COLOR_4(R.color.primary_color_4),
    COLOR_5(R.color.primary_color_5), COLOR_6(R.color.primary_color_6),
    COLOR_7(R.color.primary_color_7), COLOR_8(R.color.primary_color_8),
    COLOR_9(R.color.primary_color_9), COLOR_10(R.color.primary_color_10),
    COLOR_11(R.color.primary_color_11), COLOR_12(R.color.primary_color_12),
    COLOR_13(R.color.primary_color_13), COLOR_14(R.color.primary_color_14),
    COLOR_15(R.color.primary_color_15), COLOR_16(R.color.primary_color_16),
    COLOR_17(R.color.primary_color_17), COLOR_18(R.color.primary_color_18);

    private int colorRes;

    ThemeColor(int colorRes) {
        this.colorRes = colorRes;
    }

    public int getColorRes() {
        return colorRes;
    }
}
