package com.android.reading.presenter;

import android.support.v4.app.Fragment;

import com.android.reading.view.BaseView;
import com.android.reading.view.ui.fragment.NewsCategoryFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gu FanFan on 2017/3/3 1:51.
 * LoveReading.
 */

public class NewsPresenterImpl implements NewsPresenter {

    private BaseView mNewsView;
    private String[] mNewsCategory;

    public NewsPresenterImpl(String[] newsCategory, BaseView newsView) {
        mNewsView = newsView;
        mNewsCategory = newsCategory;
    }

    @Override
    public List<Fragment> getNewsCategoryList() {
        List<Fragment> fragments = new ArrayList<>();
        Fragment fragment;
        for (String category : mNewsCategory) {
            fragment = NewsCategoryFragment.newInstance(category);
            fragments.add(fragment);
        }
        return fragments;
    }

    @Override
    public void showNewsCategoryView() {
        mNewsView.showData(getNewsCategoryList());
    }
}
