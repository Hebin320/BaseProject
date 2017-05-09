package com.hebin.ui.activity.guide;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.widget.LinearLayout;

import com.hebin.R;
import com.hebin.base.BaseActivity;
import com.hebin.custom.view.tablayout.MyTabLayout;
import com.hebin.encapsulation.permission.PermissionEnum;
import com.hebin.encapsulation.permission.PermissionTool;
import com.hebin.ui.activity.universal.WebViewActivity;
import com.hebin.ui.adapter.universal.ViewpagerImgeViewAdapter;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Author Hebin
 * <p>
 * created at 2017/5/5 10:26
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * 说明：
 */
public class WelcomeActivity extends BaseActivity {

    @InjectView(R.id.ll_father)
    LinearLayout llFather;
    @InjectView(R.id.vp_main)
    ViewPager vpMain;
    @InjectView(R.id.tab_main)
    MyTabLayout tabMain;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.inject(this);
        this.context = WelcomeActivity.this;
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case PermissionEnum.RESULT_READ_EXTERNAL_STORAGE:
                if (grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    PermissionTool.getInstance().READ_EXTERNAL_STORAGE(this);
                }
                break;
            case PermissionEnum.RESULT_CAMERA:
                if (grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    PermissionTool.getInstance().CAMERA(this);
                }
                break;
        }
    }

    @OnClick(R.id.ll_father)
    public void onClick() {
        startActivity(new Intent(this, WebViewActivity.class));
    }
}
