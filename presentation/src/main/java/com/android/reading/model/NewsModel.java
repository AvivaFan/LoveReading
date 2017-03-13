package com.android.reading.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Gu FanFan on 2017/3/2 22:58.
 * 新闻Model.
 */

public class NewsModel implements Parcelable {

    /**
     * uniquekey : 0dd68ef75a59efedcb98e89824cf28d1
     * title : 广州一小学招生 要求家长本科以上学历
     * date : 2017-03-05 12:57
     * category : 头条
     * author_name : 广东广播电视台今日最新闻
     * url : http://mini.eastday.com/mobile/170305125724254.html
     * thumbnail_pic_s : http://07.imgmini.eastday.com/mobile/20170305/20170305125724_6b99ec7617c9dc2ff7a08789ef05f691_1_mwpm_03200403.jpeg
     * thumbnail_pic_s02 : http://07.imgmini.eastday.com/mobile/20170305/20170305125724_6b99ec7617c9dc2ff7a08789ef05f691_2_mwpm_03200403.jpeg
     * thumbnail_pic_s03 : http://07.imgmini.eastday.com/mobile/20170305/20170305125724_6b99ec7617c9dc2ff7a08789ef05f691_3_mwpm_03200403.jpeg
     */

    private String uniquekey;
    private String title;
    private String date;
    private String category;
    private String author_name;
    private String url;
    private String thumbnail_pic_s;
    private String thumbnail_pic_s02;
    private String thumbnail_pic_s03;

    public String getUniquekey() {
        return uniquekey;
    }

    public void setUniquekey(String uniquekey) {
        this.uniquekey = uniquekey;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnail_pic_s() {
        return thumbnail_pic_s;
    }

    public void setThumbnail_pic_s(String thumbnail_pic_s) {
        this.thumbnail_pic_s = thumbnail_pic_s;
    }

    public String getThumbnail_pic_s02() {
        return thumbnail_pic_s02;
    }

    public void setThumbnail_pic_s02(String thumbnail_pic_s02) {
        this.thumbnail_pic_s02 = thumbnail_pic_s02;
    }

    public String getThumbnail_pic_s03() {
        return thumbnail_pic_s03;
    }

    public void setThumbnail_pic_s03(String thumbnail_pic_s03) {
        this.thumbnail_pic_s03 = thumbnail_pic_s03;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.uniquekey);
        dest.writeString(this.title);
        dest.writeString(this.date);
        dest.writeString(this.category);
        dest.writeString(this.author_name);
        dest.writeString(this.url);
        dest.writeString(this.thumbnail_pic_s);
        dest.writeString(this.thumbnail_pic_s02);
        dest.writeString(this.thumbnail_pic_s03);
    }

    public NewsModel() {
    }

    protected NewsModel(Parcel in) {
        this.uniquekey = in.readString();
        this.title = in.readString();
        this.date = in.readString();
        this.category = in.readString();
        this.author_name = in.readString();
        this.url = in.readString();
        this.thumbnail_pic_s = in.readString();
        this.thumbnail_pic_s02 = in.readString();
        this.thumbnail_pic_s03 = in.readString();
    }

    public static final Parcelable.Creator<NewsModel> CREATOR = new Parcelable.Creator<NewsModel>() {
        @Override
        public NewsModel createFromParcel(Parcel source) {
            return new NewsModel(source);
        }

        @Override
        public NewsModel[] newArray(int size) {
            return new NewsModel[size];
        }
    };
}
