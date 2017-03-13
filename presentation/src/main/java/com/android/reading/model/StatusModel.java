package com.android.reading.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Gu FanFan on 2017/3/10 6:00.
 * LoveReading.
 */

public class StatusModel implements Parcelable {

    private boolean status;
    private String msg;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte(this.status ? (byte) 1 : (byte) 0);
        dest.writeString(this.msg);
    }

    public StatusModel() {
    }

    protected StatusModel(Parcel in) {
        this.status = in.readByte() != 0;
        this.msg = in.readString();
    }

    public static final Parcelable.Creator<StatusModel> CREATOR = new Parcelable.Creator<StatusModel>() {
        @Override
        public StatusModel createFromParcel(Parcel source) {
            return new StatusModel(source);
        }

        @Override
        public StatusModel[] newArray(int size) {
            return new StatusModel[size];
        }
    };
}
