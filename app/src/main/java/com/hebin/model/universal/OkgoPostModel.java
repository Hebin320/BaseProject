package com.hebin.model.universal;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.request.BaseRequest;
import com.hebin.minterface.SuccessListener;
import com.hebin.minterface.base.IBaseOnListener;
import com.hebin.utils.SingletonUtil;

import java.util.HashMap;

import okhttp3.Call;
import okhttp3.Response;
/**
 * Author Hebin
 * <p>
 * created at 2017/5/5 10:26
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * 说明：POST请求
 * <p>
 * Okgo网络请求的通用类，显示、隐藏对话框以及网络（访问后台）出现问题的一致处理
 * 请求成功得到的数据可进行回调给其他Model处理
 * <p>
 * 用于提交数据的网络请求
 */
public class OkgoPostModel extends SingletonUtil<OkgoPostModel>{


    @Override
    protected OkgoPostModel newInstance() {
        return new OkgoPostModel().getInstance();
    }


    public static void getData(String url, HashMap<String,String> params, IBaseOnListener iBaseOnListener, SuccessListener successListener) {

        OkGo.post(url).isMultipart(true)
                .params(params)
                .execute(new StringCallback() {

                    @Override
                    public void onBefore(BaseRequest request) {
                        super.onBefore(request);
                        iBaseOnListener.showLoading();
                    }

                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        successListener.onSuccess(s, iBaseOnListener);
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        iBaseOnListener.getFail("404");
                    }

                    @Override
                    public void onAfter(String s, Exception e) {
                        super.onAfter(s, e);
                        iBaseOnListener.hideLoading();
                    }
                });
    }

}
