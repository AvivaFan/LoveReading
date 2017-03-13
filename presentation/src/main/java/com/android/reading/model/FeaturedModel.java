package com.android.reading.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Gu FanFan on 2017/3/8 8:31.
 * LoveReading.
 */

public class FeaturedModel implements Parcelable {

    private String id;
    private String title;
    private String source;
    private String firstImg;
    private String mark;
    private String url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getFirstImg() {
        return firstImg;
    }

    public void setFirstImg(String firstImg) {
        this.firstImg = firstImg;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
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
        dest.writeString(this.id);
        dest.writeString(this.title);
        dest.writeString(this.source);
        dest.writeString(this.firstImg);
        dest.writeString(this.mark);
        dest.writeString(this.url);
    }

    public FeaturedModel() {
    }

    protected FeaturedModel(Parcel in) {
        this.id = in.readString();
        this.title = in.readString();
        this.source = in.readString();
        this.firstImg = in.readString();
        this.mark = in.readString();
        this.url = in.readString();
    }

    public static final Parcelable.Creator<FeaturedModel> CREATOR = new Parcelable.Creator<FeaturedModel>() {
        @Override
        public FeaturedModel createFromParcel(Parcel source) {
            return new FeaturedModel(source);
        }

        @Override
        public FeaturedModel[] newArray(int size) {
            return new FeaturedModel[size];
        }
    };
}
