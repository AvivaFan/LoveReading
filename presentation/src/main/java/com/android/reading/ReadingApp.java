package com.android.reading;

import android.app.Application;

import com.android.reading.colorful.ThemeColor;
import com.android.reading.utils.LogUtils;

/**
 * Created by Gu FanFan on 2017/3/11 2:11.
 * LoveReading.
 */

public class ReadingApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        LogUtils.d("style: " + ThemeColor.COLOR_4.ordinal());
    }
}
