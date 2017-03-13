package com.android.reading.data.net;

/**
 * Created by Gu FanFan on 2017/3/2 23:29.
 * LoveReading.
 */

public interface RequestCallBack {

    void onSuccess(Object object);

    void onFailure(String msg);
}
