package com.android.reading.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Gu FanFan on 2017/2/27 11:07.
 * DemoCollection.
 */

public class ToastModel implements Parcelable {

    public static final int TOAST_SHORT = 0;
    public static final int TOAST_LONG = 1;

    private String mToastMsg;
    private int mToastDuration, mTextColor, mBackGroundColor, mIcon;
    private float mCornerRadius;
    private boolean isDynamicIcon;

    public ToastModel(String toastMsg, int toastDuration) {
        mToastMsg = toastMsg;
        mToastDuration = toastDuration;
    }

    public ToastModel(String toastMsg, int toastDuration, int icon) {
        mToastMsg = toastMsg;
        mToastDuration = toastDuration;
        mIcon = icon;
    }

    public String getToastMsg() {
        return mToastMsg;
    }

    public void setToastMsg(String toastMsg) {
        mToastMsg = toastMsg;
    }

    public int getToastDuration() {
        return mToastDuration;
    }

    public void setToastDuration(int toastDuration) {
        mToastDuration = toastDuration;
    }

    public int getTextColor() {
        return mTextColor;
    }

    public void setTextColor(int textColor) {
        mTextColor = textColor;
    }

    public int getBackGroundColor() {
        return mBackGroundColor;
    }

    public void setBackGroundColor(int backGroundColor) {
        mBackGroundColor = backGroundColor;
    }

    public float getCornerRadius() {
        return mCornerRadius;
    }

    public void setCornerRadius(float cornerRadius) {
        mCornerRadius = cornerRadius;
    }

    public boolean isDynamicIcon() {
        return isDynamicIcon;
    }

    public void setDynamicIcon(boolean dynamicIcon) {
        isDynamicIcon = dynamicIcon;
    }

    public int getIcon() {
        return mIcon;
    }

    public void setIcon(int icon) {
        mIcon = icon;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mToastMsg);
        dest.writeInt(this.mToastDuration);
        dest.writeInt(this.mTextColor);
        dest.writeInt(this.mBackGroundColor);
        dest.writeInt(this.mIcon);
        dest.writeFloat(this.mCornerRadius);
        dest.writeByte(this.isDynamicIcon ? (byte) 1 : (byte) 0);
    }

    public ToastModel() {
    }

    protected ToastModel(Parcel in) {
        this.mToastMsg = in.readString();
        this.mToastDuration = in.readInt();
        this.mTextColor = in.readInt();
        this.mBackGroundColor = in.readInt();
        this.mIcon = in.readInt();
        this.mCornerRadius = in.readFloat();
        this.isDynamicIcon = in.readByte() != 0;
    }

    public static final Creator<ToastModel> CREATOR = new Creator<ToastModel>() {
        @Override
        public ToastModel createFromParcel(Parcel source) {
            return new ToastModel(source);
        }

        @Override
        public ToastModel[] newArray(int size) {
            return new ToastModel[size];
        }
    };
}
