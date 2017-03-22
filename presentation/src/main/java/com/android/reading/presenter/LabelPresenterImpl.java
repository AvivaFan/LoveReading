package com.android.reading.presenter;

import android.content.Context;

import com.android.reading.R;
import com.android.reading.data.net.RequestApiImpl;
import com.android.reading.data.net.UserRequestApiImpl;
import com.android.reading.interactive.ChannelListObserver;
import com.android.reading.interactive.ObserverCallback;
import com.android.reading.interactive.UserChannelListObserver;
import com.android.reading.utils.LogUtils;
import com.android.reading.utils.Utils;
import com.android.reading.view.BaseView;

import java.util.List;

/**
 * Created by Gu FanFan on 2017/3/20 13:22.
 * LoveReading.
 */

public class LabelPresenterImpl implements LabelPresenter, ObserverCallback {

    private Context mContext;
    private BaseView mView;
    private RequestApiImpl mRequestApi;
    private UserRequestApiImpl mUserRequestApi;

    public LabelPresenterImpl(Context context, BaseView view) {
        this.mContext = context;
        this.mView = view;
        this.mRequestApi = RequestApiImpl.newInstance();
        this.mUserRequestApi = UserRequestApiImpl.newInstance();
    }

    @Override
    public void getAllChannelList() {
        mView.showLoadingView();
        mRequestApi.getChannelList(new ChannelListObserver(this));
    }

    @Override
    public void getFavoriteList(int id, boolean isFirst) {
        if (isFirst)
            mView.showLoadingView();
        mUserRequestApi.getChannelList(String.valueOf(id), new UserChannelListObserver(this));
    }

    @Override
    public void getMineList() {

    }

    @Override
    public void onComplete() {
    }

    @Override
    public void onNext(Object o) {
    }

    @Override
    public void onNext(List<?> objects) {
        mView.dismissLoadingView();
        if (objects != null) {
            mView.showData(objects);
        } else {
            mView.showEmptyView(Utils.getString(mContext, R.string.not_data));
        }
    }

    @Override
    public void onError(String msg) {
        mView.dismissLoadingView();
        mView.showMsg(msg);
    }

    @Override
    public void getDataList(Object o) {
        if (o.equals(
                Utils.getString(mContext, R.string.all_label))) {
            getAllChannelList();
        } else if (o.equals(Utils.getString(mContext, R.string.favorite_label))) {
            getFavoriteList(0, false);
        } else if (o.equals(Utils.getString(mContext, R.string.mine))) {
            getMineList();
        }
    }

    @Override
    public void onDestroy() {
        mUserRequestApi = null;
        mRequestApi = null;
    }
}
