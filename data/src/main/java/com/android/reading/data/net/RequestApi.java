package com.android.reading.data.net;

/**
 * Created by Gu FanFan on 2017/3/2 20:45.
 * LoveReading.
 */

public interface RequestApi {

    String BASE_HOST = "http://route.showapi.com/";
    String AVIVA_FAN_HOST = "http://www.gufanfan.cc/index.php/Home/";
    String SHOW_API_ID = "33775";
    String SHOW_API_SIGN = "283e6a144a094cd3bf23d1781dec0c93";

    long TIME_OUT = 20;
    int REQUEST_SUCCESS = 0;

    String USER_LOGIN = "Login/login";
    String USER_REGISTER = "Login/register";
    String USER_GET_CHANNEL_LIST = "Favorite/getChannelList";
    String USER_SUBSCRIPTION_CHANNEL = "Favorite/subscription";

    String GET_NEWS_LIST = "toutiao/index?key=1ce24b9aaf3267574cb5d1944061ee43";
    String GET_JOKE_LIST = "joke/randJoke.php?&key=8ea3b09aa80b39f7446fa9c9b0a362f6";
    String GET_FEATURED_LIST = "weixin/query?ps=15&key=f85fa4bc4f50f0302122b0f256392b92";

    String GET_CHANNEL_LIST = "109-34?showapi_appid=" + SHOW_API_ID +
            "&showapi_sign=" + SHOW_API_SIGN;
    String GET_NEWS = "109-35?showapi_appid=" + SHOW_API_ID +
            "&showapi_sign=" + SHOW_API_SIGN + "&needAllList=1&maxResult=10";
}
