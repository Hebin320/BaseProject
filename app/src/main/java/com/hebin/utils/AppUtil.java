package com.hebin.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.telephony.TelephonyManager;

import com.hebin.base.BaseFile;


/**
 * Author Hebin
 * <p>
 * created at 2017/5/17
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * 说明：
 */
public class AppUtil extends SingletonUtil<AppUtil> {
    @Override
    protected AppUtil newInstance() {
        return new AppUtil().getInstance();
    }

    /**
     * 获取唯一机械码
     */
    public static String getImei(Context context, String imei) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            imei = telephonyManager.getDeviceId();
        } catch (Exception ignored) {
        }
        return imei;
    }

    /**
     * 获取版本名称
     */
    public static String getVersion(Context context) {
        try {
            PackageInfo manager = context.getPackageManager().getPackageInfo(
                    context.getPackageName(), 0);
            return manager.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            return "Unknown";
        }
    }

    /**
     * 获取版本号
     */
    public static int getlocalVersion(Context context) {
        int localversion = 0;
        try {
            PackageInfo info = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            localversion = info.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return localversion;
    }

    /**
     * 登录失败的操作
     */

    public static void checkLoad(Context context, String info) {
        if (info.contains("授权信息错误") || info.contains("请重新登录") || info.contains("授权参数错误")) {
//            BaseFile.cleanUserData(context);
//            ToastUtil.showToast(context, info);
//            Intent intent = new Intent();
//            intent.setClass(context, LoginActivity.class);
//            intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
//            context.startActivity(intent);
//            Activity activity = (Activity) context;
//            activity.finish();
        }
    }


}
