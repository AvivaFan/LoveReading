package com.android.reading.mapper;

import com.android.reading.data.bean.CollectionBean;
import com.android.reading.data.bean.FeaturedBean;
import com.android.reading.data.bean.JokeBean;
import com.android.reading.data.bean.NewsBean;
import com.android.reading.model.CollectionModel;
import com.android.reading.model.FeaturedModel;
import com.android.reading.model.JokeModel;
import com.android.reading.model.NewsModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gu FanFan on 2017/3/5 15:46.
 * LoveReading.
 */

public class DataMapper {

    /** 新闻数据转换. */
    public static NewsModel transFormNews(NewsBean.ResultBean.DataBean dataBean) {
        NewsModel newsModel = new NewsModel();
        newsModel.setUniquekey(dataBean.getUniquekey());
        newsModel.setTitle(dataBean.getTitle());
        newsModel.setDate(dataBean.getDate());
        newsModel.setCategory(dataBean.getCategory());
        newsModel.setAuthor_name(dataBean.getAuthor_name());
        newsModel.setUrl(dataBean.getUrl());
        newsModel.setThumbnail_pic_s(dataBean.getThumbnail_pic_s());
        newsModel.setThumbnail_pic_s02(dataBean.getThumbnail_pic_s02());
        newsModel.setThumbnail_pic_s03(dataBean.getThumbnail_pic_s03());
        return newsModel;
    }

    public static NewsBean.ResultBean.DataBean transFormNews(NewsModel newsModel) {
        NewsBean.ResultBean.DataBean dataBean = new NewsBean.ResultBean.DataBean();
        dataBean.setUniquekey(newsModel.getUniquekey());
        dataBean.setTitle(newsModel.getTitle());
        dataBean.setDate(newsModel.getDate());
        dataBean.setCategory(newsModel.getCategory());
        dataBean.setAuthor_name(newsModel.getAuthor_name());
        dataBean.setUrl(newsModel.getUrl());
        dataBean.setThumbnail_pic_s(newsModel.getThumbnail_pic_s());
        dataBean.setThumbnail_pic_s02(newsModel.getThumbnail_pic_s02());
        dataBean.setThumbnail_pic_s03(newsModel.getThumbnail_pic_s03());
        return dataBean;
    }

    public static List<NewsModel> transFormNews(List<NewsBean.ResultBean.DataBean> dataBeanList) {
        List<NewsModel> newsModels = null;
        if (dataBeanList != null && dataBeanList.size() > 0) {
            newsModels = new ArrayList<>();

            for (NewsBean.ResultBean.DataBean dataBean : dataBeanList) {
                newsModels.add(transFormNews(dataBean));
            }
        }

        return newsModels;
    }

    /** 笑话数据转换. */
    public static JokeModel transFormJoke(JokeBean.ResultBean resultBean) {
        JokeModel jokeModel = new JokeModel();
        jokeModel.setContent(resultBean.getContent());
        jokeModel.setHashId(resultBean.getHashId());
        jokeModel.setUnixtime(resultBean.getUnixtime());
        return jokeModel;
    }

    public static JokeBean.ResultBean transFormJoke(JokeModel jokeModel) {
        JokeBean.ResultBean resultBean = new JokeBean.ResultBean();
        resultBean.setContent(jokeModel.getContent());
        resultBean.setHashId(jokeModel.getHashId());
        resultBean.setUnixtime(jokeModel.getUnixtime());
        return resultBean;
    }

    public static List<JokeModel> transFormJoke(List<JokeBean.ResultBean> resultBeans) {
        List<JokeModel> jokeModels = null;
        if (resultBeans != null && resultBeans.size() > 0) {
            jokeModels = new ArrayList<>();

            for (JokeBean.ResultBean resultBean : resultBeans) {
                jokeModels.add(transFormJoke(resultBean));
            }
        }

        return jokeModels;
    }

    /** 微信精选数据转换. */
    public static FeaturedModel transFormFeatured(FeaturedBean.ResultBean.ListBean listBean) {
        FeaturedModel featuredModel = new FeaturedModel();
        featuredModel.setId(listBean.getId());
        featuredModel.setTitle(listBean.getTitle());
        featuredModel.setSource(listBean.getSource());
        featuredModel.setFirstImg(listBean.getFirstImg());
        featuredModel.setMark(listBean.getMark());
        featuredModel.setUrl(listBean.getUrl());
        return featuredModel;
    }

    public static FeaturedBean.ResultBean.ListBean transFormFeatured(FeaturedModel featuredModel) {
        FeaturedBean.ResultBean.ListBean listBean = new FeaturedBean.ResultBean.ListBean();
        listBean.setId(featuredModel.getId());
        listBean.setTitle(featuredModel.getTitle());
        listBean.setSource(featuredModel.getSource());
        listBean.setFirstImg(featuredModel.getFirstImg());
        listBean.setMark(featuredModel.getMark());
        listBean.setUrl(featuredModel.getUrl());
        return listBean;
    }

    public static List<FeaturedModel> transFormFeatured(List<FeaturedBean.ResultBean.ListBean> listBeans) {
        List<FeaturedModel> featuredModels = null;

        if (listBeans != null && listBeans.size() > 0) {
            featuredModels = new ArrayList<>();

            for (FeaturedBean.ResultBean.ListBean listBean : listBeans) {
                featuredModels.add(transFormFeatured(listBean));
            }
        }

        return featuredModels;
    }

    /** 收藏数据转换. */
    public static CollectionModel transFormCollection(CollectionBean collectionBean) {
        CollectionModel collectionModel = new CollectionModel();
        collectionModel.setId(collectionBean.getId());
        collectionModel.setType(collectionBean.getType());
        collectionModel.setTitle(collectionBean.getTitle());
        collectionModel.setUrl(collectionBean.getUrl());
        collectionModel.setImage1(collectionBean.getImage1());
        collectionModel.setImage2(collectionBean.getImage2());
        collectionModel.setImage3(collectionBean.getImage3());
        collectionModel.setUniqueKey(collectionBean.getUniqueKey());
        collectionModel.setHashId(collectionBean.getHashId());
        collectionModel.setFeaturedId(collectionBean.getFeaturedId());
        collectionModel.setContent(collectionBean.getContent());
        return collectionModel;
    }

    public static CollectionBean transFormCollection(CollectionModel collectionModel) {
        CollectionBean collectionBean = new CollectionBean();
        collectionBean.setId(collectionModel.getId());
        collectionBean.setType(collectionModel.getType());
        collectionBean.setTitle(collectionModel.getTitle());
        collectionBean.setUrl(collectionModel.getUrl());
        collectionBean.setImage1(collectionModel.getImage1());
        collectionBean.setImage2(collectionModel.getImage2());
        collectionBean.setImage3(collectionModel.getImage3());
        collectionBean.setUniqueKey(collectionModel.getUniqueKey());
        collectionBean.setHashId(collectionModel.getHashId());
        collectionBean.setFeaturedId(collectionModel.getFeaturedId());
        collectionBean.setContent(collectionModel.getContent());
        return collectionBean;
    }

    public static List<CollectionModel> transFormCollection(List<CollectionBean> beanList) {
        List<CollectionModel> collectionModels = null;

        if (beanList != null && beanList.size() > 0) {
            collectionModels = new ArrayList<>();
            for (CollectionBean collectionBean : beanList) {
                collectionModels.add(transFormCollection(collectionBean));
            }
            return collectionModels;
        }

        return collectionModels;
    }
}
