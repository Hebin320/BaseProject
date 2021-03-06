package com.hebin.minterface.base;

import android.content.Context;

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
public interface IBaseBiz<T> {
    void  getData(Context context, T T, IBaseOnListener onListener);
}
