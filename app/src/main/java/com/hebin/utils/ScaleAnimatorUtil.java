package com.hebin.utils;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
/**
 * Author Hebin
 * <p>
 * created at 2017/5/5 10:27
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * 说明：收藏与取消收藏的动画工具类
 */
public class ScaleAnimatorUtil extends SingletonUtil<ScaleAnimatorUtil> {

    /**
     * 设置缩放动画
     *
     * @param view
     */
    public static void setScalse(View view) {
        AnimatorSet set = new AnimatorSet();
        ObjectAnimator animator_x = ObjectAnimator.ofFloat(view, "scaleX", 1.5f, 1.2f, 1f, 0.5f, 0.7f,1f);
        ObjectAnimator animator_y = ObjectAnimator.ofFloat(view, "scaleY", 1.5f, 1.2f, 1f, 0.5f, 0.7f,1f);
        set.play(animator_x).with(animator_y);
        set.setDuration(500);
        set.start();
    }

    @Override
    protected ScaleAnimatorUtil newInstance() {
        return new ScaleAnimatorUtil().getInstance();
    }
}
