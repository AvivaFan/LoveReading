package com.android.reading.view.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.android.reading.utils.Constants;

import java.util.List;

/**
 * Created by Gu FanFan on 2017/3/3 0:53.
 * LoveReading.
 */

public class NewsCategoryPageAdapter extends FragmentPagerAdapter {

    private String[] mNewsCategory;
    private List<Fragment> mFragments;

    public NewsCategoryPageAdapter(FragmentManager fm, List<Fragment> fragments, String[] newsCategory) {
        super(fm);
        mFragments = fragments;
        mNewsCategory = newsCategory;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
        // return NewsCategoryFragment.newInstance(Constants.NEWS_CATEGORY[position]);
    }

    @Override
    public int getCount() {
        return Constants.NEWS_CATEGORY.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mNewsCategory[position];
    }
}
