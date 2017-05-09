package com.hebin.base;

import com.jph.takephoto.app.TakePhotoFragment;
import com.jph.takephoto.model.TResult;

  /**
   * Author Hebin
   * <p>
   * created at 2017/5/5 10:22
   * <p>
   * blog: http://blog.csdn.net/hebin320320
   * <p>
   * GitHub: https://github.com/Hebin320
   * <p>
   * 说明：用于图片选择的基础Fragment，TakePhotoFragment，实现共同方法
   */
public class BaseTakePhotoFragment extends TakePhotoFragment {
    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void takeFail(TResult result, String msg) {
        super.takeFail(result, msg);
    }

    @Override
    public void takeCancel() {
        super.takeCancel();
    }
}
