package com.hebin.encapsulation.permission;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import com.hebin.minterface.universal.DoSomeThing;


/**
 * Author Hebin
 * <p>
 * created at 2017/5/5
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * 说明：权限申请的工具类
 */
public class PermissionTool {

    public static final String HAVE_PERMISSIONS = "已经拥有权限";
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


    public PermissionTool READ_EXTERNAL_STORAGE(Activity activity, DoSomeThing doSomeThing) {
        if (ContextCompat.checkSelfPermission(activity, PermissionEnum.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, new String[]{PermissionEnum.READ_EXTERNAL_STORAGE}, PermissionEnum.RESULT_READ_EXTERNAL_STORAGE);
        }
        return this;
    }

    public PermissionTool CAMERA(Activity activity,DoSomeThing doSomeThing) {
        if (ContextCompat.checkSelfPermission(activity, PermissionEnum.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, new String[]{PermissionEnum.CAMERA}, PermissionEnum.RESULT_CAMERA);
        }else {
            doSomeThing.doSomeThing(HAVE_PERMISSIONS,0);
        }
        return this;
    }
}
