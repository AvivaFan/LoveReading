package com.android.reading.interactive;

import com.android.reading.data.bean.UserBean;
import com.android.reading.data.net.RequestApi;
import com.android.reading.mapper.DataMapper;

/**
 * Created by Gu FanFan on 2017/3/21 20:01.
 * LoveReading.
 */

public class UserObserver extends DefaultObserver<UserBean> {
    public UserObserver(ObserverCallback callback) {
        super(callback);
    }

    @Override
    public void onNext(UserBean userBean) {
        super.onNext(userBean);
        if (userBean.getCode() == RequestApi.REQUEST_SUCCESS) {
            mCallback.onNext(DataMapper.transFormUser(userBean.getData()));
        } else {
            mCallback.onError(userBean.getMsg());
        }
    }
}
