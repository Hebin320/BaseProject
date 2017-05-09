package com.hebin.encapsulation.recyclerview;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;

import com.hebin.R;
import com.hebin.superrecyclerview.recycleview.ProgressStyle;
import com.hebin.superrecyclerview.recycleview.SuperRecyclerView;
import com.hebin.utils.SingletonUtil;
/**
 * Author Hebin
 * <p>
 * created at 2017/5/5 10:24
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * 说明：RecyclerView的一些基础属性设置
 */
public class RecyclerViewTool extends SingletonUtil<RecyclerViewTool> {


    /**
     * 设置Recyclerview的基础属性，
     * 线性布局
     * 垂直方向
     * 下拉、上拉样式、下拉箭头
     */
    public static void setLinearRecyclerView(Context context, SuperRecyclerView recyclerView, boolean isVertical) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        if (isVertical) {
            layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        } else {
            layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        }
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        recyclerView.setLoadingMoreProgressStyle(ProgressStyle.LineScale);
        recyclerView.setArrowImageView(R.drawable.ic_downgrey);
    }

    /**
     * 设置Recyclerview的基础属性，
     * 网格布局
     * 下拉、上拉样式、下拉箭头
     *
     * @param size 每一行显示多少个
     */
    public static void setGridRecyclerView(Context context, SuperRecyclerView recyclerView, int size) {
        GridLayoutManager layoutManager = new GridLayoutManager(context, size);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        recyclerView.setLoadingMoreProgressStyle(ProgressStyle.LineScale);
        recyclerView.setArrowImageView(R.drawable.ic_downgrey);
    }


    @Override
    protected RecyclerViewTool newInstance() {
        return new RecyclerViewTool().getInstance();
    }
}
