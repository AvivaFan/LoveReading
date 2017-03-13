package com.android.reading.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Gu FanFan on 2017/3/10 1:53.
 * LoveReading.
 */

public class CollectionModel implements Parcelable {

    private int mId;
    private String mType;
    private String mTitle;
    private String mUrl;
    private String mImage1;
    private String mImage2;
    private String mImage3;
    private String mUniqueKey;
    private String mFeaturedId;
    private String mHashId;
    private String mContent;
    private boolean mIsHeader;

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public String getImage1() {
        return mImage1;
    }

    public void setImage1(String image1) {
        mImage1 = image1;
    }

    public String getImage2() {
        return mImage2;
    }

    public void setImage2(String image2) {
        mImage2 = image2;
    }

    public String getImage3() {
        return mImage3;
    }

    public void setImage3(String image3) {
        mImage3 = image3;
    }

    public String getUniqueKey() {
        return mUniqueKey;
    }

    public void setUniqueKey(String uniqueKey) {
        mUniqueKey = uniqueKey;
    }

    public String getFeaturedId() {
        return mFeaturedId;
    }

    public void setFeaturedId(String featuredId) {
        mFeaturedId = featuredId;
    }

    public String getHashId() {
        return mHashId;
    }

    public void setHashId(String hashId) {
        mHashId = hashId;
    }

    public String getContent() {
        return mContent;
    }

    public void setContent(String content) {
        mContent = content;
    }

    public boolean getHeader() {
        return mIsHeader;
    }

    public void setHeader(boolean header) {
        mIsHeader = header;
    }

    public CollectionModel() {
    }

    public CollectionModel(String title, boolean isHeader) {
        mTitle = title;
        mIsHeader = isHeader;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mId);
        dest.writeString(this.mType);
        dest.writeString(this.mTitle);
        dest.writeString(this.mUrl);
        dest.writeString(this.mImage1);
        dest.writeString(this.mImage2);
        dest.writeString(this.mImage3);
        dest.writeString(this.mUniqueKey);
        dest.writeString(this.mFeaturedId);
        dest.writeString(this.mHashId);
        dest.writeString(this.mContent);
        dest.writeByte(this.mIsHeader ? (byte) 1 : (byte) 0);
    }

    protected CollectionModel(Parcel in) {
        this.mId = in.readInt();
        this.mType = in.readString();
        this.mTitle = in.readString();
        this.mUrl = in.readString();
        this.mImage1 = in.readString();
        this.mImage2 = in.readString();
        this.mImage3 = in.readString();
        this.mUniqueKey = in.readString();
        this.mFeaturedId = in.readString();
        this.mHashId = in.readString();
        this.mContent = in.readString();
        this.mIsHeader = in.readByte() != 0;
    }

    public static final Creator<CollectionModel> CREATOR = new Creator<CollectionModel>() {
        @Override
        public CollectionModel createFromParcel(Parcel source) {
            return new CollectionModel(source);
        }

        @Override
        public CollectionModel[] newArray(int size) {
            return new CollectionModel[size];
        }
    };
}
