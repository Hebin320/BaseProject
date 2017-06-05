package com.hebin.widget.view.viewpager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
/**
 * Author Hebin
 * <p>
 * created at 2017/6/5 15:53
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * 说明：重写Viewpager，实现不可左右滑动的Viewpager
 */
public class DisableScrollViewpager extends ViewPager {

    private boolean isPagingEnabled = true;

    public DisableScrollViewpager(Context context) {
        super(context);
    }

    public DisableScrollViewpager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return this.isPagingEnabled && super.onTouchEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        return this.isPagingEnabled && super.onInterceptTouchEvent(event);
    }

    //设置该方法，即可实现Viewpager的不可滚动
    public void setPagingEnabled(boolean b) {
        this.isPagingEnabled = b;
    }
}
