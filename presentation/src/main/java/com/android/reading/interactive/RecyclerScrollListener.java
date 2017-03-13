package com.android.reading.interactive;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by Gu FanFan on 2017/3/11 6:22.
 * LoveReading.
 */

public class RecyclerScrollListener extends RecyclerView.OnScrollListener {

    private ScrollHandler mScrollHandler;
    private LinearLayoutManager mManager;

    public RecyclerScrollListener(ScrollHandler scrollHandler, LinearLayoutManager manager) {
        mScrollHandler = scrollHandler;
        mManager = manager;
    }

    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        if (newState == RecyclerView.SCROLL_STATE_IDLE) {
            int lastPosition = mManager.findLastCompletelyVisibleItemPosition();
            int itemCount = mManager.getItemCount();

            if (lastPosition == itemCount - 1) {
                mScrollHandler.loadMore();
            }
        }
    }
}
