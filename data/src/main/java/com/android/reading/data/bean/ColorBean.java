package com.android.reading.data.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Gu FanFan on 2017/3/11 0:06.
 * LoveReading.
 */

public class ColorBean implements Parcelable {

    private boolean isHeader;
    private String headerName;
    private int color;

    public ColorBean(boolean isHeader, String headerName) {
        this.isHeader = isHeader;
        this.headerName = headerName;
    }

    public ColorBean(int color) {
        this.color = color;
    }

    public boolean isHeader() {
        return isHeader;
    }

    public void setHeader(boolean header) {
        isHeader = header;
    }

    public String getHeaderName() {
        return headerName;
    }

    public void setHeaderName(String headerName) {
        this.headerName = headerName;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte(this.isHeader ? (byte) 1 : (byte) 0);
        dest.writeString(this.headerName);
        dest.writeInt(this.color);
    }

    protected ColorBean(Parcel in) {
        this.isHeader = in.readByte() != 0;
        this.headerName = in.readString();
        this.color = in.readInt();
    }

    public static final Creator<ColorBean> CREATOR = new Creator<ColorBean>() {
        @Override
        public ColorBean createFromParcel(Parcel source) {
            return new ColorBean(source);
        }

        @Override
        public ColorBean[] newArray(int size) {
            return new ColorBean[size];
        }
    };
}
