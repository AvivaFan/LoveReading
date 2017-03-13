package com.android.reading.interactive;

import com.android.reading.data.bean.JokeBean;
import com.android.reading.mapper.DataMapper;

/**
 * Created by Gu FanFan on 2017/3/11 8:07.
 * LoveReading.
 */

public class JokeObserver extends DefaultObserver<JokeBean>{
    public JokeObserver(ObserverCallback callback) {
        super(callback);
    }

    @Override
    public void onNext(JokeBean jokeBean) {
        super.onNext(jokeBean);
        mCallback.onNext(DataMapper.transFormJoke(jokeBean.getResult()));
    }
}
