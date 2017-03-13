package com.android.reading.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.android.reading.R;

/**
 * Created by Gu FanFan on 2017/3/9 5:06.
 * LoveReading.
 */

public class RecyclerViewDivider extends RecyclerView.ItemDecoration {

    public static final int HORIZONTAL = LinearLayout.HORIZONTAL;
    public static final int VERTICAL = LinearLayout.VERTICAL;

    private Paint mPaint;
    private int mDividerHeight = 15;
    private Drawable mDivider;
    private int mOrientation;
    private static final int[] ATTRS = new int[]{android.R.attr.listDivider};
    private final Rect mBounds = new Rect();

    public RecyclerViewDivider(Context context, int orientation) {
        if (orientation != LinearLayoutManager.VERTICAL
                && orientation != LinearLayoutManager.HORIZONTAL) {
            throw new IllegalArgumentException("请输入正确的参数！");
        }
        mOrientation = orientation;
        final TypedArray a = context.obtainStyledAttributes(ATTRS);
        mDivider = a.getDrawable(0);
        a.recycle();
        mPaint = new Paint();
        mPaint.setColor(ContextCompat.getColor(context, R.color.transparent));
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        int itemPosition = layoutParams.getViewLayoutPosition();
        int childCount = parent.getAdapter().getItemCount();
        if (mOrientation == VERTICAL) {
            outRect.set(0, 0, itemPosition != (childCount - 1) ? mDividerHeight : 0, 0);
        } else {
            outRect.set(0, 0, 0, itemPosition != (childCount - 1) ? mDividerHeight : 0);
        }
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        if (parent.getLayoutManager() == null) {
            return;
        }
        if (mOrientation == VERTICAL) {
            drawVertical(c, parent);
        } else {
            drawHorizontal(c, parent);
        }
    }

    private void drawVertical(Canvas canvas, RecyclerView parent) {
        final int top = parent.getPaddingTop();
        final int bottom = parent.getMeasuredHeight() - parent.getPaddingBottom();
        final int childSize = parent.getChildCount();
        for (int i = 0; i < childSize; i++) {
            final View child = parent.getChildAt(i);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) child.getLayoutParams();
            final int left = child.getRight() + layoutParams.rightMargin;
            final int right = left + mDividerHeight;
            /*if (mDivider != null) {
                mDivider.setBounds(left, top, right, bottom);
                mDivider.draw(canvas);
            }*/
            if (mPaint != null) {
                canvas.drawRect(left, top, right, bottom, mPaint);
            }
        }
    }

    private void drawHorizontal(Canvas canvas, RecyclerView parent) {
        final int x = parent.getPaddingLeft();
        final int width = parent.getMeasuredWidth() - parent.getPaddingRight();
        //getChildCount()(ViewGroup.getChildCount) 返回的是显示层面上的“所包含的子 View 个数”。
        final int childSize = parent.getChildCount();
        for (int i = 0; i < childSize; i++) {
            final View child = parent.getChildAt(i);
            RecyclerView.LayoutParams layoutParams =
                    (RecyclerView.LayoutParams) child.getLayoutParams();
            //item底部的Y轴坐标+margin值
            final int y = child.getBottom() + layoutParams.bottomMargin;
            final int height = y + mDividerHeight;
            /*if (mDivider != null) {
                mDivider.setBounds(x, y, width, height);
                mDivider.draw(canvas);
            }*/
            if (mPaint != null) {
                canvas.drawRect(x, y, width, height, mPaint);
            }
        }
    }
}
