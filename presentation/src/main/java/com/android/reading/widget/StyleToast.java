package com.android.reading.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.reading.R;
import com.android.reading.model.ToastModel;
import com.android.reading.utils.Utils;

/**
 * Created by Gu FanFan on 2017/2/27 10:37.
 * 吐司, 村文本样式或者带图片样式.
 */

public class StyleToast {

    private Context mContext;
    private Toast mToast;
    private ToastModel mToastModel;
    private int mHorizontalPadding, mVerticalPadding, mDefaultIconSize, mToastBgColor;
    private float mDefaultRadius;

    public StyleToast(Context context, ToastModel toastModel) {
        mContext = context;
        mToastModel = toastModel;
        Resources resources = mContext.getResources();
        mHorizontalPadding = (int) resources.getDimension(R.dimen.default_horizontal_padding);
        mVerticalPadding = (int) resources.getDimension(R.dimen.default_vertical_padding);
        mDefaultIconSize = (int) resources.getDimension(R.dimen.default_toast_image_size);
        mDefaultRadius = resources.getDimension(R.dimen.default_corner_radius);
        mToastBgColor = ContextCompat.getColor(mContext, R.color.default_toast_background);
    }

    public void setToastModel(ToastModel toastModel) {
        mToastModel = toastModel;
    }

    public void show() {
        if (mToast == null)
            mToast = new Toast(mContext);

        mToast.setView(getToastView());
        int duration = mToastModel.getToastDuration();
        if (duration == ToastModel.TOAST_SHORT){
            mToast.setDuration(Toast.LENGTH_SHORT);
        } else {
            mToast.setDuration(Toast.LENGTH_LONG);
        }
        mToast.show();
    }

    private View getToastView() {
        LinearLayout toastLayout = new LinearLayout(mContext);
        if (Utils.hasJellyBean()) {
            toastLayout.setBackground(getToastShape());
        } else {
            toastLayout.setBackgroundDrawable(getToastShape());
        }
        toastLayout.setPadding(mHorizontalPadding, mVerticalPadding, mHorizontalPadding, mVerticalPadding);
        toastLayout.setGravity(Gravity.CENTER);
        toastLayout.setOrientation(LinearLayout.HORIZONTAL);

        int icon = mToastModel.getIcon();
        boolean hasIcon = false;
        if (icon != 0)
            hasIcon = true;

        if (hasIcon)
            toastLayout.addView(getIcon(icon));

        toastLayout.addView(getTextView(hasIcon));
        return toastLayout;
    }

    private GradientDrawable getToastShape() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        float radius = mToastModel.getCornerRadius();
        if (radius > 0){
            gradientDrawable.setCornerRadius(radius);
        } else {
            gradientDrawable.setCornerRadius(mDefaultRadius);
        }

        int color = mToastModel.getBackGroundColor();
        if (radius > 0){
            gradientDrawable.setColor(color);
        } else {
            gradientDrawable.setColor(mToastBgColor);
        }
        return gradientDrawable;
    }

    private TextView getTextView(boolean hasIcon) {
        TextView textView = new TextView(mContext);
        textView.setText(mToastModel.getToastMsg());
        int color = mToastModel.getTextColor();
        if (color == 0) {
            mToastModel.setTextColor(Color.WHITE);
        } else {
            mToastModel.setTextColor(color);
        }
        textView.setMaxLines(1);

        if (hasIcon) {
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.addRule(RelativeLayout.CENTER_IN_PARENT);
            textView.setLayoutParams(params);
        }
        return textView;
    }

    private ImageView getIcon(int icon) {
        ImageView imageView = new ImageView(mContext);
        imageView.setImageDrawable(ContextCompat.getDrawable(mContext, icon));
        imageView.setMaxWidth(mDefaultIconSize);
        imageView.setMaxHeight(mDefaultIconSize);
        imageView.setAdjustViewBounds(true);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.CENTER_VERTICAL);
        imageView.setLayoutParams(params);
        return imageView;
    }
}
