package com.android.reading.interactive;

import com.android.reading.data.bean.NewsBean;
import com.android.reading.data.net.RequestApi;
import com.android.reading.mapper.DataMapper;

/**
 * Created by Gu FanFan on 2017/3/11 7:13.
 * LoveReading.
 */

public class NewsListObserver extends DefaultObserver<NewsBean> {

    public NewsListObserver(ObserverCallback callback) {
        super(callback);
    }

    @Override
    public void onNext(NewsBean newsBean) {
        super.onNext(newsBean);
        if (newsBean.getShowapi_res_code() == RequestApi.REQUEST_SUCCESS) {
            mCallback.onNext(DataMapper.transFormNews(newsBean.getShowapi_res_body().getPagebean()));
        } else {
            mCallback.onNext(newsBean.getShowapi_res_error());
        }
    }
}
