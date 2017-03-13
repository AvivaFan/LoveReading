package com.android.reading.data.net;

/**
 * Created by Gu FanFan on 2017/3/2 20:45.
 * LoveReading.
 */

public interface RequestApi {

    String BASE_HOST = "http://v.juhe.cn/";

    long TIME_OUT = 20;
    int REQUEST_SUCCESS = 0;

    String GET_NEWS_LIST = "toutiao/index?key=1ce24b9aaf3267574cb5d1944061ee43";
    String GET_JOKE_LIST = "joke/randJoke.php?&key=8ea3b09aa80b39f7446fa9c9b0a362f6";
    String GET_FEATURED_LIST = "weixin/query?ps=15&key=f85fa4bc4f50f0302122b0f256392b92";
}
