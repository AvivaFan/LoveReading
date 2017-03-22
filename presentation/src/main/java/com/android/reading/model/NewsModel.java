package com.android.reading.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Gu FanFan on 2017/3/2 22:58.
 * 新闻Model.
 */

public class NewsModel implements Parcelable {

    private int allPages;
    private int currentPage;
    private int allNum;
    private int maxResult;
    private List<ContentListBean> contentlist;

    public int getAllPages() {
        return allPages;
    }

    public void setAllPages(int allPages) {
        this.allPages = allPages;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getAllNum() {
        return allNum;
    }

    public void setAllNum(int allNum) {
        this.allNum = allNum;
    }

    public int getMaxResult() {
        return maxResult;
    }

    public void setMaxResult(int maxResult) {
        this.maxResult = maxResult;
    }

    public List<ContentListBean> getContentlist() {
        return contentlist;
    }

    public void setContentlist(List<ContentListBean> contentlist) {
        this.contentlist = contentlist;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }

    public static class ContentListBean implements Parcelable {

        private String pubDate;
        private boolean havePic;
        private String title;
        private String channelName;
        private String desc;
        private String source;
        private String channelId;
        private String link;
        private List<Object> allList;
        private List<ImageUrlsBean> imageurls;

        public ContentListBean() {
        }

        ContentListBean(Parcel in) {
            pubDate = in.readString();
            havePic = in.readByte() != 0;
            title = in.readString();
            channelName = in.readString();
            desc = in.readString();
            source = in.readString();
            channelId = in.readString();
            link = in.readString();
            imageurls = in.createTypedArrayList(ImageUrlsBean.CREATOR);
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(pubDate);
            dest.writeByte((byte) (havePic ? 1 : 0));
            dest.writeString(title);
            dest.writeString(channelName);
            dest.writeString(desc);
            dest.writeString(source);
            dest.writeString(channelId);
            dest.writeString(link);
            dest.writeTypedList(imageurls);
        }

        @Override
        public int describeContents() {
            return 0;
        }

        public static final Creator<ContentListBean> CREATOR = new Creator<ContentListBean>() {
            @Override
            public ContentListBean createFromParcel(Parcel in) {
                return new ContentListBean(in);
            }

            @Override
            public ContentListBean[] newArray(int size) {
                return new ContentListBean[size];
            }
        };

        public String getPubDate() {
            return pubDate;
        }

        public void setPubDate(String pubDate) {
            this.pubDate = pubDate;
        }

        public boolean isHavePic() {
            return havePic;
        }

        public void setHavePic(boolean havePic) {
            this.havePic = havePic;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getChannelName() {
            return channelName;
        }

        public void setChannelName(String channelName) {
            this.channelName = channelName;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getChannelId() {
            return channelId;
        }

        public void setChannelId(String channelId) {
            this.channelId = channelId;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public List<Object> getAllList() {
            return allList;
        }

        public void setAllList(List<Object> allList) {
            this.allList = allList;
        }

        public List<ImageUrlsBean> getImageurls() {
            return imageurls;
        }

        public void setImageurls(List<ImageUrlsBean> imageurls) {
            this.imageurls = imageurls;
        }

        public static class ImageUrlsBean implements Parcelable {
            private int height;
            private int width;
            private String url;

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(this.height);
                dest.writeInt(this.width);
                dest.writeString(this.url);
            }

            public ImageUrlsBean() {
            }

            protected ImageUrlsBean(Parcel in) {
                this.height = in.readInt();
                this.width = in.readInt();
                this.url = in.readString();
            }

            public static final Parcelable.Creator<ImageUrlsBean> CREATOR = new Parcelable.Creator<ImageUrlsBean>() {
                @Override
                public ImageUrlsBean createFromParcel(Parcel source) {
                    return new ImageUrlsBean(source);
                }

                @Override
                public ImageUrlsBean[] newArray(int size) {
                    return new ImageUrlsBean[size];
                }
            };
        }


    }


}
