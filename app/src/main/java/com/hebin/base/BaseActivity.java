package com.hebin.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import com.hebin.utils.SystemBarTintManager;
import com.hebin.utils.ActivityManager;

/**
 * Author Hebin
 * <p>
 * created at 2017/5/5 10:18
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * 说明：基础Activity，用于共同方法的实现
 */
public class BaseActivity extends AppCompatActivity {

    /**
     * 用于onResume的时候，进行的网络请求的操作是否需要Token的判断标识
     */
    public boolean isNeedToken = false;
    /**
     * 状态栏是否透明的标识
     */
    public boolean isTranslucent = false;
    public Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.context = BaseActivity.this;
        getResources();
        //每个Activity创建的时候，都自动加到Activity管理器中，便于对Activity的集体管理
        ActivityManager.addActivity(this);
        this.context = BaseActivity.this;
    }


    /**
     * 设置状态栏为透明状态栏
     */
    public void setTranslucent() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);
        }
        SystemBarTintManager tintManager = new SystemBarTintManager(this);
        tintManager.setStatusBarTintEnabled(true);
        tintManager.setStatusBarTintResource("#00000000");
    }

    /**
     * 动态设置状态栏，状态栏颜色为后台给出的颜色
     */
    public void setWebTheme() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);
        }
        SystemBarTintManager tintManager = new SystemBarTintManager(this);
        tintManager.setStatusBarTintEnabled(true);
        tintManager.setStatusBarTintResource("#29c98f");
    }

    @TargetApi(19)
    private void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (isTranslucent) {
            setTranslucent();
        }
    }

    @Override
    protected void onResume() {
        if (isNeedToken) {
            checkToken("", "");
        }
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        ActivityManager.removeActivity(this);
        super.onDestroy();
    }

    public Resources getResources() {
        Resources res = super.getResources();
        Configuration config = new Configuration();
        config.setToDefaults();
        res.updateConfiguration(config, res.getDisplayMetrics());
        return res;
    }

    /**
     * 检查Token是否有效
     */
    public void checkToken(String userid, String token) {
    }


    /**
     * 如果需要Token，并且Token有效执行的操作
     */
    public void refreshData() {
    }

    /**
     * 如果需要Token，并且Token\没效执行的操作
     * 跳转到主页
     */
    public void goMain() {
        BaseFile.cleanUserData(BaseActivity.this);
    }
}
