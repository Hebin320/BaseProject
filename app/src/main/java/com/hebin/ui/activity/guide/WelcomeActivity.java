package com.hebin.ui.activity.guide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.widget.LinearLayout;

import com.hebin.R;
import com.hebin.base.BaseActivity;
import com.hebin.encapsulation.permission.PermissionTool;
import com.hebin.minterface.universal.DoSomeThing;
import com.hebin.ui.activity.universal.WebViewActivity;
import com.hebin.utils.DialogUtil;
import com.hebin.widget.view.tablayout.MyTabLayout;

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
public class WelcomeActivity extends BaseActivity implements DoSomeThing {

    @InjectView(R.id.ll_father)
    LinearLayout llFather;
    @InjectView(R.id.vp_main)
    ViewPager vpMain;
    @InjectView(R.id.tab_main)
    MyTabLayout tabMain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.inject(this);
        init();
        DialogUtil.showDialog(context);
    }

    private void init() {
        //申请权限
        PermissionTool.getInstance()
                //内存卡权限
                .READ_EXTERNAL_STORAGE(this, this)
                //照相机权限
                .CAMERA(this, this);
    }

    @Override
    public void doSomeThing(String type, Object T) {
        switch (type) {
            case PermissionTool.HAVE_PERMISSIONS:
                break;
        }
    }

    @OnClick(R.id.ll_father)
    public void onClick() {
        startActivity(new Intent(this, WebViewActivity.class));
    }


}
