package com.android.reading.interactive;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by Gu FanFan on 2017/3/11 7:11.
 * LoveReading.
 */

class DefaultObserver<T> extends DisposableObserver<T> {

    ObserverCallback mCallback;

    DefaultObserver(ObserverCallback callback) {
        mCallback = callback;
    }

    @Override
    public void onNext(T t) {
        // no-op by default.
    }

    @Override
    public void onComplete() {
        // no-op by default.
        mCallback.onComplete();
    }

    @Override
    public void onError(Throwable exception) {
        // no-op by default.
        mCallback.onError(exception.getMessage());
    }
}
