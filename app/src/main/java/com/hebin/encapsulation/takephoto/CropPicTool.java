package com.hebin.encapsulation.takephoto;

import android.net.Uri;
import android.os.Environment;

import com.jph.takephoto.app.TakePhotoActivity;
import com.jph.takephoto.app.TakePhotoFragment;
import com.jph.takephoto.compress.CompressConfig;
import com.jph.takephoto.model.CropOptions;
import com.hebin.encapsulation.permission.PermissionTool;
import com.hebin.utils.SingletonUtil;

import java.io.File;
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
public class CropPicTool extends SingletonUtil<CropPicTool> {

    public static final String PICK_FROM_CAPTURE_WITH_NO_CROP = "从相机拍取照片不裁剪";
    public static final String PICK_FROM_MULTIPLE_WITH_NO_CROP = "从相册选取照片不裁剪";
    public static final String PICK_FROM_CAPTURE_WITH_CROP = "从相机拍取照片并且裁剪";
    public static final String PICK_FROM_MULTIPLE_WITH_CROP = "从相册选取照片并且裁剪";

    @Override
    protected CropPicTool newInstance() {
        return new CropPicTool().getInstance();
    }


    public static void setCropPic(TakePhotoActivity activity, String selectPosition, int pickSize) {

        PermissionTool.getInstance().CAMERA(activity).READ_EXTERNAL_STORAGE(activity);

        File file = new File(Environment.getExternalStorageDirectory(), "/temp/" + System.currentTimeMillis() + ".jpg");
        if (!file.getParentFile().exists()) file.getParentFile().mkdirs();
        // 图片保存路径
        Uri imageUri = Uri.fromFile(file);
        //压缩设置
        CompressConfig compressConfig = new CompressConfig.Builder().setMaxSize(50 * 1024).setMaxPixel(800).create();
        activity.getTakePhoto().onEnableCompress(compressConfig, true);
        //裁切设置
        CropOptions cropOptions = new CropOptions.Builder().setAspectX(1).setAspectY(1).setWithOwnCrop(true).create();
        switch (selectPosition) {
            case PICK_FROM_CAPTURE_WITH_NO_CROP:
                activity.getTakePhoto().onPickFromCapture(imageUri);
                break;
            case PICK_FROM_MULTIPLE_WITH_NO_CROP:
                activity.getTakePhoto().onPickMultiple(pickSize);
                break;
            case PICK_FROM_CAPTURE_WITH_CROP:
                activity.getTakePhoto().onPickFromCaptureWithCrop(imageUri, cropOptions);
                break;
            case PICK_FROM_MULTIPLE_WITH_CROP:
                activity.getTakePhoto().onPickMultipleWithCrop(pickSize, cropOptions);
                break;
            default:
                break;
        }
    }

    public static void setCropPicForFragment(TakePhotoFragment activity, String selectPosition, int pickSize) {

        PermissionTool.getInstance().READ_EXTERNAL_STORAGE(activity.getActivity()).CAMERA(activity.getActivity());

        File file = new File(Environment.getExternalStorageDirectory(), "/temp/" + System.currentTimeMillis() + ".jpg");
        if (!file.getParentFile().exists()) file.getParentFile().mkdirs();
        // 图片保存路径
        Uri imageUri = Uri.fromFile(file);
        //压缩设置
        CompressConfig compressConfig = new CompressConfig.Builder().setMaxSize(50 * 1024).setMaxPixel(800).create();
        activity.getTakePhoto().onEnableCompress(compressConfig, true);
        //裁切设置
        CropOptions cropOptions = new CropOptions.Builder().setAspectX(1).setAspectY(1).setWithOwnCrop(true).create();
        switch (selectPosition) {
            case PICK_FROM_CAPTURE_WITH_NO_CROP:
                activity.getTakePhoto().onPickFromCapture(imageUri);
                break;
            case PICK_FROM_MULTIPLE_WITH_NO_CROP:
                activity.getTakePhoto().onPickMultiple(pickSize);
                break;
            case PICK_FROM_CAPTURE_WITH_CROP:
                activity.getTakePhoto().onPickFromCaptureWithCrop(imageUri, cropOptions);
                break;
            case PICK_FROM_MULTIPLE_WITH_CROP:
                activity.getTakePhoto().onPickMultipleWithCrop(pickSize, cropOptions);
                break;
            default:
                break;
        }
    }
}
