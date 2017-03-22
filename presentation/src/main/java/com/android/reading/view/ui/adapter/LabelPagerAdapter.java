package com.android.reading.view.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Gu FanFan on 2017/3/20 11:30.
 * LoveReading.
 */

public class LabelPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragments;
    private String[] mLabels;

    public LabelPagerAdapter(FragmentManager fm, List<Fragment> fragments, String[] labels) {
        super(fm);
        this.mFragments = fragments;
        this.mLabels = labels;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mLabels[position];
    }
}
