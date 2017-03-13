package com.android.reading.presenter;

import android.content.Context;

import com.android.reading.data.net.RequestApiImpl;
import com.android.reading.interactive.NewsListObserver;
import com.android.reading.interactive.ObserverCallback;
import com.android.reading.view.BaseView;

import java.util.List;

/**
 * Created by Gu FanFan on 2017/3/5 15:32.
 * LoveReading.
 */

public class CategoryPresenterImpl implements ObserverCallback, BasePresenter {

    private BaseView mCategoryView;
    private RequestApiImpl mRequestApi;

    public CategoryPresenterImpl(Context context, BaseView categoryView) {
        mCategoryView = categoryView;
        mRequestApi = RequestApiImpl.newInstance(context);
    }

    @Override
    public void getDataList(Object o) {
        mRequestApi.getNewsList((String) o, new NewsListObserver(this));
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
        mCategoryView.showData(objects);
    }

    @Override
    public void onError(String msg) {
        mCategoryView.showMsg(msg);
    }
}
