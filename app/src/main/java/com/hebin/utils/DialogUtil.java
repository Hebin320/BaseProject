package com.hebin.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.hebin.R;


/**
 * Author Hebin
 * <p>
 * created at 2017/5/5 10:27
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * 说明：居中显示的加载对话框的工具类
 */
public class DialogUtil extends SingletonUtil<DialogUtil> {

    private static Dialog progressDialog;


    //显示一个加载中的全屏对话框
    public static void showDialog(Context context) {
        if (progressDialog == null || !progressDialog.isShowing()) {
            progressDialog = new Dialog(context, R.style.dialog);
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();
            progressDialog.setContentView(R.layout.public_loading);
            LinearLayout layout = (LinearLayout) progressDialog.findViewById(R.id.ll_loading);
            layout.setVisibility(View.VISIBLE);
            Window window = progressDialog.getWindow();
            assert window != null;
            WindowManager.LayoutParams layoutParams = window.getAttributes();
            layoutParams.width = (int) (WindowsUtil.getSwidth((Activity) context) / 2.5);
            layoutParams.height = (int) (WindowsUtil.getSwidth((Activity) context) / 2.5);
            window.setGravity(Gravity.CENTER);
            window.setAttributes(layoutParams);
        }
    }

    //关闭progressdialog
    public static void closedialog() {
        if (progressDialog != null) {
            progressDialog.dismiss();
            progressDialog = null;
        }
    }


    @Override
    protected DialogUtil newInstance() {
        return new DialogUtil().getInstance();
    }
}
