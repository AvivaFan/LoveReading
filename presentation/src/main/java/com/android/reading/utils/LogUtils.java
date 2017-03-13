package com.android.reading.utils;

import android.util.Log;

/**
 * Created by Gu FanFan on 2017/3/6 16:44.
 * LoveReading.
 */

public class LogUtils {

    //是否调试模式  正式需要变为false
    private static final boolean DEBUG_MODE = true;
    private static final boolean DEBUG_SYS_OUT = true;

    /**
     * Don't let anyone instantiate this class.
     */
    private LogUtils() {
        throw new Error("Do not need instantiate!");
    }

    public static void v(Object obj) {
        if (DEBUG_MODE) {
            String tag = getClassName();
            String msg = obj != null ? obj.toString() : "obj == null";
            Log.v(tag, msg);
        }
    }

    public static void d(Object obj) {
        if (DEBUG_MODE) {
            String tag = getClassName();
            String msg = obj != null ? obj.toString() : "obj == null";
            Log.d(tag, msg);
        }
    }

    public static void i(Object obj) {
        if (DEBUG_MODE) {
            String tag = getClassName();
            String msg = obj != null ? obj.toString() : "obj == null";
            Log.i(tag, msg);
        }
    }

    public static void w(Object obj) {
        if (DEBUG_MODE) {
            String tag = getClassName();
            String msg = obj != null ? obj.toString() : "obj == null";
            Log.w(tag, msg);
        }
    }

    public static void e(Object obj) {
        if (DEBUG_MODE) {
            String tag = getClassName();
            String msg = obj != null ? obj.toString() : "obj == null";
            Log.e(tag, msg);
        }
    }

    public static void wtf(Object obj) {
        if (DEBUG_MODE) {
            String tag = getClassName();
            String msg = obj != null ? obj.toString() : "obj == null";
            Log.wtf(tag, msg);
        }
    }

    public static void v(String tag, String msg) {
        if (DEBUG_MODE)
            Log.v(tag, msg);
    }

    public static void d(String tag, String msg) {
        if (DEBUG_MODE)
            Log.d(tag, msg);
    }

    public static void i(String tag, String msg) {
        if (DEBUG_MODE)
            Log.i(tag, msg);
    }

    public static void w(String tag, String msg) {
        if (DEBUG_MODE)
            Log.w(tag, msg);
    }

    public static void e(String tag, String msg) {
        if (DEBUG_MODE)
            Log.e(tag, msg);
    }

    public static void wtf(String tag, String msg) {
        if (DEBUG_MODE)
            Log.wtf(tag, msg);
    }

    public static void print() {
        if (DEBUG_MODE) {
            String tag = getClassName();
            String method = callMethodAndLine();
            Log.v(tag, method);
            if (DEBUG_SYS_OUT) {
                System.out.println(tag + "  " + method);
            }
        }
    }

    public static void print(Object object) {
        if (DEBUG_MODE) {
            String tag = getClassName();
            String method = callMethodAndLine();
            String content = "";
            if (object != null) {
                content = object.toString() + "                    ----    "
                        + method;
            } else {
                content = " ## " + "                ----    " + method;
            }
            Log.d(tag, content);
            if (DEBUG_SYS_OUT) {
                System.out.println(tag + "  " + content + "  " + method);
            }
        }
    }

    public static void printError(Object object) {
        if (DEBUG_MODE) {
            String tag = getClassName();
            String method = callMethodAndLine();
            String content = "";
            if (object != null) {
                content = object.toString() + "                    ----    "
                        + method;
            } else {
                content = " ## " + "                    ----    " + method;
            }
            Log.e(tag, content);
            if (DEBUG_SYS_OUT) {
                System.err.println(tag + "  " + method + "  " + content);
            }
        }
    }

    public static void printCallHierarchy() {
        if (DEBUG_MODE) {
            String tag = getClassName();
            String method = callMethodAndLine();
            String hierarchy = getCallHierarchy();
            Log.v(tag, method + hierarchy);
            if (DEBUG_SYS_OUT) {
                System.out.println(tag + "  " + method + hierarchy);
            }
        }
    }


    private static String getCallHierarchy() {
        String result = "";
        StackTraceElement[] trace = (new Exception()).getStackTrace();
        for (int i = 2; i < trace.length; i++) {
            result += "\r\t" + trace[i].getClassName() + ""
                    + trace[i].getMethodName() + "():"
                    + trace[i].getLineNumber();
        }
        return result;
    }

    private static String getClassName() {
        String result = "";
        StackTraceElement thisMethodStack = (new Exception()).getStackTrace()[2];
        result = thisMethodStack.getClassName();
        return result;
    }

    private static String callMethodAndLine() {
        String result = "at ";
        StackTraceElement thisMethodStack = (new Exception()).getStackTrace()[2];
        result += thisMethodStack.getClassName() + "";
        result += thisMethodStack.getMethodName();
        result += "(" + thisMethodStack.getFileName();
        result += ":" + thisMethodStack.getLineNumber() + ")  ";
        return result;
    }
}
