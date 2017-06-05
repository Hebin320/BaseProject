package com.hebin.minterface.base;

/**
 * Author Hebin
 * <p>
 * created at 2017/5/5 10:25
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * 说明：
 */
public interface IBaseView<T> {

    T getData();

    void getSuccess(String type, T T);

    void getFailed(String type, T T);

    void showLoading();

    void hideLoading();

    void noNetConnected();

    void netWork();
}
