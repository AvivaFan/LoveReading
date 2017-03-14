package com.android.reading.utils;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;

/**
 * Created by Gu FanFan on 2017/3/14 19:10.
 * LoveReading.
 */

public class AnimatorUtils {

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

    public static void startTranslationX(View view,
                                         float starX,
                                         float toX,
                                         boolean whetherToReturn,
                                         long duration) {
        ObjectAnimator translationAnimator;
        if (whetherToReturn) {
            translationAnimator = ObjectAnimator.ofFloat(view, "translationX", starX, toX, starX);
        } else {
            translationAnimator = ObjectAnimator.ofFloat(view, "translationX", starX, toX);
        }
        translationAnimator.setDuration(duration);
        translationAnimator.start();
    }

    public static void startTranslationY(View view,
                                         float starY,
                                         float toY,
                                         boolean whetherToReturn,
                                         long duration) {
        ObjectAnimator translationAnimator;
        if (whetherToReturn) {
            translationAnimator = ObjectAnimator.ofFloat(view, "translationY", starY, toY, starY);
        } else {
            translationAnimator = ObjectAnimator.ofFloat(view, "translationY", starY, toY);
        }
        translationAnimator.setDuration(duration);
        translationAnimator.start();
    }

    public static void startAlpha(View view,
                                         float starValue,
                                         float toValue,
                                         boolean whetherToReturn,
                                         long duration) {
        ObjectAnimator translationAnimator;
        if (whetherToReturn) {
            translationAnimator = ObjectAnimator.ofFloat(view, "alpha", starValue, toValue, starValue);
        } else {
            translationAnimator = ObjectAnimator.ofFloat(view, "translationY", starValue, toValue);
        }
        translationAnimator.setDuration(duration);
        translationAnimator.start();
    }

    public static void startAnimatorSet(ObjectAnimator animator1, ObjectAnimator animator2, long duration) {
        AnimatorSet set = new AnimatorSet();
        set.play(animator1).with(animator2);
        set.setDuration(duration);
        set.start();
    }

    public static void startAnimatorSet(ObjectAnimator animator1, ObjectAnimator animator2, ObjectAnimator animator3, long duration) {
        AnimatorSet set = new AnimatorSet();
        set.play(animator1).with(animator2).with(animator3);
        set.setDuration(duration);
        set.start();
    }

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
