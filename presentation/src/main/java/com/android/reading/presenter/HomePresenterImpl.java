package com.android.reading.presenter;

import android.support.v4.app.Fragment;

import com.android.reading.view.BaseView;
import com.android.reading.view.ui.fragment.LabelFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gu FanFan on 2017/3/20 11:21.
 * LoveReading.
 */

public class HomePresenterImpl implements BasePresenter {

    private String[] mLabelStrings;
    private BaseView mView;
    private List<Fragment> mFragments;

    public HomePresenterImpl(String[] labelStrings, BaseView view) {
        this.mLabelStrings = labelStrings;
        this.mView = view;
    }

    @Override
    public void getDataList(Object o) {
        if (mFragments == null || mFragments.size() < 1) {
            mFragments = new ArrayList<>();
            Fragment fragment;
            for (String label : mLabelStrings) {
                fragment = LabelFragment.newInstance(label);
                mFragments.add(fragment);
            }
        }

        mView.showData(mFragments);
    }

    @Override
    public void onDestroy() {

    }
}
