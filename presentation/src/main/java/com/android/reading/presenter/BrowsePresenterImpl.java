package com.android.reading.presenter;

import com.android.reading.data.net.RequestApiImpl;
import com.android.reading.interactive.NewsListObserver;
import com.android.reading.interactive.ObserverCallback;
import com.android.reading.model.NewsModel;
import com.android.reading.view.ui.BrowseView;

import java.util.List;

/**
 * Created by Gu FanFan on 2017/3/20 22:44.
 * LoveReading.
 */

public class BrowsePresenterImpl implements BrowsePresenter, ObserverCallback {

    private BrowseView mBrowseView;
    private RequestApiImpl mRequestApi;

    public BrowsePresenterImpl(BrowseView browseView) {
        this.mBrowseView = browseView;
        this.mRequestApi = RequestApiImpl.newInstance();
    }

    @Override
    public void getNewsList(String channelId, String channelName, String page) {
        mBrowseView.showLoadingView();
        mRequestApi.getNews(channelId, channelName, page, new NewsListObserver(this));
    }

    @Override
    public void getDataList(Object o) {
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
        mBrowseView.dismissLoadingView();
        if (o instanceof String) {
            mBrowseView.showMsg(o);
        } else if (o instanceof NewsModel) {
            NewsModel newsModel = (NewsModel) o;
            onNext(newsModel.getContentlist());
            mBrowseView.setMaxPage(newsModel.getAllPages());
            mBrowseView.setCurrentPage(newsModel.getCurrentPage());
        }
    }

    @Override
    public void onNext(List<?> objects) {
        mBrowseView.showData(objects);
    }

    @Override
    public void onError(String msg) {
        mBrowseView.dismissLoadingView();
        mBrowseView.showMsg(msg);
    }
}
