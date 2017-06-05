package com.hebin.widget.view.tablayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.design.widget.TabLayout;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import com.hebin.R;


/**
 * Author Hebin
 * <p>
 * created at 2017/5/5
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * 说明：重写TabLayout，实现文字+图片（可左，可右，可上，可下，可无图片）样式
 */
public class MyTabLayout extends TabLayout {

    // 图片位置，0是左，1是上，2是右，3是下
    private Integer drawableType = 0;
    // 图片与文字的间距
    private int drawablePadding = getResources().getDimensionPixelSize(R.dimen.dp_4);
    // 图片宽度
    private int drawableWidth = getResources().getDimensionPixelSize(R.dimen.dp_20);
    // 图片高度
    private int drawableHeigth = getResources().getDimensionPixelSize(R.dimen.dp_16);
    // 字体大小
    private int textSize = 16;
    // 未选中字体颜色
    private int textColor = (int) getResources().getColor(R.color.black);
    // 选择字体颜色
    private int textSelectColor = (int) getResources().getColor(R.color.black);
    // 未选中背景颜色
    private int itemBackground = (int) getResources().getColor(R.color.white);
    // 选中背景颜色
    private int itemSelecetBackground = (int) getResources().getColor(R.color.colorPrimary);

    public MyTabLayout(Context context) {
        super(context);
    }

    public MyTabLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.MyTabLayout);
        drawableType = a.getInt(R.styleable.MyTabLayout_tab_drawable, 0);
        drawablePadding = a.getDimensionPixelSize(R.styleable.MyTabLayout_drawable_padding, getResources().getDimensionPixelSize(R.dimen.dp_4));
        drawableWidth = a.getDimensionPixelSize(R.styleable.MyTabLayout_drawable_width, getResources().getDimensionPixelSize(R.dimen.dp_20));
        drawableHeigth = a.getDimensionPixelSize(R.styleable.MyTabLayout_drawable_heigth, getResources().getDimensionPixelSize(R.dimen.dp_16));
        textSize = a.getInt(R.styleable.MyTabLayout_textSize, 16);
        textColor = a.getColor(R.styleable.MyTabLayout_textColor, getResources().getColor(R.color.black));
        textSelectColor = a.getColor(R.styleable.MyTabLayout_textSelectColor, getResources().getColor(R.color.black));
        itemBackground = a.getResourceId(R.styleable.MyTabLayout_itemBackground, getResources().getColor(R.color.white));
        itemSelecetBackground = a.getResourceId(R.styleable.MyTabLayout_itemSelectBackground, getResources().getColor(R.color.colorPrimary));
    }

    public MyTabLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.MyTabLayout);
        drawableType = a.getInt(R.styleable.MyTabLayout_tab_drawable, 0);
        drawablePadding = a.getDimensionPixelSize(R.styleable.MyTabLayout_drawable_padding, getResources().getDimensionPixelSize(R.dimen.dp_4));
        drawableWidth = a.getDimensionPixelSize(R.styleable.MyTabLayout_drawable_width, getResources().getDimensionPixelSize(R.dimen.dp_20));
        drawableHeigth = a.getDimensionPixelSize(R.styleable.MyTabLayout_drawable_heigth, getResources().getDimensionPixelSize(R.dimen.dp_16));
        textSize = a.getInt(R.styleable.MyTabLayout_textSize, 16);
        textColor = a.getColor(R.styleable.MyTabLayout_textColor, getResources().getColor(R.color.black));
        textSelectColor = a.getColor(R.styleable.MyTabLayout_textSelectColor, getResources().getColor(R.color.black));
        itemBackground = a.getResourceId(R.styleable.MyTabLayout_itemBackground, getResources().getColor(R.color.white));
        itemSelecetBackground = a.getResourceId(R.styleable.MyTabLayout_itemSelectBackground, getResources().getColor(R.color.colorPrimary));
    }

    public void setView(String[] strings, int[] img) {
        for (int i = 0; i < strings.length; i++) {
            Tab tabLayout = this.getTabAt(i);
            if (tabLayout != null) {
                View view = LayoutInflater.from(getContext()).inflate(R.layout.view_tablayout, null);
                view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                //设置文本
                CheckBox checkBox = (CheckBox) view.findViewById(R.id.cb_title);
                LinearLayout llfather = (LinearLayout) view.findViewById(R.id.ll_father);
                if (i == 0) {
                    llfather.setBackgroundResource(itemSelecetBackground);
                } else {
                    llfather.setBackgroundResource(itemBackground);
                }
                checkBox.setText(strings[i]);
                if (i == 0) {
                    checkBox.setTextColor(textSelectColor);
                } else {
                    checkBox.setTextColor(textColor);
                }
                checkBox.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
                if (img != null) {
                    checkBox.setCompoundDrawablePadding(drawablePadding);
                    Drawable drawable = getResources().getDrawable(img[i]);
                    drawable.setBounds(0, 0, drawableWidth, drawableHeigth);
                    switch (drawableType) {
                        //左边
                        case 0:
                            checkBox.setCompoundDrawables(drawable, null, null, null);
                            break;
                        //顶部
                        case 1:
                            checkBox.setCompoundDrawables(null, drawable, null, null);
                            break;
                        // 右边
                        case 2:
                            checkBox.setCompoundDrawables(null, null, drawable, null);
                            break;
                        //底部
                        case 3:
                            checkBox.setCompoundDrawables(null, null, null, drawable);
                            break;
                    }
                }
                if (i == 0) {
                    checkBox.setChecked(true);
                }
                assert tabLayout != null;
                tabLayout.setCustomView(view);
            }
        }
        this.addOnTabSelectedListener(new OnTabSelectedListener() {
            @Override
            public void onTabSelected(Tab tab) {
                if (tab.getCustomView() != null) {
                    CheckBox cb = (CheckBox) tab.getCustomView().findViewById(R.id.cb_title);
                    cb.setChecked(true);
                    cb.setTextColor(textSelectColor);
                    LinearLayout llfather = (LinearLayout) tab.getCustomView().findViewById(R.id.ll_father);
                    llfather.setBackgroundResource(itemSelecetBackground);
                }
            }

            @Override
            public void onTabUnselected(Tab tab) {
                if (tab.getCustomView() != null) {
                    CheckBox cb = (CheckBox) tab.getCustomView().findViewById(R.id.cb_title);
                    cb.setChecked(false);
                    cb.setTextColor(textColor);
                    LinearLayout llfather = (LinearLayout) tab.getCustomView().findViewById(R.id.ll_father);
                    llfather.setBackgroundResource(itemBackground);
                }
            }

            @Override
            public void onTabReselected(Tab tab) {

            }
        });
    }


}
