package com.hebin.entity;

/**
 * Author Hebin
 * <p>
 * created at 2017/5/9
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * 说明：进行网络请求时，传参用的Entity类
 */
public class DataEntity {


    private String user;
    private String pwd;

    public void setUser(String user) {
        this.user = user;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getUser() {
        return user;
    }

    public String getPwd() {
        return pwd;
    }
}
