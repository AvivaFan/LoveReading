package com.android.reading.interactive;

import com.android.reading.data.bean.FeaturedBean;
import com.android.reading.mapper.DataMapper;

/**
 * Created by Gu FanFan on 2017/3/11 7:56.
 * LoveReading.
 */

public class FeaturedObserver extends DefaultObserver<FeaturedBean> {

    public FeaturedObserver(ObserverCallback callback) {
        super(callback);
    }

    @Override
    public void onNext(FeaturedBean featuredBean) {
        super.onNext(featuredBean);
        mCallback.onNext(DataMapper.transFormFeatured(featuredBean.getResult().getList()));
    }
}
