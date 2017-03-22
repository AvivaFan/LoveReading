package com.android.reading.interactive;

import com.android.reading.data.bean.RegisterBean;
import com.android.reading.data.net.RequestApi;

/**
 * Created by Gu FanFan on 2017/3/21 20:46.
 * LoveReading.
 */

public class RegisterObserver extends DefaultObserver<RegisterBean> {
    public RegisterObserver(ObserverCallback callback) {
        super(callback);
    }

    @Override
    public void onNext(RegisterBean baseAvivaResBean) {
        super.onNext(baseAvivaResBean);
        if (baseAvivaResBean.getCode() == RequestApi.REQUEST_SUCCESS) {
            mCallback.onNext(baseAvivaResBean.getMsg());
        } else {
            mCallback.onError(baseAvivaResBean.getMsg());
        }
    }
}
