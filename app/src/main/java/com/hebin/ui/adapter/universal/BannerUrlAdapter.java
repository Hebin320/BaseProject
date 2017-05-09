package com.hebin.ui.adapter.universal;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.LoopPagerAdapter;
import com.hebin.utils.ImageUtil;

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
public class BannerUrlAdapter extends LoopPagerAdapter {

    private Context context;
    private List<String> list = new ArrayList<>();

    public BannerUrlAdapter(Context context, RollPagerView viewPager, List<String> list) {
        super(viewPager);
        this.context = context;
        this.list = list;
    }

    @Override
    public View getView(ViewGroup container, int position) {
        ImageView view = new ImageView(container.getContext());
        view.setScaleType(ImageView.ScaleType.CENTER_CROP);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        ImageUtil.glideNormalImage(context, list.get(position), view);
        return view;
    }

    @Override
    public int getRealCount() {
        return list.size();
    }

}
