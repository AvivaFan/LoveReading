package com.android.reading.presenter;

/**
 * Created by Gu FanFan on 2017/3/20 22:44.
 * LoveReading.
 */

public interface BrowsePresenter extends BasePresenter {

    void getNewsList(String channelId, String channelName, String page);
}
