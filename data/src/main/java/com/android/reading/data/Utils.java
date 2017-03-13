package com.android.reading.data;

import android.content.Context;
import android.text.TextUtils;

import com.android.reading.data.bean.ColorBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gu FanFan on 2017/3/2 13:28.
 * Reading Data 工具类.
 */

public class Utils {

    public static boolean isEmpty(Object o) {
        if (o instanceof String) {
            return TextUtils.isEmpty((String) o);
        } else {
            return o == null;
        }
    }

    public static List<ColorBean> getColorList(Context context) {
        List<ColorBean> colorBeen = new ArrayList<>();

        return colorBeen;
    }
}
