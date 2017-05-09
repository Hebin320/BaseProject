package com.hebin.custom.view.cardview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;

import com.hebin.R;


/**
 * Author Hebin
 * <p>
 * created at 2017/5/5 10:23
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * 说明：重写CardView，解决CardView在5.0以下版本，出现边距的问题
 */
public class MyCardView extends CardView {

    public MyCardView(Context context) {
        super(context);
        setElevation(null);
    }

    public MyCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setElevation(attrs);
    }

    public MyCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setElevation(attrs);
    }

    /**
     * Android 5.0以上，设置阴影面积为10dp
     * <p>
     * Android5.0以下，设置阴影面积为0dp
     */
    public void setElevation(AttributeSet attrs) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            @SuppressLint("Recycle") TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.MyCardView);
            this.setCardElevation(a.getDimensionPixelOffset(R.styleable.MyCardView_card_elevation, (int) getResources().getDimension(R.dimen.dp_10)));
        } else {
            this.setCardElevation(getResources().getDimension(R.dimen.dp_0));
        }
    }


}
