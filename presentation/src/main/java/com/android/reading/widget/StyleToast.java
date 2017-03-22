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
import com.android.reading.utils.Utils;

/**
 * Created by Gu FanFan on 2017/2/27 10:37.
 * 吐司, 存文本样式或者带图片样式.
 */

public class StyleToast {

    private Context mContext;
    private Toast mToast;
    private int mHorizontalPadding, mVerticalPadding, mDefaultIconSize, mToastBgColor;
    private float mDefaultRadius;
    private int mDuration;
    private String mToastMsg;
    private int mIconRes;

    public StyleToast(Context context) {
        mContext = context;
        initToast(context.getResources());
    }

    private void initToast(Resources resources) {
        mHorizontalPadding = (int) resources.getDimension(R.dimen.common_padding);
        mVerticalPadding = (int) resources.getDimension(R.dimen.common_padding);
        mDefaultIconSize = (int) resources.getDimension(R.dimen.common_image_size);
        mDefaultRadius = resources.getDimension(R.dimen.common_radius);
        mToastBgColor = ContextCompat.getColor(mContext, R.color.colorGray);
    }

    public void setToastBgColor(int toastBgColor) {
        mToastBgColor = toastBgColor;
    }

    public void setDuration(int duration) {
        mDuration = duration;
    }

    public void setToastMsg(String toastMsg) {
        mToastMsg = toastMsg;
    }

    public void setIconRes(int iconRes) {
        mIconRes = iconRes;
    }

    public void show() {
        if (mToast == null)
            mToast = new Toast(mContext);

        mToast.setView(getToastView());
        mToast.setDuration(mDuration);
        mToast.show();
    }

    private View getToastView() {
        LinearLayout toastLayout = new LinearLayout(mContext);
        if (Utils.hasJellyBean())
            toastLayout.setBackground(getToastShape());
        toastLayout.setPadding(mHorizontalPadding, mVerticalPadding, mHorizontalPadding, mVerticalPadding);
        toastLayout.setGravity(Gravity.CENTER);
        toastLayout.setOrientation(LinearLayout.HORIZONTAL);

        boolean hasIcon = false;
        if (mIconRes != 0)
            hasIcon = true;

        if (hasIcon)
            toastLayout.addView(getIcon(mIconRes));

        toastLayout.addView(getTextView(hasIcon));
        return toastLayout;
    }

    private GradientDrawable getToastShape() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(mDefaultRadius);
        gradientDrawable.setColor(mToastBgColor);
        return gradientDrawable;
    }

    private TextView getTextView(boolean hasIcon) {
        TextView textView = new TextView(mContext);
        textView.setText(mToastMsg);
        textView.setTextColor(Color.WHITE);
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
