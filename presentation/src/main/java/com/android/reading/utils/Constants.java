package com.android.reading.utils;

/**
 * Created by Gu FanFan on 2017/3/3 0:41.
 * 常量.
 */

public interface Constants {

    String BUNDLE_TYPE = "type";
    String BUNDLE_URL = "url";
    String BUNDLE_MODEL = "model";

    /** 新闻类别. */
    String NEWS_TOP = "top";
    String NEWS_SOCIETY = "shehui";
    String NEWS_DOMESTIC = "guonei";
    String NEWS_INTERNATIONAL = "guoji";
    String NEWS_ENTERTAINMENT = "yule";
    String NEWS_SPORTS = "tiyu";
    String NEWS_MILITARY = "junshi";
    String NEWS_TECHNOLOGY = "keji";
    String NEWS_FINANCE = "caijing";
    String NEWS_FASHION = "shishang";

    String [] NEWS_CATEGORY = {NEWS_TOP, NEWS_SOCIETY, NEWS_DOMESTIC, NEWS_INTERNATIONAL,
            NEWS_ENTERTAINMENT, NEWS_SPORTS, NEWS_MILITARY, NEWS_TECHNOLOGY, NEWS_FINANCE, NEWS_FASHION};

    /** 导航菜单TAG. */
    String NAV_NEWS = "news";
    String NAV_JOKE = "joke";
    String NAV_BOOK = "book";
    String NAV_CALENDAR = "calendar";
    String NAV_FEATURED = "featured";
    String NAV_COLLECTION = "collection";
    String NAV_SETTINGS = "settings";
    String NAV_ABOUT = "about";
}
