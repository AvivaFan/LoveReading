package com.android.reading.interactive;

import com.android.reading.data.bean.ChannelListBean;
import com.android.reading.data.net.RequestApi;
import com.android.reading.mapper.DataMapper;

/**
 * Created by Gu FanFan on 2017/3/20 13:09.
 * LoveReading.
 */

public class ChannelListObserver extends DefaultObserver<ChannelListBean> {

    public ChannelListObserver(ObserverCallback callback) {
        super(callback);
    }

    @Override
    public void onNext(ChannelListBean channelListBean) {
        if (channelListBean.getShowapi_res_code() == RequestApi.REQUEST_SUCCESS) {
            mCallback.onNext(DataMapper.
                    transFormChannelList(channelListBean.getShowapi_res_body().getChannelList()));
        } else {
            mCallback.onError(channelListBean.getShowapi_res_error());
        }
    }
}
