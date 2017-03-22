package com.android.reading.data.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gu FanFan on 2017/3/2 21:04.
 * 新闻Bean.
 */

public class NewsBean extends BaseShowApiResBean implements Parcelable {


    private ShowapiResBodyBean showapi_res_body;

    public ShowapiResBodyBean getShowapi_res_body() {
        return showapi_res_body;
    }

    public void setShowapi_res_body(ShowapiResBodyBean showapi_res_body) {
        this.showapi_res_body = showapi_res_body;
    }

    public static class ShowapiResBodyBean implements Parcelable {


        private int ret_code;
        private PagebeanBean pagebean;

        public int getRet_code() {
            return ret_code;
        }

        public void setRet_code(int ret_code) {
            this.ret_code = ret_code;
        }

        public PagebeanBean getPagebean() {
            return pagebean;
        }

        public void setPagebean(PagebeanBean pagebean) {
            this.pagebean = pagebean;
        }

        public static class PagebeanBean implements Parcelable {


            private int allPages;
            private int currentPage;
            private int allNum;
            private int maxResult;
            private List<ContentlistBean> contentlist;

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

            public List<ContentlistBean> getContentlist() {
                return contentlist;
            }

            public void setContentlist(List<ContentlistBean> contentlist) {
                this.contentlist = contentlist;
            }

            public static class ContentlistBean implements Parcelable {

                private String pubDate;
                private boolean havePic;
                private String title;
                private String channelName;
                private String desc;
                private String source;
                private String channelId;
                private String link;
                private List<Object> allList;
                private List<ImageurlsBean> imageurls;

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

                public List<ImageurlsBean> getImageurls() {
                    return imageurls;
                }

                public void setImageurls(List<ImageurlsBean> imageurls) {
                    this.imageurls = imageurls;
                }

                public static class ImageurlsBean implements Parcelable {

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

                    public ImageurlsBean() {
                    }

                    protected ImageurlsBean(Parcel in) {
                        this.height = in.readInt();
                        this.width = in.readInt();
                        this.url = in.readString();
                    }

                    public static final Parcelable.Creator<ImageurlsBean> CREATOR = new Parcelable.Creator<ImageurlsBean>() {
                        @Override
                        public ImageurlsBean createFromParcel(Parcel source) {
                            return new ImageurlsBean(source);
                        }

                        @Override
                        public ImageurlsBean[] newArray(int size) {
                            return new ImageurlsBean[size];
                        }
                    };
                }

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeString(this.pubDate);
                    dest.writeByte(this.havePic ? (byte) 1 : (byte) 0);
                    dest.writeString(this.title);
                    dest.writeString(this.channelName);
                    dest.writeString(this.desc);
                    dest.writeString(this.source);
                    dest.writeString(this.channelId);
                    dest.writeString(this.link);
                    dest.writeList(this.allList);
                    dest.writeTypedList(this.imageurls);
                }

                public ContentlistBean() {
                }

                protected ContentlistBean(Parcel in) {
                    this.pubDate = in.readString();
                    this.havePic = in.readByte() != 0;
                    this.title = in.readString();
                    this.channelName = in.readString();
                    this.desc = in.readString();
                    this.source = in.readString();
                    this.channelId = in.readString();
                    this.link = in.readString();
                    this.allList = new ArrayList<Object>();
                    in.readList(this.allList, Object.class.getClassLoader());
                    this.imageurls = in.createTypedArrayList(ImageurlsBean.CREATOR);
                }

                public static final Parcelable.Creator<ContentlistBean> CREATOR = new Parcelable.Creator<ContentlistBean>() {
                    @Override
                    public ContentlistBean createFromParcel(Parcel source) {
                        return new ContentlistBean(source);
                    }

                    @Override
                    public ContentlistBean[] newArray(int size) {
                        return new ContentlistBean[size];
                    }
                };
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(this.allPages);
                dest.writeInt(this.currentPage);
                dest.writeInt(this.allNum);
                dest.writeInt(this.maxResult);
                dest.writeTypedList(this.contentlist);
            }

            public PagebeanBean() {
            }

            protected PagebeanBean(Parcel in) {
                this.allPages = in.readInt();
                this.currentPage = in.readInt();
                this.allNum = in.readInt();
                this.maxResult = in.readInt();
                this.contentlist = in.createTypedArrayList(ContentlistBean.CREATOR);
            }

            public static final Parcelable.Creator<PagebeanBean> CREATOR = new Parcelable.Creator<PagebeanBean>() {
                @Override
                public PagebeanBean createFromParcel(Parcel source) {
                    return new PagebeanBean(source);
                }

                @Override
                public PagebeanBean[] newArray(int size) {
                    return new PagebeanBean[size];
                }
            };
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.ret_code);
            dest.writeParcelable(this.pagebean, flags);
        }

        public ShowapiResBodyBean() {
        }

        protected ShowapiResBodyBean(Parcel in) {
            this.ret_code = in.readInt();
            this.pagebean = in.readParcelable(PagebeanBean.class.getClassLoader());
        }

        public static final Parcelable.Creator<ShowapiResBodyBean> CREATOR = new Parcelable.Creator<ShowapiResBodyBean>() {
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.showapi_res_body, flags);
    }

    public NewsBean() {
    }

    protected NewsBean(Parcel in) {
        this.showapi_res_body = in.readParcelable(ShowapiResBodyBean.class.getClassLoader());
    }

    public static final Parcelable.Creator<NewsBean> CREATOR = new Parcelable.Creator<NewsBean>() {
        @Override
        public NewsBean createFromParcel(Parcel source) {
            return new NewsBean(source);
        }

        @Override
        public NewsBean[] newArray(int size) {
            return new NewsBean[size];
        }
    };
}
