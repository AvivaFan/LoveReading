package com.android.reading.data.bean;

/**
 * Created by Gu FanFan on 2017/3/21 20:42.
 * LoveReading.
 */

public abstract class BaseAvivaResBean {

    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
