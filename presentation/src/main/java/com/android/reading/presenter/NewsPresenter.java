package com.android.reading.presenter;

import android.support.v4.app.Fragment;

import java.util.List;

/**
 * Created by Gu FanFan on 2017/3/3 1:50.
 * LoveReading.
 */

interface NewsPresenter {

    List<Fragment> getNewsCategoryList();

    void showNewsCategoryView();
}
