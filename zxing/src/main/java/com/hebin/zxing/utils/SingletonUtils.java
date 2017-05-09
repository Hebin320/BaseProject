package com.hebin.zxing.utils;

/**
 * Created by Hebin
 * blog: http://blog.csdn.net/hebin320320
 * GitHub: https://github.com/Hebin320
 *
 * 泛型单例模式
 */
public abstract class SingletonUtils<T>  {

    private T instance;

    protected abstract T newInstance();

    public final T getInstance() {
        if (instance ==null){
            synchronized (SingletonUtils.class){
                if (instance ==null){
                    instance = newInstance();
                }
            }
        }
        return instance;
    }
}
