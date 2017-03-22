package com.android.reading.interactive;

import com.android.reading.data.bean.UserChannelListBean;
import com.android.reading.data.net.RequestApi;
import com.android.reading.mapper.DataMapper;

/**
 * Created by Gu FanFan on 2017/3/21 23:51.
 * LoveReading.
 */

public class UserChannelListObserver extends DefaultObserver<UserChannelListBean>{
    public UserChannelListObserver(ObserverCallback callback) {
        super(callback);
    }

    @Override
    public void onNext(UserChannelListBean userChannelListBean) {
        super.onNext(userChannelListBean);
        if (userChannelListBean.getCode() == RequestApi.REQUEST_SUCCESS) {
            mCallback.onNext(DataMapper.transFormUserChannelList(userChannelListBean.getData()));
        } else {
            mCallback.onError(userChannelListBean.getMsg());
        }
    }
}
