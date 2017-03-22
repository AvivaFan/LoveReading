package com.android.reading.utils;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.BindingConversion;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.widget.ImageView;

import com.android.reading.R;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Gu FanFan on 2017/3/2 13:28.
 * Reading 工具类.
 */

public class Utils {

    public static boolean isEmpty(Object o) {
        if (o instanceof String) {
            return TextUtils.isEmpty((String) o);
        } else {
            return o == null;
        }
    }

    public static boolean isEmpty(List<?> objects) {
        return objects == null || objects.size() == 0;
    }

    public static boolean hasJellyBean() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN;
    }

    public static boolean hasKitKat() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;
    }

    public static boolean hasLollipop() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP;
    }

    /**
     * 获取新闻时间和来源
     *
     * @return Time + Author
     */
    public static String getNewsInfo(String time, String author) {
        return author + "  " + time;
    }

    @BindingAdapter("imageUrl")
    public static void loadImage(ImageView imageView, String imageUrl) {
        Glide.with(imageView.getContext())
                .load(imageUrl)
                .centerCrop()
                .placeholder(R.drawable.ic_placeholder)
                .crossFade()
                .into(imageView);
    }

    @BindingConversion
    public static ColorDrawable convertColorToDrawable(int color) {
        return new ColorDrawable(color);
    }

    public static String getString(Context context, int resId) {
        return context.getString(resId);
    }

    public static String getInterceptString(String string) {
        if (string.contains("焦点") || string.contains("最新")) {
            return string.substring(0, string.length() - 2);
        }
        return string;
    }
}
