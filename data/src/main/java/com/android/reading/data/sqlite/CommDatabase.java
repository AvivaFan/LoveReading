package com.android.reading.data.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by Gu FanFan on 2017/3/9 19:57.
 * LoveReading.
 */

class CommDatabase {

    /** 数据库名称. */
    private static final String DATABASE_NAME = "reading.db";
    /** 数据库版本号. */
    private static final int DATABASE_VERSION = 1;

    /**
     * 数据库操作辅助类
     */
    static class DatabaseHelper extends SQLiteOpenHelper {

        DatabaseHelper(Context context) {
            super(context, CommDatabase.DATABASE_NAME,
                    null, CommDatabase.DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(Collection.CREATE_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // 数据库更新
        }
    }

    /**
     * collection表
     */
    static class Collection implements BaseColumns {
        static final String TABLE_NAME = "collection";

        static final String COLLECTION_TYPE_NEWS = "news";
        static final String COLLECTION_TYPE_JOKE = "joke";
        static final String COLLECTION_TYPE_FEATURED = "featured";

        static final String COLLECTION_ID = "collection_id";
        static final String COLLECTION_TYPE = "collection_type";
        static final String COLLECTION_TITLE = "collection_title";
        static final String COLLECTION_URL = "collection_url";
        static final String COLLECTION_IMAGE_1 = "collection_image_1";
        static final String COLLECTION_IMAGE_2 = "collection_image_2";
        static final String COLLECTION_IMAGE_3 = "collection_image_3";
        static final String COLLECTION_UNIQUE_KEY = "collection_unique_key";
        static final String COLLECTION_FEATURED_ID = "collection_featured_id";
        static final String COLLECTION_HASH_ID = "collection_hashId";
        static final String COLLECTION_CONTENT = "collection_content";

        static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME
                + " (" + COLLECTION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLLECTION_TYPE + " TEXT, " + COLLECTION_TITLE
                + " TEXT, " + COLLECTION_URL + " TEXT, " + COLLECTION_IMAGE_1 + " TEXT, "
                + COLLECTION_IMAGE_2 + " TEXT, " + COLLECTION_IMAGE_3 + " TEXT, "
                + COLLECTION_FEATURED_ID + " TEXT, " + COLLECTION_UNIQUE_KEY + " TEXT, "
                + COLLECTION_HASH_ID + " TEXT, " + COLLECTION_CONTENT + " TEXT)";
    }
}
