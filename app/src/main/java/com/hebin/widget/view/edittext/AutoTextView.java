package com.hebin.widget.view.edittext;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Author Hebin
 * <p>
 * created at 2017/6/5 15:32
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * 说明：跑马灯效果的TextView
 */
public class AutoTextView extends TextView {

	public AutoTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);

	}

	public AutoTextView(Context context, AttributeSet attrs) {
		super(context, attrs);

	}

	public AutoTextView(Context context) {
		super(context);

	}
	@Override

	public boolean isFocused() {
		return true;
	}

}
