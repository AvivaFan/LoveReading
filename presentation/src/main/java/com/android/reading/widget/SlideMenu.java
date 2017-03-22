package com.android.reading.widget;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * Created by Gu FanFan on 2017/3/20 16:20.
 * LoveReading.
 */

public class SlideMenu extends FrameLayout {

    private static final int DRAG_LEFT = 0;
    private static final int DRAG_RIGHT = 1;

    private ViewDragHelper mDragHelper;
    private View mLeftView;
    private ViewGroup mCenterView;
    private int mViewDragRange;
    private boolean isOpen = false;
    private int mLeftWidth;
    private int mLeftViewRight;
    private int mCenterViewLeft;
    private int mCenterViewTop;
    private int mDragOrientation;

    public SlideMenu(@NonNull Context context) {
        this(context, null);
    }

    public SlideMenu(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SlideMenu(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mDragHelper = ViewDragHelper.create(this, 1.0f, mHelperCallBack);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mLeftView = getChildAt(0);
        mCenterView = (ViewGroup) getChildAt(1);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mLeftWidth = mLeftView.getMeasuredWidth();
        mLeftViewRight = mLeftView.getRight();
        mCenterViewLeft = mCenterView.getLeft();
        mCenterViewTop = mCenterView.getTop();
    }

    @Override
    public boolean onInterceptHoverEvent(MotionEvent event) {
        return mDragHelper.shouldInterceptTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mDragHelper.processTouchEvent(event);
        return true;
    }

    @Override
    public void computeScroll() {
        if (mDragHelper.continueSettling(true)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    /**
     * 打开
     */
    public void open() {
        if (mDragHelper.smoothSlideViewTo(
                mCenterView, mLeftWidth, 0)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }

        isOpen = true;
    }

    /**
     * 关闭
     */
    public void close() {
        if (mDragHelper.smoothSlideViewTo(mCenterView, 0, 0)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }

        isOpen = false;
    }

    public boolean isOpen() {
        return isOpen;
    }

    private ViewDragHelper.Callback mHelperCallBack = new ViewDragHelper.Callback() {

        @Override
        public boolean tryCaptureView(View child, int pointerId) {
            return mCenterView == child;
        }

        @Override
        public int getViewHorizontalDragRange(View child) {
            return mLeftWidth;
        }

        @Override
        public int clampViewPositionHorizontal(View child, int left, int dx) {
            if (child == mCenterView) {
                if (left < 0) {
                    return 0;
                } else if (left > mLeftWidth) {
                    return mLeftWidth;
                } else {
                    return left;
                }
            } else {
                if (left > 0) {
                    return 0;
                } else if (left > mLeftWidth) {
                    return mLeftWidth;
                } else {
                    return left;
                }
            }
        }

        @Override
        public void onViewPositionChanged(View changedView, int left, int top, int dx, int dy) {
            mViewDragRange = left;
            if (dx > 0) {
                mDragOrientation = DRAG_RIGHT;//从左往右
            } else if (dx < 0) {
                mDragOrientation = DRAG_LEFT;//从右往左
            }
        }

        @Override
        public void onViewReleased(View releasedChild, float xvel, float yvel) {
            if (mDragOrientation == DRAG_LEFT) {
                if ((mLeftWidth - mViewDragRange) >= mLeftWidth / 2) {
                    close();
                } else {
                    mDragHelper.settleCapturedViewAt(mLeftViewRight, mCenterViewTop);
                    invalidate();
                }
            } else {
                if (mViewDragRange >= mLeftWidth / 2) {
                    open();
                } else {
                    mDragHelper.settleCapturedViewAt(mCenterViewLeft, mCenterViewTop);
                    invalidate();
                }
            }
        }
    };
}
