package com.android.reading.data.net;

import com.android.reading.data.bean.ChannelListBean;
import com.android.reading.data.bean.FeaturedBean;
import com.android.reading.data.bean.JokeBean;
import com.android.reading.data.bean.NewsBean;
import com.android.reading.data.bean.RegisterBean;
import com.android.reading.data.bean.UserBean;
import com.android.reading.data.bean.UserChannelListBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Gu FanFan on 2017/3/7 4:04.
 * LoveReading.
 */

public interface ApiService {

    @FormUrlEncoded
    @POST(RequestApi.GET_NEWS_LIST)
    Observable<NewsBean> getNewsList(
            @Field("type") String type);

    @FormUrlEncoded
    @POST(RequestApi.GET_JOKE_LIST)
    Observable<JokeBean> getJokeList(
            @Field("type") String type);

    @FormUrlEncoded
    @POST(RequestApi.GET_FEATURED_LIST)
    Observable<FeaturedBean> getFeaturedList(
            @Field("pno") int page);

    @POST(RequestApi.GET_CHANNEL_LIST)
    Observable<ChannelListBean> getChannelList();

    @FormUrlEncoded
    @POST(RequestApi.GET_NEWS)
    Observable<NewsBean> getNews(@Field("channelId") String channelId,
                               @Field("channelName") String channelName,
                               @Field("page") String page);

    @FormUrlEncoded
    @POST(RequestApi.USER_LOGIN)
    Observable<UserBean> login(@Field("user_name") String user_name,
                               @Field("password") String password);

    @FormUrlEncoded
    @POST(RequestApi.USER_REGISTER)
    Observable<RegisterBean> register(@Field("user_name") String user_name,
                                      @Field("password") String password);

    @FormUrlEncoded
    @POST(RequestApi.USER_GET_CHANNEL_LIST)
    Observable<UserChannelListBean> getChannelList(@Field("userID") String userID);
}
