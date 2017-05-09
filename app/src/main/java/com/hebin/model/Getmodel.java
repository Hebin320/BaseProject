package com.hebin.model;

import android.content.Context;

import com.hebin.minterface.SuccessListener;
import com.hebin.minterface.base.IBaseBiz;
import com.hebin.minterface.base.IBaseOnListener;
import com.hebin.model.universal.OkgoGetModel;
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
public class Getmodel implements IBaseBiz, SuccessListener {
    @Override
    public void getData(Context context, Object T, IBaseOnListener onListener) {
        OkgoGetModel.getData("http://www.baidu.com", "Hebin", onListener,this);
    }

    @Override
    public void onSuccess(String data, IBaseOnListener onListener) {
        onListener.getSuccess(data);
    }
}
