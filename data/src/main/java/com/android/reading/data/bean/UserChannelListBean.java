package com.android.reading.data.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Gu FanFan on 2017/3/21 23:47.
 * LoveReading.
 */

public class UserChannelListBean extends BaseAvivaResBean implements Parcelable {

    private List<ChannelBean> data;

    public List<ChannelBean> getData() {
        return data;
    }

    public void setData(List<ChannelBean> data) {
        this.data = data;
    }

    public static class ChannelBean implements Parcelable {
        private int id;
        private int userID;
        private String channelName;
        private String channelId;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getUserID() {
            return userID;
        }

        public void setUserID(int userID) {
            this.userID = userID;
        }

        public String getChannelName() {
            return channelName;
        }

        public void setChannelName(String channelName) {
            this.channelName = channelName;
        }

        public String getChannelId() {
            return channelId;
        }

        public void setChannelId(String channelId) {
            this.channelId = channelId;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.id);
            dest.writeInt(this.userID);
            dest.writeString(this.channelName);
            dest.writeString(this.channelId);
        }

        public ChannelBean() {
        }

        protected ChannelBean(Parcel in) {
            this.id = in.readInt();
            this.userID = in.readInt();
            this.channelName = in.readString();
            this.channelId = in.readString();
        }

        public static final Parcelable.Creator<ChannelBean> CREATOR = new Parcelable.Creator<ChannelBean>() {
            @Override
            public ChannelBean createFromParcel(Parcel source) {
                return new ChannelBean(source);
            }

            @Override
            public ChannelBean[] newArray(int size) {
                return new ChannelBean[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.data);
    }

    public UserChannelListBean() {
    }

    protected UserChannelListBean(Parcel in) {
        this.data = in.createTypedArrayList(ChannelBean.CREATOR);
    }

    public static final Parcelable.Creator<UserChannelListBean> CREATOR = new Parcelable.Creator<UserChannelListBean>() {
        @Override
        public UserChannelListBean createFromParcel(Parcel source) {
            return new UserChannelListBean(source);
        }

        @Override
        public UserChannelListBean[] newArray(int size) {
            return new UserChannelListBean[size];
        }
    };
}
