package com.hebin.minterface.universal;

/**
 * Author Hebin
 * <p>
 * created at 2017/5/5 10:25
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * 说明：网络请求成功后，数据回调接口，功能是将通用的Model中的数据传给调用接口的Model
 */
public interface TwoRecyclerViewClick {
    void setListener(int position_1, int position_2);
}
