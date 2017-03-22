package com.android.reading.mapper;

import com.android.reading.data.bean.ChannelListBean;
import com.android.reading.data.bean.CollectionBean;
import com.android.reading.data.bean.FeaturedBean;
import com.android.reading.data.bean.JokeBean;
import com.android.reading.data.bean.NewsBean;
import com.android.reading.data.bean.UserBean;
import com.android.reading.data.bean.UserChannelListBean;
import com.android.reading.model.ChannelListModel;
import com.android.reading.model.CollectionModel;
import com.android.reading.model.FeaturedModel;
import com.android.reading.model.JokeModel;
import com.android.reading.model.NewsModel;
import com.android.reading.model.UserModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gu FanFan on 2017/3/5 15:46.
 * LoveReading.
 */

public class DataMapper {

    /**
     * 新闻数据转换.
     */
    public static NewsModel transFormNews(NewsBean.ShowapiResBodyBean.PagebeanBean pageBean) {
        NewsModel newsModel = new NewsModel();
        newsModel.setAllNum(pageBean.getAllNum());
        newsModel.setAllPages(pageBean.getAllPages());
        newsModel.setContentlist(transFormContentListBeans(pageBean.getContentlist()));
        newsModel.setCurrentPage(pageBean.getCurrentPage());
        newsModel.setMaxResult(pageBean.getMaxResult());
        return newsModel;
    }

    private static List<NewsModel.ContentListBean> transFormContentListBeans
            (List<NewsBean.ShowapiResBodyBean.PagebeanBean.ContentlistBean> beanList) {
        List<NewsModel.ContentListBean> contentListBeen = null;
        if (beanList != null && beanList.size() > 0) {
            contentListBeen = new ArrayList<>();
            for (NewsBean.ShowapiResBodyBean.PagebeanBean.ContentlistBean bean : beanList) {
                contentListBeen.add(transFormContentListBean(bean));
            }
        }
        return contentListBeen;
    }

    private static NewsModel.ContentListBean transFormContentListBean(
            NewsBean.ShowapiResBodyBean.PagebeanBean.ContentlistBean contentlistBean) {
        NewsModel.ContentListBean bean = new NewsModel.ContentListBean();
        bean.setChannelId(contentlistBean.getChannelId());
        bean.setChannelName(contentlistBean.getChannelName());
        bean.setDesc(contentlistBean.getDesc());
        bean.setHavePic(contentlistBean.isHavePic());
        bean.setLink(contentlistBean.getLink());
        bean.setPubDate(contentlistBean.getPubDate());
        bean.setSource(contentlistBean.getSource());
        bean.setTitle(contentlistBean.getTitle());
        bean.setAllList(contentlistBean.getAllList());
        bean.setImageurls(transFormImageurlsBean(contentlistBean.getImageurls()));
        return bean;
    }

    private static List<NewsModel.ContentListBean.ImageUrlsBean> transFormImageurlsBean(
            List<NewsBean.ShowapiResBodyBean.PagebeanBean.ContentlistBean.ImageurlsBean> imageurlsBeen) {
        List<NewsModel.ContentListBean.ImageUrlsBean> imageUrlsBeen = null;
        if (imageurlsBeen != null && imageurlsBeen.size() > 0) {
            imageUrlsBeen = new ArrayList<>();
            for (NewsBean.ShowapiResBodyBean.PagebeanBean.ContentlistBean.ImageurlsBean bean : imageurlsBeen) {
                imageUrlsBeen.add(transFormImageUrlsBean(bean));
            }
        }
        return imageUrlsBeen;
    }

    private static NewsModel.ContentListBean.ImageUrlsBean transFormImageUrlsBean(
            NewsBean.ShowapiResBodyBean.PagebeanBean.ContentlistBean.ImageurlsBean imageurlsBean) {
        NewsModel.ContentListBean.ImageUrlsBean imageUrlsBean =
                new NewsModel.ContentListBean.ImageUrlsBean();
        imageUrlsBean.setHeight(imageurlsBean.getHeight());
        imageUrlsBean.setWidth(imageurlsBean.getWidth());
        imageUrlsBean.setUrl(imageurlsBean.getUrl());
        return imageUrlsBean;
    }

    /**
     * 笑话数据转换.
     */
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

    /**
     * 微信精选数据转换.
     */
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

    /**
     * 收藏数据转换.
     */
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
        }

        return collectionModels;
    }

    /**
     * 频道列表数据转换
     */
    public static ChannelListModel transFormChannel(ChannelListBean.ShowapiResBodyBean.ChannelList channelList) {
        ChannelListModel channelListModel = new ChannelListModel();
        channelListModel.setChannelId(channelList.getChannelId());
        channelListModel.setName(channelList.getName());
        return channelListModel;
    }

    public static List<ChannelListModel> transFormChannelList(List<ChannelListBean.ShowapiResBodyBean.ChannelList> channelLists) {
        List<ChannelListModel> channelListModels = null;
        if (channelLists != null && channelLists.size() > 0) {
            channelListModels = new ArrayList<>();

            for (ChannelListBean.ShowapiResBodyBean.ChannelList channelList : channelLists) {
                channelListModels.add(transFormChannel(channelList));
            }
        }

        return channelListModels;
    }

    public static ChannelListModel transFormUserChannel(UserChannelListBean.ChannelBean channelBean) {
        ChannelListModel channelListModel = new ChannelListModel();
        channelListModel.setChannelId(channelBean.getChannelId());
        channelListModel.setName(channelBean.getChannelName());
        return channelListModel;
    }

    public static List<ChannelListModel> transFormUserChannelList(List<UserChannelListBean.ChannelBean> channelBeen) {
        List<ChannelListModel> channelListModels = null;
        if (channelBeen != null && channelBeen.size() > 0) {
            channelListModels = new ArrayList<>();

            for (UserChannelListBean.ChannelBean channelBean : channelBeen) {
                channelListModels.add(transFormUserChannel(channelBean));
            }
        }

        return channelListModels;
    }

    /** User data mapper. */
    public static UserModel transFormUser(UserBean.User userBean) {
        UserModel userModel = new UserModel();
        userModel.setId(userBean.getId());
        userModel.setName(userBean.getName());
        userModel.setEmail(userBean.getEmail());
        userModel.setPhone(userBean.getPhone());
        userModel.setPassword(userBean.getPassword());
        userModel.setReal_name(userBean.getReal_name());
        userModel.setDevice(userBean.getDevice());
        return userModel;
    }

    public static UserBean.User transFormUser(UserModel model) {
        UserBean.User user = new UserBean.User();
        user.setId(model.getId());
        user.setName(model.getName());
        user.setEmail(model.getEmail());
        user.setPhone(model.getPhone());
        user.setPassword(model.getPassword());
        user.setReal_name(model.getReal_name());
        user.setDevice(model.getDevice());
        return user;
    }
}
