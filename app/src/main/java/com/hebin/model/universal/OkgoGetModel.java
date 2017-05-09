package com.hebin.model.universal;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.request.BaseRequest;
import com.hebin.minterface.SuccessListener;
import com.hebin.minterface.base.IBaseOnListener;
import com.hebin.utils.SingletonUtil;

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
 * 说明： Get请求
 * <p>
 * Okgo网络请求的通用类，显示、隐藏对话框以及网络（访问后台）出现问题的一致处理
 * 请求成功得到的数据可进行回调给其他Model处理
 */
public class OkgoGetModel extends SingletonUtil<OkgoGetModel> {


    @Override
    protected OkgoGetModel newInstance() {
        return new OkgoGetModel().getInstance();
    }


    public static void getData(String url, String cacheKey, IBaseOnListener iBaseOnListener,SuccessListener successListener) {
        OkGo.get(url).cacheKey(cacheKey)
                .cacheMode(CacheMode.FIRST_CACHE_THEN_REQUEST)
                .execute(new StringCallback() {

                    @Override
                    public void onBefore(BaseRequest request) {
                        iBaseOnListener.showLoading();
                    }

                    String cacheString = "";

                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        if (!cacheString.equals(s)) {
                            onCacheSuccess(s, call);
                        }
                    }

                    @Override
                    public void onCacheSuccess(String s, Call call) {
                        cacheString = s;
                        successListener.onSuccess(s, iBaseOnListener);

                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        iBaseOnListener.getFail("404");
                    }

                    @Override
                    public void onAfter(String s, Exception e) {
                        iBaseOnListener.hideLoading();
                    }
                });
    }


}
