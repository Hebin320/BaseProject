package com.hebin.base;

import android.os.AsyncTask;
import android.support.v4.app.Fragment;

/**
 * Author Hebin
 * <p>
 * created at 2017/5/5 10:20
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * 说明：用户Viewpager切换的Fragment，懒加载，解决切换时卡顿的问题
 */
public abstract class BaseLazyFragment extends Fragment {

    /**
     * Fragment当前状态是否可见
     */
    protected boolean isVisible;
    protected boolean isPrepared = true;
    protected boolean mHasLoadedOnce;


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInvisible();
        }
    }

    /**
     * 可见
     */
    protected void onVisible() {
        if (!isPrepared || !isVisible || mHasLoadedOnce) {
            return;
        }

        new AsyncTask<Void, Void, Boolean>() {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected Boolean doInBackground(Void... params) {
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return true;
            }

            @Override
            protected void onPostExecute(Boolean isSuccess) {
                if (isSuccess) {
                    mHasLoadedOnce = true;
                    lazyLoad();
                }
            }
        }.execute();
    }

    /**
     * 不可见
     */
    protected void onInvisible() {

    }

    /**
     * 延迟加载
     * 子类必须重写此方法
     */
    public abstract void lazyLoad();
}
