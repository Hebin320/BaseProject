package com.hebin.model;

import android.content.Context;

import com.hebin.entity.DataEntity;
import com.hebin.minterface.universal.SuccessListener;
import com.hebin.minterface.base.IBaseBiz;
import com.hebin.minterface.base.IBaseOnListener;
import com.hebin.model.universal.OkgoPostModel;

import java.util.HashMap;

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
public class Postmodel implements IBaseBiz, SuccessListener {

    @Override
    public void getData(Context context, Object T, IBaseOnListener onListener) {
        DataEntity dataEntity = (DataEntity) T;
        HashMap<String, String> params = new HashMap<>();
        params.put("mobile", dataEntity.getUser());
        params.put("pwd", dataEntity.getPwd());
        OkgoPostModel.getData("http://www.baidu.com", params, onListener, this);
    }

    @Override
    public void onSuccess(String data, IBaseOnListener onListener) {
        onListener.getSuccess(data);
    }
}
