package com.android.reading.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Gu FanFan on 2017/3/11 0:06.
 * LoveReading.
 */

public class ColorModel implements Parcelable {

    private boolean isHeader;
    private String headerName;
    private int color;

    public ColorModel(boolean isHeader, String headerName) {
        this.isHeader = isHeader;
        this.headerName = headerName;
    }

    public ColorModel(int color) {
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

    protected ColorModel(Parcel in) {
        this.isHeader = in.readByte() != 0;
        this.headerName = in.readString();
        this.color = in.readInt();
    }

    public static final Parcelable.Creator<ColorModel> CREATOR = new Parcelable.Creator<ColorModel>() {
        @Override
        public ColorModel createFromParcel(Parcel source) {
            return new ColorModel(source);
        }

        @Override
        public ColorModel[] newArray(int size) {
            return new ColorModel[size];
        }
    };
}
