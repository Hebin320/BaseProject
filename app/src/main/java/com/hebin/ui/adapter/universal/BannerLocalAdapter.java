package com.hebin.ui.adapter.universal;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.LoopPagerAdapter;

import java.util.ArrayList;
import java.util.List;
/**
 * Author Hebin
 * <p>
 * created at 2017/5/5 10:26
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * 说明：Banner加载Adapter （本地图片）
 */
public class BannerLocalAdapter extends LoopPagerAdapter {

    private List<Integer> list = new ArrayList<>();

    public BannerLocalAdapter(RollPagerView viewPager, List<Integer> list) {
        super(viewPager);
        this.list = list;
    }

    @Override
    public View getView(ViewGroup container, int position) {
        ImageView view = new ImageView(container.getContext());
        view.setImageResource(list.get(position));
        view.setScaleType(ImageView.ScaleType.CENTER_CROP);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        return view;
    }

    @Override
    public int getRealCount() {
        return list.size();
    }

}
