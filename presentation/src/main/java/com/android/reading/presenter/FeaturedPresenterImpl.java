package com.android.reading.presenter;

import android.content.Context;

import com.android.reading.data.net.RequestApiImpl;
import com.android.reading.interactive.FeaturedObserver;
import com.android.reading.interactive.ObserverCallback;
import com.android.reading.view.BaseView;

import java.util.List;

/**
 * Created by Gu FanFan on 2017/3/8 8:44.
 * LoveReading.
 */

public class FeaturedPresenterImpl implements ObserverCallback, BasePresenter {

    private BaseView mFeaturedView;
    private RequestApiImpl mRequestApi;

    public FeaturedPresenterImpl(Context context, BaseView featuredView) {
        this.mFeaturedView = featuredView;
        mRequestApi = RequestApiImpl.newInstance(context);
    }

    @Override
    public void getDataList(Object o) {
        mRequestApi.getFeaturedList((int) o, new FeaturedObserver(this));
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
        mFeaturedView.showData(objects);
    }

    @Override
    public void onError(String msg) {
        mFeaturedView.showMsg(msg);
    }
}
