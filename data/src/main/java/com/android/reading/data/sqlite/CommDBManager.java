package com.android.reading.data.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Gu FanFan on 2017/3/9 20:33.
 * LoveReading.
 */

public abstract class CommDBManager {

    private Context mContext;
    private CommDatabase.DatabaseHelper mDatabaseHelper;
    private SQLiteDatabase mSQLiteDatabase;

    CommDBManager(Context context) {
        mContext = context;
        mDatabaseHelper = new CommDatabase.DatabaseHelper(mContext);
    }

    private void open() {
        if (mDatabaseHelper == null)
            mDatabaseHelper = new CommDatabase.DatabaseHelper(mContext);

        mSQLiteDatabase = mDatabaseHelper.getWritableDatabase();
    }

    public void close() {
        if (mDatabaseHelper != null) {
            mSQLiteDatabase.close();
            mDatabaseHelper.close();
            mDatabaseHelper = null;
            mSQLiteDatabase = null;
        }
    }

    SQLiteDatabase getSQLiteDatabase() {
        if (mSQLiteDatabase == null)
            open();

        return mSQLiteDatabase;
    }
}
