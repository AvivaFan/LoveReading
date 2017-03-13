package com.android.reading.presenter;

import android.content.Context;

import com.android.reading.R;
import com.android.reading.data.sqlite.CollectionDBHelper;
import com.android.reading.mapper.DataMapper;
import com.android.reading.model.CollectionModel;
import com.android.reading.utils.Constants;
import com.android.reading.utils.Utils;
import com.android.reading.view.BaseView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gu FanFan on 2017/3/10 3:28.
 * LoveReading.
 */

public class CollectionPresenterImpl implements BasePresenter {

    private Context mContext;
    private BaseView mCollectionView;
    private CollectionDBHelper mDBHelper;

    public CollectionPresenterImpl(Context context, BaseView collectionView) {
        mContext = context;
        mCollectionView = collectionView;
        mDBHelper = new CollectionDBHelper(mContext);
    }

    @Override
    public void getDataList(Object o) {
        List<CollectionModel> collectionModels = new ArrayList<>();

        // 加载新闻
        List<CollectionModel> newsModels = DataMapper
                .transFormCollection(mDBHelper.queryCollection(Constants.NAV_NEWS));
        if (!Utils.isEmpty(newsModels)) {
            collectionModels.add(new CollectionModel(mContext.getString(R.string.nav_news), true));
            collectionModels.addAll(newsModels);
        }
        // 加载微信精选
        List<CollectionModel> featuredModels = DataMapper
                .transFormCollection(mDBHelper.queryCollection(Constants.NAV_FEATURED));
        if (!Utils.isEmpty(featuredModels)) {
            collectionModels.add(new CollectionModel(mContext.getString(R.string.nav_featured), true));
            collectionModels.addAll(featuredModels);
        }
        // 加载段子
        List<CollectionModel> jokeModels = DataMapper
                .transFormCollection(mDBHelper.queryCollection(Constants.NAV_JOKE));
        if (!Utils.isEmpty(jokeModels)) {
            collectionModels.add(new CollectionModel(mContext.getString(R.string.nav_joke), true));
            collectionModels.addAll(jokeModels);
        }

        if (!Utils.isEmpty(collectionModels)) {
            mCollectionView.showData(collectionModels);
        } else {
            mCollectionView.showData(null);
        }
    }

    @Override
    public void onDestroy() {
        mDBHelper.close();
    }
}
