package com.android.reading.presenter;

import android.content.Context;

import com.android.reading.data.sqlite.CollectionDBHelper;
import com.android.reading.mapper.DataMapper;
import com.android.reading.model.CollectionModel;
import com.android.reading.model.FeaturedModel;
import com.android.reading.model.JokeModel;
import com.android.reading.model.NewsModel;
import com.android.reading.model.StatusModel;
import com.android.reading.view.BaseView;

/**
 * Created by Gu FanFan on 2017/3/9 7:05.
 * LoveReading.
 */

public class DetailsPresenterImpl implements DetailsPresenter {

    private Context mContext;
    private BaseView mDetailsView;
    private CollectionDBHelper mDBHelper;

    public DetailsPresenterImpl(Context context, BaseView detailsView) {
        this.mContext = context;
        this.mDetailsView = detailsView;
        mDBHelper = new CollectionDBHelper(mContext);
    }

    @Override
    public void onInsert(Object o) {
        boolean isInsert = false;
        if (o instanceof NewsModel) {
            NewsModel newsModel =  (NewsModel) o;
            // isInsert = mDBHelper.insertCollection(DataMapper.transFormNews(newsModel));
        } else if (o instanceof FeaturedModel) {
            FeaturedModel featuredModel = (FeaturedModel) o;
            isInsert = mDBHelper.insertCollection(DataMapper.transFormFeatured(featuredModel));
        } else if (o instanceof JokeModel) {
            JokeModel jokeModel = (JokeModel) o;
            isInsert = mDBHelper.insertCollection(DataMapper.transFormJoke(jokeModel));
        } else if (o instanceof CollectionModel) {
            CollectionModel collectionModel = (CollectionModel) o;
            isInsert = mDBHelper.insertCollection(DataMapper.transFormCollection(collectionModel));
        }

        StatusModel statusModel = new StatusModel();
        statusModel.setStatus(isInsert);
        /*if (isInsert) {
            statusModel.setMsg(mContext.getString(R.string.insert_success_message));
        } else {
            statusModel.setMsg(mContext.getString(R.string.insert_error_message));
        }*/
        mDetailsView.showMsg(statusModel);
    }

    @Override
    public void onDelete(Object o) {
        boolean isDelete = false;
        if (o instanceof NewsModel) {
            NewsModel newsModel =  (NewsModel) o;
            // isDelete = mDBHelper.deleteCollection(DataMapper.transFormNews(newsModel));
        } else if (o instanceof FeaturedModel) {
            FeaturedModel featuredModel = (FeaturedModel) o;
            isDelete = mDBHelper.deleteCollection(DataMapper.transFormFeatured(featuredModel));
        } else if (o instanceof JokeModel) {
            JokeModel jokeModel = (JokeModel) o;
            isDelete = mDBHelper.deleteCollection(DataMapper.transFormJoke(jokeModel));
        } else if (o instanceof CollectionModel) {
            CollectionModel collectionModel = (CollectionModel) o;
            isDelete = mDBHelper.deleteCollection(DataMapper.transFormCollection(collectionModel));
        }

        StatusModel statusModel = new StatusModel();
        statusModel.setStatus(isDelete);
        /*if (isDelete) {
            statusModel.setMsg(mContext.getString(R.string.delete_success_message));
        } else {
            statusModel.setMsg(mContext.getString(R.string.delete_error_message));
        }*/
        mDetailsView.showMsg(statusModel);
    }

    @Override
    public void onQuery(Object o) {
        boolean isHas = false;
        if (o instanceof NewsModel) {
            NewsModel newsModel =  (NewsModel) o;
            // isHas = mDBHelper.queryCollection(DataMapper.transFormNews(newsModel));
        } else if (o instanceof FeaturedModel) {
            FeaturedModel featuredModel = (FeaturedModel) o;
            isHas = mDBHelper.queryCollection(DataMapper.transFormFeatured(featuredModel));
        } else if (o instanceof JokeModel) {
            JokeModel jokeModel = (JokeModel) o;
            isHas = mDBHelper.queryCollection(DataMapper.transFormJoke(jokeModel));
        } else if (o instanceof CollectionModel) {
            CollectionModel collectionModel = (CollectionModel) o;
            isHas = mDBHelper.queryCollection(DataMapper.transFormCollection(collectionModel));
        }

        StatusModel statusModel = new StatusModel();
        statusModel.setStatus(isHas);
        mDetailsView.showMsg(statusModel);
    }

    @Override
    public void getDataList(Object o) {
    }

    @Override
    public void onDestroy() {
        mDBHelper.close();
        mDBHelper = null;
    }
}
