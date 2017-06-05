package com.hebin.encapsulation.recyclerview;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hebin.R;
import com.hebin.superrecyclerview.recycleview.ProgressStyle;
import com.hebin.superrecyclerview.recycleview.SuperRecyclerView;
import com.hebin.utils.SingletonUtil;

/**
 * Author Hebin
 * <p>
 * created at 2017/6/5 16:22
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * 说明：RecyclerView的一些基础属性设置
 */
public class RecyclerViewTool extends SingletonUtil<RecyclerViewTool> {


    /**
     * 不可滚动的Recyclerview，用于Scrollview中嵌套的Recyclerview
     *
     * @param isVertical true的时候，为垂直的Recyclerview，false的时候，为水平滚动的Recyclerview
     */
    public static void setSimpleLinearNoScroll(Context context, RecyclerView recyclerView, boolean isVertical) {
        LinearLayoutManager layoutManager;
        if (isVertical) {
            layoutManager = new LinearLayoutManager(context) {
                @Override
                public boolean canScrollVertically() {
                    return false;
                }
            };
            layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        } else {
            layoutManager = new LinearLayoutManager(context) {
                @Override
                public boolean canScrollHorizontally() {
                    return false;
                }
            };
            layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        }
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    /**
     *  可滚动的Recyclerview，一般Recyclerview的基础属性设置
     *
     * @param isVertical true的时候，为垂直的Recyclerview，false的时候，为水平滚动的Recyclerview
     */
    public static void setSimpleLinearRecyclerView(Context context, RecyclerView recyclerView, boolean isVertical) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        if (isVertical) {
            layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        } else {
            layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        }
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    /**
     * 九宫格布局的Recyclerview
     *
     * @param size 九宫格，一行的个数
     */
    public static void setSimpleGridRecyclerView(Context context, RecyclerView recyclerView, int size) {
        GridLayoutManager layoutManager = new GridLayoutManager(context, size);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    /**
     * 不可滚动的SuperRecyclerview，用于Scrollview中嵌套的Recyclerview
     *
     * @param isVertical true的时候，为垂直的线性SuperRecyclerview，false的时候，为水平滚动的线性SuperRecyclerview
     */
    public static void setSuperLinearNoScoll(Context context, SuperRecyclerView recyclerView, boolean isVertical) {
        LinearLayoutManager layoutManager;
        if (isVertical) {
            layoutManager = new LinearLayoutManager(context) {
                @Override
                public boolean canScrollVertically() {
                    return false;
                }
            };
            layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        } else {
            layoutManager = new LinearLayoutManager(context) {
                @Override
                public boolean canScrollVertically() {
                    return false;
                }
            };
            layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        }
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLoadMoreEnabled(false);
        recyclerView.setRefreshEnabled(false);
    }

    /**
     *  可滚动的SuperRecyclerview，一般SuperRecyclerview的基础属性设置
     *
     * @param isVertical true的时候，为垂直的SuperRecyclerview，false的时候，为水平滚动的SuperRecyclerview
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
        recyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallSpinFadeLoader);
        recyclerView.setArrowImageView(R.drawable.ic_downgrey);
    }

    /**
     * 九宫格布局的SuperRecyclerview
     *
     * @param size 九宫格，一行的个数
     */
    public static void setGridRecyclerView(Context context, SuperRecyclerView recyclerView, int size) {
        GridLayoutManager layoutManager = new GridLayoutManager(context, size);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        recyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallSpinFadeLoader);
        recyclerView.setArrowImageView(R.drawable.ic_downgrey);
    }


    @Override
    protected RecyclerViewTool newInstance() {
        return new RecyclerViewTool().getInstance();
    }
}
