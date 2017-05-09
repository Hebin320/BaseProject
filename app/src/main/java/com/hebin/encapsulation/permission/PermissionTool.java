package com.hebin.encapsulation.permission;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

/**
 * Author Hebin
 * <p>
 * created at 2017/5/5
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * 说明：
 */
public class PermissionTool {

    private static PermissionTool instance;

    public static PermissionTool getInstance() {
        if (instance == null) {
            synchronized (PermissionTool.class) {
                if (instance == null) {
                    instance = new PermissionTool();
                }
            }
        }
        return instance;
    }


    /**
     * 读取内存卡的权限
     */
    public PermissionTool READ_EXTERNAL_STORAGE(Activity activity) {
        if (ContextCompat.checkSelfPermission(activity, PermissionEnum.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, new String[]{PermissionEnum.READ_EXTERNAL_STORAGE}, PermissionEnum.RESULT_READ_EXTERNAL_STORAGE);
        }
        return this;
    }

    /**
     * 使用照相机的权限
     */
    public PermissionTool CAMERA(Activity activity) {
        if (ContextCompat.checkSelfPermission(activity, PermissionEnum.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, new String[]{PermissionEnum.CAMERA}, PermissionEnum.RESULT_CAMERA);
        }
        return this;
    }
}
