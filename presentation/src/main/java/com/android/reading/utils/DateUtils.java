package com.android.reading.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Gu FanFan on 2017/2/15 22:43.
 * Brief.
 */

public class DateUtils {

    /*
    *                          HH:mm    15:44
    *                         h:mm a    3:44 下午
    *                        HH:mm z    15:44 CST
    *                        HH:mm Z    15:44 +0800
    *                     HH:mm zzzz    15:44 中国标准时间
    *                       HH:mm:ss    15:44:40
    *                     yyyy-MM-dd    2016-08-12
    *               yyyy-MM-dd HH:mm    2016-08-12 15:44
    *            yyyy-MM-dd HH:mm:ss    2016-08-12 15:44:40
    *       yyyy-MM-dd HH:mm:ss zzzz    2016-08-12 15:44:40 中国标准时间
    *  EEEE yyyy-MM-dd HH:mm:ss zzzz    星期五 2016-08-12 15:44:40 中国标准时间
    *       yyyy-MM-dd HH:mm:ss.SSSZ    2016-08-12 15:44:40.461+0800
    *     yyyy-MM-dd'T'HH:mm:ss.SSSZ    2016-08-12T15:44:40.461+0800
    *   yyyy.MM.dd G 'at' HH:mm:ss z    2016.08.12 公元 at 15:44:40 CST
    *                         K:mm a    3:44 下午
    *               EEE, MMM d, ''yy    星期五, 八月 12, '16
    *          hh 'o''clock' a, zzzz    03 o'clock 下午, 中国标准时间
    *   yyyyy.MMMMM.dd GGG hh:mm aaa    02016.八月.12 公元 03:44 下午
    *     EEE, d MMM yyyy HH:mm:ss Z    星期五, 12 八月 2016 15:44:40 +0800
    *                  yyMMddHHmmssZ    160812154440+0800
    *     yyyy-MM-dd'T'HH:mm:ss.SSSZ    2016-08-12T15:44:40.461+0800
    * EEEE 'DATE('yyyy-MM-dd')' 'TIME('HH:mm:ss')' zzzz    星期五 DATE(2016-08-12) TIME(15:44:40) 中国标准时间
    * </pre>
    * 注意：SimpleDateFormat不是线程安全的，线程安全需用{@code ThreadLocal<SimpleDateFormat>}
    */
    public static final String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String YMD_E_PATTERN = "yyyy-MM-dd, EEEE";
    public static final String HMS_PATTERN = "HH:mm:ss";
    public static final String AKM_PATTERN = "a K:mm ";
    public static final String MD_E = "MM-dd EEEE";

    /**
     * 将时间戳转为时间字符串
     * <p>格式为yyyy-MM-dd HH:mm:ss</p>
     *
     * @param millis 毫秒时间戳
     * @return 时间字符串
     */
    public static String millis2String(long millis) {
        return new SimpleDateFormat(DEFAULT_PATTERN, Locale.getDefault()).format(new Date(millis));
    }

    /**
     * 将时间戳转为时间字符串
     * 格式为pattern
     *
     * @param millis  毫秒时间戳
     * @param pattern 时间格式
     * @return 时间字符串
     */
    public static String millis2String(long millis, String pattern) {
        return new SimpleDateFormat(pattern, Locale.getDefault()).format(new Date(millis));
    }

    /**
     * 将时间字符串转为时间戳
     * <p>time格式为yyyy-MM-dd HH:mm:ss</p>
     *
     * @param time 时间字符串
     * @return 毫秒时间戳
     */
    public static long string2Millis(String time) {
        return string2Millis(time, DEFAULT_PATTERN);
    }

    /**
     * 将时间字符串转为时间戳
     * <p>time格式为pattern</p>
     *
     * @param time    时间字符串
     * @param pattern 时间格式
     * @return 毫秒时间戳
     */
    public static long string2Millis(String time, String pattern) {
        try {
            return new SimpleDateFormat(pattern, Locale.getDefault()).parse(time).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * 将时间字符串转为Date类型
     * <p>time格式为yyyy-MM-dd HH:mm:ss</p>
     *
     * @param time 时间字符串
     * @return Date类型
     */
    public static Date string2Date(String time) {
        return string2Date(time, DEFAULT_PATTERN);
    }

    /**
     * 将时间字符串转为Date类型
     * <p>time格式为pattern</p>
     *
     * @param time    时间字符串
     * @param pattern 时间格式
     * @return Date类型
     */
    public static Date string2Date(String time, String pattern) {
        return new Date(string2Millis(time, pattern));
    }

    /**
     * 获取星期
     * <p>time格式为yyyy-MM-dd HH:mm:ss</p>
     *
     * @param time 时间字符串
     * @return 星期
     */
    public static String getWeek(String time) {
        return getWeek(string2Date(time, DEFAULT_PATTERN));
    }

    /**
     * 获取星期
     * <p>time格式为pattern</p>
     *
     * @param time    时间字符串
     * @param pattern 时间格式
     * @return 星期
     */
    public static String getWeek(String time, String pattern) {
        return getWeek(string2Date(time, pattern));
    }

    /**
     * 获取星期
     *
     * @param date Date类型时间
     * @return 星期
     */
    public static String getWeek(Date date) {
        return new SimpleDateFormat("EEEE", Locale.getDefault()).format(date);
    }

    /**
     * 获取日期
     * <p>time格式为yyyy-MM-dd HH:mm:ss</p>
     *
     * @param time 时间字符串
     * @return 日期
     */
    public static String getDay(String time) {
        return getWeek(string2Date(time, DEFAULT_PATTERN));
    }

    /**
     * 获取日期
     * <p>time格式为pattern</p>
     *
     * @param time    时间字符串
     * @param pattern 时间格式
     * @return 日期
     */
    public static String getDay(String time, String pattern) {
        return getDay(string2Date(time, pattern));
    }

    /**
     * 获取星期
     *
     * @param date Date类型时间
     * @return 星期
     */
    public static String getDay(Date date) {
        return new SimpleDateFormat("dd", Locale.getDefault()).format(date);
    }

    /**
     * 获取星期
     *
     * @param millis 毫秒时间戳
     * @return 星期
     */
    public static String getWeek(long millis) {
        return getWeek(new Date(millis));
    }

    public static int getDay(long time) {
        Calendar calendar = Calendar.getInstance();

        calendar.setTimeInMillis(time);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }
}
