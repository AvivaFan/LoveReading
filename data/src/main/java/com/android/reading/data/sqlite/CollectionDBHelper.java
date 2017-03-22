package com.android.reading.data.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.android.reading.data.Utils;
import com.android.reading.data.bean.CollectionBean;
import com.android.reading.data.bean.FeaturedBean;
import com.android.reading.data.bean.JokeBean;

import java.util.ArrayList;
import java.util.List;

import static com.android.reading.data.sqlite.CommDatabase.Collection.COLLECTION_CONTENT;
import static com.android.reading.data.sqlite.CommDatabase.Collection.COLLECTION_FEATURED_ID;
import static com.android.reading.data.sqlite.CommDatabase.Collection.COLLECTION_HASH_ID;
import static com.android.reading.data.sqlite.CommDatabase.Collection.COLLECTION_ID;
import static com.android.reading.data.sqlite.CommDatabase.Collection.COLLECTION_IMAGE_1;
import static com.android.reading.data.sqlite.CommDatabase.Collection.COLLECTION_IMAGE_2;
import static com.android.reading.data.sqlite.CommDatabase.Collection.COLLECTION_IMAGE_3;
import static com.android.reading.data.sqlite.CommDatabase.Collection.COLLECTION_TITLE;
import static com.android.reading.data.sqlite.CommDatabase.Collection.COLLECTION_TYPE;
import static com.android.reading.data.sqlite.CommDatabase.Collection.COLLECTION_TYPE_FEATURED;
import static com.android.reading.data.sqlite.CommDatabase.Collection.COLLECTION_TYPE_JOKE;
import static com.android.reading.data.sqlite.CommDatabase.Collection.COLLECTION_TYPE_NEWS;
import static com.android.reading.data.sqlite.CommDatabase.Collection.COLLECTION_UNIQUE_KEY;
import static com.android.reading.data.sqlite.CommDatabase.Collection.COLLECTION_URL;
import static com.android.reading.data.sqlite.CommDatabase.Collection.TABLE_NAME;


/**
 * Created by Gu FanFan on 2017/3/9 20:40.
 * LoveReading.
 */

public class CollectionDBHelper extends CommDBManager {

    private SQLiteDatabase mSQLiteDatabase;

    public CollectionDBHelper(Context context) {
        super(context);
        mSQLiteDatabase = getSQLiteDatabase();
    }

    /**
     * 插入数据
     */
    public boolean insertCollection(Object o) {
        boolean isInsert = false;

        if (o instanceof JokeBean.ResultBean) {
            isInsert = insertJoke((JokeBean.ResultBean) o);
        } else if (o instanceof FeaturedBean.ResultBean.ListBean) {
            isInsert = insertFeature((FeaturedBean.ResultBean.ListBean) o);
        } else if (o instanceof CollectionBean) {
            isInsert = insertCollection((CollectionBean) o);
        }

        return isInsert;
    }

    /**
     * 插入段子数据
     */
    private boolean insertJoke(JokeBean.ResultBean resultBean) {
        mSQLiteDatabase.beginTransaction();

        ContentValues cvs = new ContentValues();
        cvs.put(COLLECTION_TYPE, COLLECTION_TYPE_JOKE);

        String hashId = resultBean.getHashId();
        String content = resultBean.getContent();
        if (!Utils.isEmpty(hashId))
            cvs.put(COLLECTION_HASH_ID, hashId);
        if (!Utils.isEmpty(content))
            cvs.put(COLLECTION_CONTENT, content);

        long id = mSQLiteDatabase.insert(TABLE_NAME, null, cvs);
        mSQLiteDatabase.setTransactionSuccessful();
        mSQLiteDatabase.endTransaction();
        return id != -1;
    }

    /**
     * 插入微信精选数据
     */
    private boolean insertFeature(FeaturedBean.ResultBean.ListBean listBean) {
        mSQLiteDatabase.beginTransaction();

        ContentValues cvs = new ContentValues();
        cvs.put(COLLECTION_TYPE, COLLECTION_TYPE_FEATURED);

        String title = listBean.getTitle();
        String image1 = listBean.getFirstImg();
        String url = listBean.getUrl();
        String featuredId = listBean.getId();
        if (!Utils.isEmpty(title))
            cvs.put(COLLECTION_TITLE, title);
        if (!Utils.isEmpty(url))
            cvs.put(COLLECTION_URL, url);
        if (!Utils.isEmpty(image1))
            cvs.put(COLLECTION_IMAGE_1, image1);
        if (!Utils.isEmpty(featuredId))
            cvs.put(COLLECTION_FEATURED_ID, featuredId);

        long id = mSQLiteDatabase.insert(TABLE_NAME, null, cvs);
        mSQLiteDatabase.setTransactionSuccessful();
        mSQLiteDatabase.endTransaction();
        return id != -1;
    }

    /**
     * 插入收藏数据
     */
    private boolean insertCollection(CollectionBean collectionBean) {
        mSQLiteDatabase.beginTransaction();

        ContentValues cvs = new ContentValues();
        cvs.put(COLLECTION_TYPE, collectionBean.getType());
        cvs.put(COLLECTION_TITLE, collectionBean.getTitle());
        cvs.put(COLLECTION_URL, collectionBean.getUrl());
        cvs.put(COLLECTION_IMAGE_1, collectionBean.getImage1());
        cvs.put(COLLECTION_IMAGE_2, collectionBean.getImage2());
        cvs.put(COLLECTION_IMAGE_3, collectionBean.getImage3());
        cvs.put(COLLECTION_UNIQUE_KEY, collectionBean.getUniqueKey());
        cvs.put(COLLECTION_FEATURED_ID, collectionBean.getFeaturedId());
        cvs.put(COLLECTION_HASH_ID, collectionBean.getHashId());
        cvs.put(COLLECTION_CONTENT, collectionBean.getContent());

        long id = mSQLiteDatabase.insert(TABLE_NAME, null, cvs);
        mSQLiteDatabase.setTransactionSuccessful();
        mSQLiteDatabase.endTransaction();
        return id != -1;
    }

    /**
     * 删除数据
     */
    public boolean deleteCollection(Object o) {
        String whereClause = null;
        String[] whereArgs = null;

        if (o instanceof JokeBean.ResultBean) {
            JokeBean.ResultBean resultBean = (JokeBean.ResultBean) o;
            whereClause = COLLECTION_TYPE + "=? AND " + COLLECTION_HASH_ID + "=?";
            whereArgs = new String[]{COLLECTION_TYPE_NEWS, resultBean.getHashId()};
        } else if (o instanceof FeaturedBean.ResultBean.ListBean) {
            FeaturedBean.ResultBean.ListBean listBean = (FeaturedBean.ResultBean.ListBean) o;
            whereClause = COLLECTION_TYPE + "=? AND " + COLLECTION_HASH_ID + "=?";
            whereArgs = new String[]{COLLECTION_TYPE_FEATURED, listBean.getId()};
        } else if (o instanceof CollectionBean) {
            CollectionBean collectionBean = (CollectionBean) o;
            whereClause = COLLECTION_ID + "=?";
            whereArgs = new String[]{String.valueOf(collectionBean.getId())};
        }

        mSQLiteDatabase.beginTransaction();
        int id = mSQLiteDatabase.delete(TABLE_NAME, whereClause, whereArgs);
        mSQLiteDatabase.setTransactionSuccessful();
        mSQLiteDatabase.endTransaction();
        return id > 0;
    }

    public List<CollectionBean> queryCollection(String type) {
        String selection = COLLECTION_TYPE + "=?";
        String[] selectionArgs = {type};
        Cursor cursor = mSQLiteDatabase.
                query(TABLE_NAME, null,
                        selection, selectionArgs, null, null, null);
        return getCollectionList(cursor);
    }

    public boolean queryCollection(Object o) {
        String selection = null;
        String[] selectionArgs = null;

        if (o instanceof JokeBean.ResultBean) {
            JokeBean.ResultBean resultBean = (JokeBean.ResultBean) o;
            selection = COLLECTION_TYPE + "=? AND " + COLLECTION_HASH_ID + "=?";
            selectionArgs = new String[]{COLLECTION_TYPE_NEWS, resultBean.getHashId()};
        } else if (o instanceof FeaturedBean.ResultBean.ListBean) {
            FeaturedBean.ResultBean.ListBean listBean = (FeaturedBean.ResultBean.ListBean) o;
            selection = COLLECTION_TYPE + "=? AND " + COLLECTION_HASH_ID + "=?";
            selectionArgs = new String[]{COLLECTION_TYPE_FEATURED, listBean.getId()};
        } else if (o instanceof CollectionBean) {
            CollectionBean collectionBean = (CollectionBean) o;
            selection = COLLECTION_ID + "=?";
            selectionArgs = new String[]{String.valueOf(collectionBean.getId())};
        }

        Cursor cursor = mSQLiteDatabase.
                query(TABLE_NAME, null,
                        selection, selectionArgs, null, null, null);
        return getCollection(cursor) != null;
    }

    private CollectionBean getCollection(Cursor cursor) {
        if (!cursor.moveToFirst() && cursor.getCount() == 0)
            return null;

        cursor.moveToFirst();
        return transFormCollection(cursor);
    }

    private List<CollectionBean> getCollectionList(Cursor cursor) {
        if (!cursor.moveToFirst() && cursor.getCount() == 0) {
            return null;
        }

        List<CollectionBean> collectionBeen = new ArrayList<>();
        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
            collectionBeen.add(transFormCollection(cursor));
        }
        cursor.close();
        return collectionBeen;
    }

    private CollectionBean transFormCollection(Cursor cursor) {
        CollectionBean collectionBean = new CollectionBean();
        collectionBean.setId(cursor.getInt(
                cursor.getColumnIndexOrThrow(COLLECTION_ID)));
        collectionBean.setType(cursor.getString(
                cursor.getColumnIndexOrThrow(COLLECTION_TYPE)));
        String title = cursor.getString(
                cursor.getColumnIndexOrThrow(COLLECTION_TITLE));
        collectionBean.setTitle(title != null ? title : null);
        String url = cursor.getString(
                cursor.getColumnIndexOrThrow(COLLECTION_URL));
        collectionBean.setUrl(url != null ? url : null);
        String image1 = cursor.getString(
                cursor.getColumnIndexOrThrow(COLLECTION_IMAGE_1));
        collectionBean.setImage1(image1 != null ? image1 : null);
        String image2 = cursor.getString(
                cursor.getColumnIndexOrThrow(COLLECTION_IMAGE_2));
        collectionBean.setImage2(image2 != null ? image2 : null);
        String image3 = cursor.getString(
                cursor.getColumnIndexOrThrow(COLLECTION_IMAGE_3));
        collectionBean.setImage3(image3 != null ? image3 : null);
        String uniqueKey = cursor.getString(
                cursor.getColumnIndexOrThrow(COLLECTION_UNIQUE_KEY));
        collectionBean.setUniqueKey(uniqueKey != null ? uniqueKey : null);
        String featuredId = cursor.getString(
                cursor.getColumnIndexOrThrow(COLLECTION_FEATURED_ID));
        collectionBean.setFeaturedId(featuredId != null ? featuredId : null);
        String hashId = cursor.getString(
                cursor.getColumnIndexOrThrow(COLLECTION_HASH_ID));
        collectionBean.setHashId(hashId != null ? hashId : null);
        String content = cursor.getString(
                cursor.getColumnIndexOrThrow(COLLECTION_CONTENT));
        collectionBean.setContent(content != null ? content : null);
        return collectionBean;
    }
}
