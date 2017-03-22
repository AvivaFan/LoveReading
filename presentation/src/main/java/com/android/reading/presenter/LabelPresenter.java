package com.android.reading.presenter;

/**
 * Created by Gu FanFan on 2017/3/20 13:19.
 * LoveReading.
 */

public interface LabelPresenter extends BasePresenter{

    void getAllChannelList();

    void getFavoriteList(int id, boolean isFirst);

    void getMineList();
}
