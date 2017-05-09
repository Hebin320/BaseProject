package com.hebin.utils;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

/**
 * Author Hebin
 * <p>
 * created at 2017/5/5 10:27
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * 说明：
 */
public class LostFocusUtil extends SingletonUtil<LostFocusUtil> {



    @Override
    protected LostFocusUtil newInstance() {
        return new LostFocusUtil().getInstance();
    }

    /**
     * 视图被触碰时，隐藏输入法
     *
     * @param viewGroup 布局
     */
    public static void lostByViewGroup(final Context context, final ViewGroup viewGroup) {
        viewGroup.setOnTouchListener((v, event) -> {
            InputMethodManager imm = (InputMethodManager)
                    context.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(viewGroup.getWindowToken(), 0);
            return false;
        });
    }

    /**
     * 视图被触碰时，隐藏输入法
     *
     * @param view 控件
     */

    public static void lostByView(final Context context, final View view) {
        view.setOnTouchListener((v, event) -> {
            InputMethodManager imm = (InputMethodManager)
                    context.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            return false;
        });
    }


    /**
     * 隐藏输入法
     *
     * @param view 控件
     */

    public static void hideImmByView(final Context context, final View view) {
        InputMethodManager imm = (InputMethodManager)
                context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }


    /**
     * 初始列表失去焦点
     *
     * @param viewGroup 布局
     */
    public static void listLostByViewGroup(ViewGroup viewGroup) {
        viewGroup.setFocusable(true);
        viewGroup.setFocusableInTouchMode(true);
        viewGroup.requestFocus();
    }

    /**
     * 初始列表失去焦点
     *
     * @param view 控件
     */
    public static void listLostByView(View view) {
        view.setFocusable(true);
        view.setFocusableInTouchMode(true);
        view.requestFocus();
    }

}
