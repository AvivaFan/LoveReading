package com.android.reading.utils;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;

/**
 * Created by Gu FanFan on 2017/3/14 19:10.
 * LoveReading.
 */

public class AnimatorUtils {

    /*
    * 设置 ObjectAnimator
    * */
    public static ObjectAnimator setObjectAnimator(View view,
                                                   String propertyName,
                                                   float starValue,
                                                   float toValue,
                                                   boolean whetherToReturn) {
        ObjectAnimator objectAnimator;
        if (whetherToReturn) {
            objectAnimator = ObjectAnimator.ofFloat(view, propertyName, starValue, toValue, starValue);
        } else {
            objectAnimator = ObjectAnimator.ofFloat(view, propertyName, starValue, toValue);
        }
        return objectAnimator;
    }

    /*
    * 根据X轴平移动画
    * */
    public static void startTranslationX(View view,
                                         float starX,
                                         float toX,
                                         boolean whetherToReturn,
                                         long duration) {
        ObjectAnimator translationXAnimator =
                setObjectAnimator(view, "translationX", starX, toX, whetherToReturn);
        translationXAnimator.setDuration(duration);
        translationXAnimator.start();
    }

    /*
    * 根据Y轴平移动画
    * */
    public static void startTranslationY(View view,
                                         float starY,
                                         float toY,
                                         boolean whetherToReturn,
                                         long duration) {
        ObjectAnimator translationYAnimator =
                setObjectAnimator(view, "translationY", starY, toY, whetherToReturn);
        translationYAnimator.setDuration(duration);
        translationYAnimator.start();
    }

    /*
    * 透明动画
    * */
    public static void startAlpha(View view,
                                  float starValue,
                                  float toValue,
                                  boolean whetherToReturn,
                                  long duration) {
        ObjectAnimator alphaAnimator =
                setObjectAnimator(view, "alpha", starValue, toValue, whetherToReturn);
        alphaAnimator.setDuration(duration);
        alphaAnimator.start();
    }

    /*
    * 根据X轴缩放动画
    **/
    public static void startScaleX(View view,
                                   float starX,
                                   float toX,
                                   boolean whetherToReturn,
                                   long duration) {
        ObjectAnimator scaleXAnimator =
                setObjectAnimator(view, "scaleX", starX, toX, whetherToReturn);
        scaleXAnimator.setDuration(duration);
        scaleXAnimator.start();
    }

    /*
    * 根据X轴缩放动画
    **/
    public static void startScaleY(View view,
                                   float starY,
                                   float toY,
                                   boolean whetherToReturn,
                                   long duration) {
        ObjectAnimator scaleYAnimator =
                setObjectAnimator(view, "scaleY", starY, toY, whetherToReturn);
        scaleYAnimator.setDuration(duration);
        scaleYAnimator.start();
    }

    public static void startRotation(View view,
                                     float starValue,
                                     float toValue,
                                     boolean whetherToReturn,
                                     long duration) {
        ObjectAnimator rotationAnimator =
                setObjectAnimator(view, "rotation", starValue, toValue, whetherToReturn);
        rotationAnimator.setDuration(duration);
        rotationAnimator.start();
    }

    public static void startRotationX(View view,
                                     float starValue,
                                     float toValue,
                                     boolean whetherToReturn,
                                     long duration) {
        ObjectAnimator rotationAnimator =
                setObjectAnimator(view, "rotationX", starValue, toValue, whetherToReturn);
        rotationAnimator.setDuration(duration);
        rotationAnimator.start();
    }

    public static void startRotationY(View view,
                                      float starValue,
                                      float toValue,
                                      boolean whetherToReturn,
                                      long duration) {
        ObjectAnimator rotationAnimator =
                setObjectAnimator(view, "rotationY", starValue, toValue, whetherToReturn);
        rotationAnimator.setDuration(duration);
        rotationAnimator.start();
    }

    /*
    * 动画集合
    * */
    public static void startAnimatorSet(ObjectAnimator animator1,
                                        ObjectAnimator animator2,
                                        long duration) {
        AnimatorSet set = new AnimatorSet();
        set.play(animator1).with(animator2);
        set.setDuration(duration);
        set.start();
    }

    /*
    * 动画集合
    * */
    public static void startAnimatorSet(ObjectAnimator animator1,
                                        ObjectAnimator animator2,
                                        ObjectAnimator animator3,
                                        long duration) {
        AnimatorSet set = new AnimatorSet();
        set.play(animator1).with(animator2).with(animator3);
        set.setDuration(duration);
        set.start();
    }

    /*
    * 动画集合
    * */
    public static void startAnimatorSet(ObjectAnimator animator1,
                                        ObjectAnimator animator2,
                                        ObjectAnimator animator3,
                                        ObjectAnimator animator4,
                                        long duration) {
        AnimatorSet set = new AnimatorSet();
        set.play(animator1).with(animator2).with(animator3).with(animator4);
        set.setDuration(duration);
        set.start();
    }
}
