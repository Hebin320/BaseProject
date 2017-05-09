package com.hebin.base;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Author Hebin
 * <p>
 * created at 2017/5/5 10:19
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * 说明：存储（读取、删除）数据到本地的方法
 */
public class BaseFile {

    /**
     * 记录（读取或者清除）基础用户信息
     */
    public static void saveUserData(Context context, String token, String userid, String cityid, String typeid, String version) {
        SharedPreferences preferences = context.getSharedPreferences("userdata", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("token", token);
        editor.putString("userid", userid);
        editor.putString("cityid", cityid);
        editor.putString("typeid", typeid);
        editor.putString("version", version);
        editor.apply();
    }

    public static void cleanUserData(Context context) {
        SharedPreferences preferences = context.getSharedPreferences("userdata", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove("token");
        editor.remove("userid");
        editor.remove("cityid");
        editor.remove("typeid");
        editor.remove("version");
        editor.remove("phone");
        editor.apply();
    }

    /**
     * 保存类型为字符串的数据到本地
     *
     * @param infoKey 保存数据的唯一标识，用于值的提取与清除
     * @param info    需要保存到本地的数据的值
     */
    public static void saveString(Context context, String infoKey, String info) {
        SharedPreferences preferences = context.getSharedPreferences("userdata", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(infoKey, info);
        editor.apply();
    }

    /**
     * 读取类型为“字符串”的本地数据
     *
     * @param infoKey 本地数据的唯一标识，用于值的提取
     * @param info    如果本地数据值为空，info则为默认提取的值
     */
    public static String loadString(Context context, String infoKey, String info) {
        SharedPreferences preferences = context.getSharedPreferences("userdata", Context.MODE_PRIVATE);
        return preferences.getString(infoKey, info);
    }

    /**
     * 保存类型为“布尔值”的数据到本地
     *
     * @param infoKey 保存数据的唯一标识，用于值的提取与清除
     * @param isTrue  需要保存到本地的数据的值
     */
    public static void saveBoolean(Context context, String infoKey, boolean isTrue) {
        SharedPreferences preferences = context.getSharedPreferences("userdata", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(infoKey, isTrue);
        editor.apply();
    }

    /**
     * 读取类型为“布尔值”的本地数据
     *
     * @param infoKey 本地数据的唯一标识，用于值的提取
     * @param isTrue  如果本地数据值为空，info则为默认提取的值
     */
    public static boolean loadBoolean(Context context, String infoKey, boolean isTrue) {
        SharedPreferences preferences = context.getSharedPreferences("userdata", Context.MODE_PRIVATE);
        return preferences.getBoolean(infoKey, isTrue);
    }

    /**
     * 保存类型为“整数”的数据到本地
     *
     * @param infoKey  保存数据的唯一标识，用于值的提取与清除
     * @param position 需要保存到本地的数据的值
     */
    public static void saveInt(Context context, String infoKey, int position) {
        SharedPreferences preferences = context.getSharedPreferences("userdata", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(infoKey, position);
        editor.apply();
    }

    /**
     * 读取类型为“整数”的本地数据
     *
     * @param infoKey  本地数据的唯一标识，用于值的提取
     * @param position 如果本地数据值为空，info则为默认提取的值
     */
    public static int loadInt(Context context, String infoKey, int position) {
        SharedPreferences preferences = context.getSharedPreferences("userdata", Context.MODE_PRIVATE);
        return preferences.getInt(infoKey, position);
    }
}
