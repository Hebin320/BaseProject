package com.hebin.custom.view.edittext;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.TextView;
/**
 * Author Hebin
 * <p>
 * created at 2017/5/5 10:23
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * 说明：重写EditText，实现输入框剩余字数的功能
 */
@SuppressLint("AppCompatCustomView")
public class RemainingEditText extends EditText {

    public RemainingEditText(Context context) {
        super(context);
    }

    public RemainingEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RemainingEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private TextView remainingText;
    private int number;

    /**
     * 实现动态监听输入框的文本变化
     *
     * @param remainingText 显示剩余字数的文本框
     * @param number        总字数
     */
    public void setTextWatcher(TextView remainingText, int number) {
        this.remainingText = remainingText;
        this.number = number;
        this.addTextChangedListener(textWatcher);
    }

    TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            int count = number - charSequence.length();
            remainingText.setText(count + "");
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

}
