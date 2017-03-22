package com.android.reading.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Gu FanFan on 2017/3/20 13:44.
 * LoveReading.
 */

public class ChannelListModel implements Parcelable {

    private String channelId;
    private String name;

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.channelId);
        dest.writeString(this.name);
    }

    public ChannelListModel() {
    }

    public ChannelListModel(String channelId, String name) {
        this.channelId = channelId;
        this.name = name;
    }

    protected ChannelListModel(Parcel in) {
        this.channelId = in.readString();
        this.name = in.readString();
    }

    public static final Parcelable.Creator<ChannelListModel> CREATOR = new Parcelable.Creator<ChannelListModel>() {
        @Override
        public ChannelListModel createFromParcel(Parcel source) {
            return new ChannelListModel(source);
        }

        @Override
        public ChannelListModel[] newArray(int size) {
            return new ChannelListModel[size];
        }
    };
}
