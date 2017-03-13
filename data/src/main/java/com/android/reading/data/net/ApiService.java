package com.android.reading.data.net;

import com.android.reading.data.bean.FeaturedBean;
import com.android.reading.data.bean.JokeBean;
import com.android.reading.data.bean.NewsBean;

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
}
