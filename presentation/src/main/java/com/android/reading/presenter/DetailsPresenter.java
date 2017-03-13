package com.android.reading.presenter;

/**
 * Created by Gu FanFan on 2017/3/9 7:03.
 * LoveReading.
 */

interface DetailsPresenter extends BasePresenter {

    /**
     * 添加到收藏
     */
    void onInsert(Object o);

    /**
     * 从收藏中删除
     */
    void onDelete(Object o);

    /**
     * 查询数据
     */
    void onQuery(Object o);
}
