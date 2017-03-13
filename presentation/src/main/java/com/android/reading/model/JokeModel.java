package com.android.reading.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Gu FanFan on 2017/3/7 3:53.
 * LoveReading.
 */

public class JokeModel implements Parcelable {

    private String content;
    private String hashId;
    private String unixtime;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHashId() {
        return hashId;
    }

    public void setHashId(String hashId) {
        this.hashId = hashId;
    }

    public String getUnixtime() {
        return unixtime;
    }

    public void setUnixtime(String unixtime) {
        this.unixtime = unixtime;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.content);
        dest.writeString(this.hashId);
        dest.writeString(this.unixtime);
    }

    public JokeModel() {
    }

    protected JokeModel(Parcel in) {
        this.content = in.readString();
        this.hashId = in.readString();
        this.unixtime = in.readString();
    }

    public static final Parcelable.Creator<JokeModel> CREATOR = new Parcelable.Creator<JokeModel>() {
        @Override
        public JokeModel createFromParcel(Parcel source) {
            return new JokeModel(source);
        }

        @Override
        public JokeModel[] newArray(int size) {
            return new JokeModel[size];
        }
    };
}
