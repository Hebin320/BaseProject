package com.hebin.utils;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.hebin.R;

/**
 * Author Hebin
 * <p>
 * created at 2017/5/5 10:28
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * 说明：
 */
public class ToastUtil extends SingletonUtil<ToastUtil> {

    /**
     * 之前显示的内容
     */
    private static String oldMsg;
    /**
     * Toast对象
     */
    private static Toast toast = null;
    /**
     * 第一次时间
     */
    private static long oneTime = 0;
    /**
     * 第二次时间
     */
    private static long twoTime = 0;

    @Override
    protected ToastUtil newInstance() {
        return new ToastUtil().getInstance();
    }


    /**
     * 显示输入文本的Toast
     */
    public static void showToast(Context context, String string) {
        View toastRoot = LayoutInflater.from(context).inflate(R.layout.layout_simple_toast, null);
        TextView textView = (TextView) toastRoot.findViewById(R.id.tv_toast);
        textView.setText(string);
        if (toast == null) {
            toast = Toast.makeText(context, string, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.setView(toastRoot);
            toast.show();
            oneTime = System.currentTimeMillis();
        } else {
            twoTime = System.currentTimeMillis();
            if (string.equals(oldMsg)) {
                if (twoTime - oneTime > Toast.LENGTH_SHORT) {
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.setView(toastRoot);
                    toast.show();
                }
            } else {
                oldMsg = string;
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.setView(toastRoot);
                toast.show();
            }
        }
        oneTime = twoTime;
    }

    /**
     * 全局静态网络连接失败时的Toast
     */
    public static void showErro(Context context) {
        showToast(context, "请检查你的网络连接");
    }

    /**
     * 获取失败，请稍后重试的Toast
     */
    public static void showGetFail(Context context) {
        showToast(context, "获取失败，请稍后重试");
    }

    /**
     * 打印数据
     */
    public static void printData(String string) {
        System.out.println("Hebin" + string);
    }

}
