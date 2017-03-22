package com.android.reading.data.bean;

/**
 * Created by Gu FanFan on 2017/3/20 23:41.
 * LoveReading.
 */

public abstract class BaseShowApiResBean {

    private int showapi_res_code;
    private String showapi_res_error;

    public int getShowapi_res_code() {
        return showapi_res_code;
    }

    public void setShowapi_res_code(int showapi_res_code) {
        this.showapi_res_code = showapi_res_code;
    }

    public String getShowapi_res_error() {
        return showapi_res_error;
    }

    public void setShowapi_res_error(String showapi_res_error) {
        this.showapi_res_error = showapi_res_error;
    }
}
