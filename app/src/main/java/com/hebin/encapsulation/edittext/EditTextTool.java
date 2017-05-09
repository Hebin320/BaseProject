package com.hebin.encapsulation.edittext;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
/**
 * Author Hebin
 * <p>
 * created at 2017/5/5 10:24
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * 说明：EditText的一些方法的封装
 */
public class EditTextTool {

    private static EditTextTool instance;

    public static EditTextTool getInstance() {
        if (instance == null) {
            synchronized (EditTextTool.class) {
                if (instance == null) {
                    instance = new EditTextTool();
                }
            }
        }
        return instance;
    }


    /**
     * 显示、隐藏EditText的内容
     *
     * @param checkBox 眼睛图标
     * @param editText 文本框
     */
    public EditTextTool showOrHideEye(CheckBox[] checkBox, EditText[] editText) {
        if (checkBox.length == editText.length) {
            for (int i = 0; i < editText.length; i++) {
                if (checkBox[i].isChecked()) {
                    editText[i].setTransformationMethod(PasswordTransformationMethod.getInstance());
                    checkBox[i].setChecked(false);
                } else {
                    editText[i].setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    checkBox[i].setChecked(true);
                }
            }
        }
        return this;
    }

    /**
     * 隐藏EditText的内容
     */
    public EditTextTool setEditTextHide(EditText[] editText) {
        for (EditText anEditText : editText) {
            anEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
        return this;
    }


    /**
     * 改变EditText底部线条的颜色
     */
    public EditTextTool setLineChangeByLostFocus(EditText[] editTexts, View[] views) {
        if (editTexts.length == views.length) {
            for (int i = 0; i < editTexts.length; i++) {
                int position = i;
                editTexts[i].setOnFocusChangeListener((view, b) -> {
                    if (b) {
                        views[position].setBackgroundColor(Color.parseColor("#29c98f"));
                    } else {
                        views[position].setBackgroundColor(Color.parseColor("#e7e7e7"));
                    }
                });
            }
        }
        return this;
    }

    /**
     * 为TextView中的文字增加下划线
     */
    public EditTextTool setUnderline(TextView[] textViews) {
        for (TextView textView : textViews) {
            textView.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG); //下划线
            textView.getPaint().setAntiAlias(true);//抗锯齿
        }
        return this;
    }

    /**
     * 监听文本框内容，显示或隐藏删除按钮
     */

    public EditTextTool showOrHideDelete(EditText[] editTexts, View[] views) {
        if (editTexts.length == views.length) {
            for (int i = 0; i < editTexts.length; i++) {
                int position = i;
                editTexts[i].addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void afterTextChanged(Editable editable) {
                        if (editable.length() > 0) {
                            views[position].setVisibility(View.VISIBLE);
                        } else {
                            views[position].setVisibility(View.GONE);
                        }
                    }
                });
            }
        }
        return this;
    }

    /**
     * 改变部分字体颜色
     *
     * @param textView    显示的文本框
     * @param allString   整个字符串
     * @param colorString 需要改变字体颜色的字符串
     */
    public EditTextTool colorString(TextView textView, String allString, String colorString) {
        int fstart = allString.indexOf(colorString);
        int fend = fstart + colorString.length();
        SpannableStringBuilder style = new SpannableStringBuilder(allString);
        style.setSpan(new ForegroundColorSpan(Color.parseColor("#10b478")), fstart, fend, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        textView.setText(style);
        return this;
    }


    /**
     * 发送验证码倒计时
     *
     * @param textView 倒计时按钮文本框
     */
    public EditTextTool setTimer(TextView textView) {
        new CountDownTimer(60000, 1000) {
            @SuppressLint("SetTextI18n")
            public void onTick(long millisUntilFinished) {
                textView.setText(millisUntilFinished / 1000 + "秒后重发");
                textView.setTextColor(Color.parseColor("#aeaeae"));
                textView.setEnabled(false);
            }

            public void onFinish() {
                textView.setTextColor(Color.parseColor("#8b9bb4"));
                textView.setText("发送验证码");
                textView.setEnabled(true);
            }
        }.start();
        return this;
    }

    /***
     * 获得隐藏的手机号（用*号进行遮掩处理）
     * @param phone 手机号码
     */
    public EditTextTool hidePhoneWithStar(TextView textView, String phone) {
        if (!TextUtils.isEmpty(phone)) {
            if (phone.length() == 11) {
                textView.setText(phone.substring(0, 3) + "****" + phone.substring(7, 11));
            }
        }
        return this;
    }
}
