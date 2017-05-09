package com.hebin.encapsulation.viewpager;

import android.support.v4.view.ViewPager;
import android.widget.RadioButton;
/**
 * Author Hebin
 * <p>
 * created at 2017/5/5 10:25
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * 说明：Viewpager一些通用功能的封装
 */
public class ViewpagerTool {

    private static ViewpagerTool instance;

    public static ViewpagerTool getInstance() {
        if (instance == null) {
            synchronized (ViewpagerTool.class) {
                if (instance == null) {
                    instance = new ViewpagerTool();
                }
            }
        }
        return instance;
    }

    /**
    *  切换Viewpager的时候，切换RadioButton的状态
    * */
    public void setRBCheck(ViewPager viewPager, RadioButton[] radioButton) {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < radioButton.length; i++) {
                    if (i == position) {
                        radioButton[i].setChecked(true);
                    } else {
                        radioButton[i].setChecked(false);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

}
