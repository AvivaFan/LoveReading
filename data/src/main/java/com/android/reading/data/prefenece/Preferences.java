package com.android.reading.data.prefenece;

import android.content.Context;
import android.content.SharedPreferences;

import com.android.reading.data.Constants;
import com.android.reading.data.bean.UserBean;

/**
 * Created by Gu FanFan on 2017/2/12 15:24.
 * Preferences 工具类.
 */

public class Preferences {

    private static Preferences sPreferences;
    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;

    public static synchronized Preferences newInstance(Context context) {
        if (sPreferences == null)
            sPreferences = new Preferences(context);

        return sPreferences;
    }

    private Preferences(Context context) {
        this.mPreferences = context.getSharedPreferences(Constants.SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE);
        mEditor = mPreferences.edit();
    }

    /**
     * 设置String类型的数据
     */
    public void putStringData(String key, String value) {
        mEditor.putString(key, value);
        mEditor.commit();
    }

    /**
     * 获取String类型的值
     */
    public String getStringData(String key, String defaultValue) {
        if (null == defaultValue) {
            return mPreferences.getString(key, null);
        } else {
            return mPreferences.getString(key, defaultValue);
        }
    }

    /**
     * 设置Boolean类型的数据
     */
    public void putBooleanData(String key, boolean value) {
        mEditor.putBoolean(key, value);
        mEditor.commit();
    }

    /**
     * 获取Boolean类型的值
     */
    public boolean getBooleanData(String key, boolean defaultValue) {
        return mPreferences.getBoolean(key, defaultValue);
    }

    /**
     * 设置Int类型的数据
     */
    public void putIntData(String key, int value) {
        mEditor.putInt(key, value);
        mEditor.commit();
    }

    /**
     * 获取Int类型的值
     */
    public int getIntData(String key, int defaultValue) {
        return mPreferences.getInt(key, defaultValue);
    }

    /**
     * 设置Long类型的数据
     */
    public void putLongData(String key, long value) {
        mEditor.putLong(key, value);
        mEditor.commit();
    }

    /**
     * 获取Long类型的值
     */
    public long getLongData(String key, long defaultValue) {
        return mPreferences.getLong(key, defaultValue);
    }

    /**
     * 根据key移除对应的value.
     *
     * @param key 移除value的key值
     */
    public void remove(String key) {
        mEditor.remove(key);
        mEditor.commit();
    }

    /**
     * 移除所以键值对
     */
    public void removeAll() {
        mEditor.clear();
        mEditor.commit();
    }

    /**
     * 判断某个key是否存在
     *
     * @param key Preference key.
     * @return true or false. true exist, false does not exist
     */
    public boolean contains(String key) {
        return mPreferences.contains(key);
    }

    public void putUserInfo(UserBean.User user) {
        putIntData(Constants.USER_ID, user.getId());
        putStringData(Constants.USER_NAME, user.getName());
        putStringData(Constants.USER_EMAIL, user.getEmail());
        putStringData(Constants.USER_PHONE, user.getPhone());
        putStringData(Constants.USER_PASSWORD, user.getPassword());
        putStringData(Constants.USER_REAL_NAME, user.getReal_name());
        putStringData(Constants.USER_DEVICE, user.getDevice());
        putStringData(Constants.USER_DEVICE, user.getDevice());
        putBooleanData(Constants.IS_LOGIN, true);
    }
}
