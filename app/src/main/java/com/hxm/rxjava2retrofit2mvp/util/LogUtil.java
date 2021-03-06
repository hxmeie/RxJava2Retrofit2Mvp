package com.hxm.rxjava2retrofit2mvp.util;

import android.util.Log;

import com.hxm.rxjava2retrofit2mvp.BuildConfig;


/**
 * Created by hxm on 2017/4/24.
 * 描述：
 */
public class LogUtil {

    private static final String TAG = "guang_xi";
    public static boolean isDebug = BuildConfig.DEBUG;// 是否需要打印bug

    private LogUtil() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    // 下面5个是默认tag的函数
    public static void i(String msg) {
        if (isDebug)
            Log.i(TAG, msg);
    }

    public static void d(String msg) {
        if (isDebug)
            Log.d(TAG, msg);
    }

    public static void e(String msg) {
        if (isDebug)
            Log.e(TAG, msg);
    }

    public static void v(String msg) {
        if (isDebug)
            Log.v(TAG, msg);
    }

    public static void w(String msg) {
        if (isDebug)
            Log.w(TAG, msg);
    }

    // 下面是传入自定义tag的函数
    public static void i(String tag, String msg) {
        if (isDebug)
            try {
                Log.i(tag, msg);
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    public static void d(String tag, String msg) {
        if (isDebug)
            Log.d(tag, msg);
    }

    public static void e(String tag, String msg) {
        if (isDebug)
            Log.e(tag, msg);
    }

    public static void v(String tag, String msg) {
        if (isDebug)
            Log.v(tag, msg);
    }

    public static void w(String tag, String msg) {
        if (isDebug)
            Log.w(tag, msg);
    }

    /**
     * 分段打印出较长log文本
     *
     * @param logContent 打印文本
     * @param showLength 规定每段显示的长度（AndroidStudio控制台打印log的最大信息量大小为4k）
     * @param tag        打印log的标记
     */
    public static void showLargeLog(String tag, String logContent, int showLength) {
        if (logContent.length() > showLength) {
            String show = logContent.substring(0, showLength);
            i(tag, show);
            /*剩余的字符串如果大于规定显示的长度，截取剩余字符串进行递归，否则打印结果*/
            if ((logContent.length() - showLength) > showLength) {
                String partLog = logContent.substring(showLength, logContent.length());
                showLargeLog(tag, partLog, showLength);
            } else {
                String printLog = logContent.substring(showLength, logContent.length());
                i(tag, printLog);
            }

        } else {
            i(tag, logContent);
        }
    }

}
