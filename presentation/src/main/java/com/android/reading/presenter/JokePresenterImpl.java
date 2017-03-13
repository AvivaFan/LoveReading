package com.android.reading.presenter;

import android.content.Context;

import com.android.reading.data.net.RequestApiImpl;
import com.android.reading.interactive.JokeObserver;
import com.android.reading.interactive.ObserverCallback;
import com.android.reading.view.BaseView;

import java.util.List;

/**
 * Created by Gu FanFan on 2017/3/7 4:24.
 * LoveReading.
 */

public class JokePresenterImpl implements ObserverCallback, BasePresenter {

    private BaseView mJokeView;
    private RequestApiImpl mRequestApi;

    public JokePresenterImpl(Context context, BaseView jokeView) {
        this.mJokeView = jokeView;
        mRequestApi = RequestApiImpl.newInstance(context);
    }

    @Override
    public void getDataList(Object o) {
        mRequestApi.getJokeList(new JokeObserver(this));
    }

    @Override
    public void onDestroy() {
        mRequestApi = null;
    }

    @Override
    public void onComplete() {
    }

    @Override
    public void onNext(Object o) {
    }

    @Override
    public void onNext(List<?> objects) {
        mJokeView.showData(objects);
    }

    @Override
    public void onError(String msg) {
        mJokeView.showMsg(msg);
    }
}
