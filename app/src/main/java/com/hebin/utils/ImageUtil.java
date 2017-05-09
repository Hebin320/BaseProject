package com.hebin.utils;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.util.Util;
import com.hebin.base.MyApplication;
import com.hebin.custom.glide.GlideCircleTransform;
import com.hebin.custom.glide.GlideRoundTransform;

/**
 * Author Hebin
 * <p>
 * created at 2017/5/5 10:27
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * 说明：Glide工具加载图片的快捷入口
 */
public class ImageUtil extends SingletonUtil<ImageUtil> {


    @Override
    protected ImageUtil newInstance() {
        return new ImageUtil().getInstance();
    }

    /**
     * 将本地图片转为Bitmap并且进行压缩图片
     */
    public static Bitmap getBitmap(String file, int inSampleSize) {
        System.gc();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPurgeable = true;
        options.inSampleSize = inSampleSize;
        return BitmapFactory.decodeFile(file, options);
    }


    /**
     * 将网络图片加载到ImageView中，显示为圆角图片
     *
     * @param url       图片的网络地址
     * @param roundSize 圆角大小
     * @param imageView 需要显示图片的控件
     */
    public static void glideRoundImage(Context context, String url, int roundSize, ImageView imageView) {
        if (Util.isOnMainThread()) {
            if (TextUtils.isEmpty(url)) {
                url = "http://www.baidu.com";
            }
            Glide.with(MyApplication.getAppContext())
                    .load(url)
                    .transform(new GlideRoundTransform(context, roundSize))
                    .into(imageView);
        }
    }

    /**
     * 将网络图片加载到ImageView中，显示为圆形图片
     *
     * @param url       图片的网络地址
     * @param imageView 需要显示图片的控件
     */
    public static void glideCircleImage(Context context, String url, ImageView imageView) {
        if (Util.isOnMainThread()) {
            if (TextUtils.isEmpty(url)) {
                url = "http://www.baidu.com";
            }
            Glide.with(MyApplication.getAppContext())
                    .load(url)
                    .transform(new GlideCircleTransform(context))
                    .into(imageView);
        }
    }

    public static void glideNormalImage(Context context, String url, ImageView imageView) {
        if (Util.isOnMainThread()) {
            if (TextUtils.isEmpty(url)) {
                url = "http://www.baidu.com";
            }
            Glide.with(MyApplication.getAppContext())
                    .load(url)
                    .into(imageView)
                    ;
        }
    }

}
