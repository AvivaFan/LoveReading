package com.android.reading.view.ui.adapter;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.animation.BounceInterpolator;

import com.android.reading.BR;
import com.android.reading.interactive.ClickHandler;

/**
 * Created by Gu FanFan on 2017/2/16 23:07.
 * Brief.
 */

public class BaseViewHolder extends RecyclerView.ViewHolder {

    public ViewDataBinding mBinding;

    public BaseViewHolder(ViewDataBinding binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    /**
     * 不包含点击事件
     */
    public void bind(Object o) {
        mBinding.setVariable(BR.model, o);
        mBinding.executePendingBindings();

        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator objectAnimatorX = ObjectAnimator.ofFloat(mBinding.getRoot(), "scaleX", 0.5f, 1);
        ObjectAnimator objectAnimatorY = ObjectAnimator.ofFloat(mBinding.getRoot(), "scaleY", 0.5f, 1);
        animatorSet.setInterpolator(new BounceInterpolator());
        animatorSet.setDuration(400);
        animatorSet.play(objectAnimatorX).with(objectAnimatorY);
        animatorSet.start();
    }

    /**
     * 含点击事件
     */
    public void bind(Object o, ClickHandler clickHandler) {
        mBinding.setVariable(BR.model, o);
        mBinding.setVariable(BR.clickHandler, clickHandler);
        mBinding.executePendingBindings();

        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator objectAnimatorX = ObjectAnimator.ofFloat(mBinding.getRoot(), "scaleX", 0.5f, 1);
        ObjectAnimator objectAnimatorY = ObjectAnimator.ofFloat(mBinding.getRoot(), "scaleY", 0.5f, 1);
        animatorSet.setInterpolator(new BounceInterpolator());
        animatorSet.setDuration(400);
        animatorSet.play(objectAnimatorX).with(objectAnimatorY);
        animatorSet.start();
    }
}
