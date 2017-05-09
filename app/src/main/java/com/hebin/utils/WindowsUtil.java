package com.hebin.utils;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;

import java.lang.reflect.Method;

/**
 * Author Hebin
 * <p>
 * created at 2017/5/5 10:28
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * 说明：关于屏幕的一些方法工具类
 */
public class WindowsUtil extends SingletonUtil<WindowsUtil> {

    @Override
    protected WindowsUtil newInstance() {
        return new WindowsUtil().getInstance();
    }

    /**
     * 获取状态栏高度
     */
    public static int getStatusbar(Activity activity) {
        int high = 0;
        Rect rectangle = new Rect();
        Window window = activity.getWindow();
        window.getDecorView().getWindowVisibleDisplayFrame(rectangle);
        high = rectangle.top;
        return high;
    }

    /**
     * 获取屏幕宽度
     */
    public static int getSwidth(Activity activity) {
        int realWidth = 0;
        try {
            Display display = activity.getWindowManager().getDefaultDisplay();
            DisplayMetrics metrics = new DisplayMetrics();
            display.getMetrics(metrics);
            if (android.os.Build.VERSION.SDK_INT >= 17) {
                Point size = new Point();
                display.getRealSize(size);
                realWidth = size.x;
            } else if (Build.VERSION.SDK_INT < 17) {
                Method mGetRawW = Display.class.getMethod("getRawWidth");
                realWidth = (Integer) mGetRawW.invoke(display);
            } else {
                realWidth = metrics.widthPixels;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return realWidth;
    }

    /**
     * 获取屏幕高度
     */
    public static int getShigh(Activity activity) {
        int realHeight = 0;
        try {
            Display display = activity.getWindowManager().getDefaultDisplay();
            DisplayMetrics metrics = new DisplayMetrics();
            display.getMetrics(metrics);
            if (android.os.Build.VERSION.SDK_INT >= 17) {
                Point size = new Point();
                display.getRealSize(size);
                realHeight = size.y;
            } else if (Build.VERSION.SDK_INT < 17) {
                Method mGetRawH = Display.class.getMethod("getRawHeight");
                realHeight = (Integer) mGetRawH.invoke(display);
            } else {
                realHeight = metrics.heightPixels;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return realHeight;
    }


    /**
     * 全屏显示
     * 此方法写在setContentView之前
     */
    public static void setFullScreen(Activity activity) {
        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }


}
