package com.android.reading.data.net;

import com.android.reading.data.bean.RegisterBean;
import com.android.reading.data.bean.UserBean;
import com.android.reading.data.bean.UserChannelListBean;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Created by Gu FanFan on 2017/3/21 19:44.
 * LoveReading.
 */

public class UserRequestApiImpl {

    private static UserRequestApiImpl sRequestApi;
    private ApiService mApiService;

    public static UserRequestApiImpl newInstance() {
        if (sRequestApi == null)
            sRequestApi = new UserRequestApiImpl();
        return sRequestApi;
    }

    public UserRequestApiImpl() {
        Retrofit retrofit = ApiConnection.newInstance().getAvivaFanRetrofit();
        mApiService = retrofit.create(ApiService.class);
    }

    public void login(String name, String password, Observer<UserBean> observer) {
        mApiService.login(name, password).subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }

    public void register(String name, String password, Observer<RegisterBean> observer) {
        mApiService.register(name, password).subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }

    public void getChannelList(String userID, Observer<UserChannelListBean> observer) {
        mApiService.getChannelList(userID).subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }
}
