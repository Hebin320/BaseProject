package com.hebin.utils;
/**
 * Author Hebin
 * <p>
 * created at 2017/5/5 10:27
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * 说明：泛型单例模式
 */
public abstract class SingletonUtil<T>  {

    private T instance;

    protected abstract T newInstance();

    public final T getInstance() {
        if (instance ==null){
            synchronized (SingletonUtil.class){
                if (instance ==null){
                    instance = newInstance();
                }
            }
        }
        return instance;
    }
}
