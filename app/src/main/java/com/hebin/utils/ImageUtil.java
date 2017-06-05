package com.hebin.utils;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.util.Util;
import com.hebin.R;
import com.hebin.base.MyApplication;
import com.hebin.encapsulation.glide.GlideCircleTransform;
import com.hebin.encapsulation.glide.GlideRoundTransform;

import java.io.IOException;


/**
 * Glide工具加载图片的快捷入口
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
                    .error(R.drawable.ic_img_default)
                    .placeholder(R.drawable.ic_img_default)
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
                    .error(R.drawable.ic_img_default)
                    .placeholder(R.drawable.ic_img_default)
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
                    .error(R.drawable.ic_img_default)
                    .placeholder(R.drawable.ic_img_default)
                    .into(imageView)
            ;
        }
    }

    /**
     * 将本地图片加载到ImageView中，显示为圆形图片
     *
     * @param file      图片的本地地址
     * @param imageView 需要显示图片的控件
     */
    public static void glideLocalCircleImage(Context context, String file, ImageView imageView) {
        if (Util.isOnMainThread()) {
            Glide.with(MyApplication.getAppContext())
                    .load(file)
                    .transform(new GlideCircleTransform(context))
                    .error(R.drawable.ic_img_default)
                    .placeholder(R.drawable.ic_img_default)
                    .into(imageView);
        }
    }

    /**
     * 将本地图片加载到ImageView中，显示为正常图片
     *
     * @param file      图片的本地地址
     * @param imageView 需要显示图片的控件
     */
    public static void glideLocalNormalImage(Context context, String file, ImageView imageView) {
        if (Util.isOnMainThread()) {
            Glide.with(MyApplication.getAppContext())
                    .load(file)
                    .error(R.drawable.ic_img_default)
                    .placeholder(R.drawable.ic_img_default)
                    .into(imageView);
        }
    }

    /**
     * 读取图片属性：旋转的角度
     * @param path 图片绝对路径
     * @return degree旋转的角度
     */
    public static int readPictureDegree(String path) {
        int degree = 0;
        try {
            ExifInterface exifInterface = new ExifInterface(path);
            int orientation = exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION,ExifInterface.ORIENTATION_NORMAL);
            switch (orientation) {
                case ExifInterface.ORIENTATION_ROTATE_90:
                    degree = 90;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_180:
                    degree = 180;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_270:
                    degree = 270;
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return degree;
        }
        return degree;
    }

    /**
     * 旋转图片，使图片保持正确的方向。
     * @param bitmap 原始图片
     * @param degrees 原始图片的角度
     * @return Bitmap 旋转后的图片
     */
    public static Bitmap rotateBitmap(Bitmap bitmap, int degrees) {
        if (degrees == 0 || null == bitmap) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.setRotate(degrees, bitmap.getWidth() / 2, bitmap.getHeight() / 2);
        Bitmap bmp = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (null != bitmap) {
            bitmap.recycle();
        }
        return bmp;
    }

}
