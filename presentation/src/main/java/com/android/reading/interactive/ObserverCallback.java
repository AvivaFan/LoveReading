package com.android.reading.interactive;

import java.util.List;

/**
 * Created by Gu FanFan on 2017/3/11 7:44.
 * LoveReading.
 */

public interface ObserverCallback {

    void onComplete();

    void onNext(Object o);

    void onNext(List<?> objects);

    void onError(String msg);
}
