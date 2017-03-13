package com.android.reading.data.net;

import android.content.Context;

import com.android.reading.data.R;
import com.android.reading.data.bean.FeaturedBean;
import com.android.reading.data.bean.JokeBean;
import com.android.reading.data.bean.NewsBean;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Created by Gu FanFan on 2017/3/2 20:45.
 * 访问接口实现类.
 */

public class RequestApiImpl {

    private ApiService mApiService;
    private String mFailure;
    private static RequestApiImpl sRequestApi;

    public static RequestApiImpl newInstance(Context context) {
        if (sRequestApi == null)
            sRequestApi = new RequestApiImpl(context);
        return sRequestApi;
    }

    private RequestApiImpl(Context context) {
        mFailure = context.getString(R.string.request_failure);
        Retrofit retrofit = ApiConnection.newInstance().getBaseRetrofit();
        mApiService = retrofit.create(ApiService.class);
    }

    public void getNewsList(String type, Observer<NewsBean> observer) {
        mApiService.getNewsList(type).subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }

    public void getJokeList(Observer<JokeBean> observer) {
        mApiService.getJokeList("").subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }

    public void getFeaturedList(int page, Observer<FeaturedBean> observer) {
        mApiService.getFeaturedList(page).subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }
}
