package com.hebin.encapsulation.viewpager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.LinearLayout;


import com.hebin.R;

import java.util.List;
/**
 * Author Hebin
 * <p>
 * created at 2017/5/5 10:24
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * 说明：选择图片的工具类，提跳转到相机、相册；可选择裁切、不裁切
 */
public class ViewpagerPoint {

    private static ViewpagerPoint instance;

    public static ViewpagerPoint getInstance() {
        if (instance == null) {
            synchronized (ViewpagerPoint.class) {
                if (instance == null) {
                    instance = new ViewpagerPoint();
                }
            }
        }
        return instance;
    }

    public void setPoint(Context context, ViewPager viewPager, List list, LinearLayout pointLayout, int pointSize) {
        ImageView[] imageViews;
        if (list.size() != 1) {
            pointLayout.removeAllViews();
            imageViews = new ImageView[list.size()];
            for (int i = 0; i < list.size(); i++) {
                ImageView img = new ImageView(context);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(pointSize, pointSize);
                layoutParams.setMargins(pointSize / 2, 0, pointSize / 2, 0);
                img.setLayoutParams(layoutParams);
                imageViews[i] = img;
                if (i == 0) {
                    imageViews[i].setBackgroundResource(R.drawable.circle_colorprimary);
                } else {
                    imageViews[i].setBackgroundResource(R.drawable.circle_gray);
                }
                pointLayout.addView(imageViews[i]);
            }
            viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {
                    for (int i = 0; i < imageViews.length; i++) {
                        if (i == position) {
                            imageViews[i].setBackgroundResource(R.drawable.circle_colorprimary);
                        } else {
                            imageViews[i].setBackgroundResource(R.drawable.circle_gray);
                        }
                    }
                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });
        }

    }
}
