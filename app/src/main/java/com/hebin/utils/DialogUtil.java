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
import com.hebin.superrecyclerview.recycleview.progressindicator.AVLoadingIndicatorView;

/**
 * Author Hebin
 * <p>
 * created at 2017/5/22 11:34
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * 说明：加载中的对话框
 */
public class DialogUtil extends SingletonUtil<DialogUtil> {

    private static Dialog progressDialog;

    @Override
    protected DialogUtil newInstance() {
        return new DialogUtil().getInstance();
    }


    //显示一个加载中的全屏对话框
    public static void showDialog(Context context) {
        if (progressDialog == null || !progressDialog.isShowing()) {
            progressDialog = new Dialog(context, R.style.dialog_dimenabled);
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();
            progressDialog.setContentView(R.layout.public_loading);
            LinearLayout layout = (LinearLayout) progressDialog.findViewById(R.id.ll_loading);
            layout.setVisibility(View.VISIBLE);
            AVLoadingIndicatorView avLoading = (AVLoadingIndicatorView) progressDialog.findViewById(R.id.av_loading);
            LinearLayout.LayoutParams loading = new LinearLayout.LayoutParams(WindowUtil.getSwidth((Activity) context) / 8,
                    WindowUtil.getSwidth((Activity) context) / 8);
            avLoading.setLayoutParams(loading);
            Window window = progressDialog.getWindow();
            assert window != null;
            WindowManager.LayoutParams layoutParams = window.getAttributes();
            layoutParams.width = (int) (WindowUtil.getSwidth((Activity) context) / 3.2);
            layoutParams.height = (int) (WindowUtil.getSwidth((Activity) context) / 3.2);
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


}
