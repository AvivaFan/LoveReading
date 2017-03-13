package com.android.reading.colorful;

import android.content.Context;

import com.android.reading.data.Constants;
import com.android.reading.data.prefenece.Preferences;

public class Colorful {

    private static Colorful sColorful;
    private static final Object synchronizedLock = new Object();
    private Context mContext;
    private ThemeColor mThemeColor;
    private boolean mNight = false;

    public static Colorful newInstance(Context context) {
        if (sColorful == null) {
            synchronized (synchronizedLock) {
                sColorful = new Colorful(context);
            }
        }

        return sColorful;
    }

    public Colorful(Context context) {
        mContext = context;
    }

    public Colorful setThemeColor(ThemeColor themeColor) {
        mThemeColor = themeColor;
        return this;
    }

    public Colorful setNight(boolean night) {
        mNight = night;
        return this;
    }

    public boolean isNight() {
        return mNight;
    }

    ThemeColor getThemeColor() {
        return mThemeColor;
    }

    public int getThemeRes() {
        ThemeColor themeColor = getThemeColor();

        if (themeColor != null) {
            int themeIndex = getThemeColor().ordinal() + 1;
            return mContext.getResources()
                    .getIdentifier("Primary" + themeIndex, "style", mContext.getPackageName());
        }

        return -1;
    }

    public void apply() {
        Preferences.newInstance(mContext)
                .putIntData(Constants.PREFERENCE_THEME, getThemeRes());
        Preferences.newInstance(mContext)
                .putBooleanData(Constants.PREFERENCE_THEME_NIGHT, isNight());
    }
}
