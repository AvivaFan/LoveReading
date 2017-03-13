package com.android.reading.presenter;

import android.content.Context;

import com.android.reading.R;
import com.android.reading.view.BaseView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gu FanFan on 2017/3/11 0:08.
 * LoveReading.
 */

public class SkinPresenterImpl implements BasePresenter {

    private BaseView mView;
    private int[] mColorArray;

    public SkinPresenterImpl(Context context, BaseView view) {
        this.mView = view;
        mColorArray = context.getResources().getIntArray(R.array.themeColors);
    }

    @Override
    public void getDataList(Object o) {
        List<Integer> themeColors = new ArrayList<>();
        for (int color : mColorArray) {
            themeColors.add(color);
        }
        mView.showData(themeColors);
    }

    public int getColorIndex(int color) {
        for (int i = 0; i < mColorArray.length; i++) {
            if (color == mColorArray[i]){
                return i;
            }
        }
        return -1;
    }

    @Override
    public void onDestroy() {
    }
}
