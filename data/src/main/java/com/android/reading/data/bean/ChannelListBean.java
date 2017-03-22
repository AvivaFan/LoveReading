package com.android.reading.data.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Gu FanFan on 2017/3/20 12:52.
 * LoveReading.
 */

public class ChannelListBean extends BaseShowApiResBean {

    private ShowapiResBodyBean showapi_res_body;

    public ShowapiResBodyBean getShowapi_res_body() {
        return showapi_res_body;
    }

    public void setShowapi_res_body(ShowapiResBodyBean showapi_res_body) {
        this.showapi_res_body = showapi_res_body;
    }

    public static class ShowapiResBodyBean implements Parcelable {

        private int totalNum;
        private int ret_code;
        private List<ChannelList> channelList;

        public int getTotalNum() {
            return totalNum;
        }

        public void setTotalNum(int totalNum) {
            this.totalNum = totalNum;
        }

        public int getRet_code() {
            return ret_code;
        }

        public void setRet_code(int ret_code) {
            this.ret_code = ret_code;
        }

        public List<ChannelList> getChannelList() {
            return channelList;
        }

        public void setChannelList(List<ChannelList> channelList) {
            this.channelList = channelList;
        }

        public static class ChannelList implements Parcelable {
            /**
             * channelId : 5572a108b3cdc86cf39001cd
             * name : 国内焦点
             */

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

            public ChannelList() {
            }

            protected ChannelList(Parcel in) {
                this.channelId = in.readString();
                this.name = in.readString();
            }

            public static final Parcelable.Creator<ChannelList> CREATOR = new Parcelable.Creator<ChannelList>() {
                @Override
                public ChannelList createFromParcel(Parcel source) {
                    return new ChannelList(source);
                }

                @Override
                public ChannelList[] newArray(int size) {
                    return new ChannelList[size];
                }
            };
        }

        public ShowapiResBodyBean() {
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.totalNum);
            dest.writeInt(this.ret_code);
            dest.writeTypedList(this.channelList);
        }

        protected ShowapiResBodyBean(Parcel in) {
            this.totalNum = in.readInt();
            this.ret_code = in.readInt();
            this.channelList = in.createTypedArrayList(ChannelList.CREATOR);
        }

        public static final Creator<ShowapiResBodyBean> CREATOR = new Creator<ShowapiResBodyBean>() {
            @Override
            public ShowapiResBodyBean createFromParcel(Parcel source) {
                return new ShowapiResBodyBean(source);
            }

            @Override
            public ShowapiResBodyBean[] newArray(int size) {
                return new ShowapiResBodyBean[size];
            }
        };
    }
}
