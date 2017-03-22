package com.android.reading.view.ui.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.android.reading.R;
import com.android.reading.model.NewsModel;
import com.android.reading.utils.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gu FanFan on 2017/3/21 0:18.
 * LoveReading.
 */

public class NewsAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private List<NewsModel.ContentListBean> mNewsList = new ArrayList<>();

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        ViewDataBinding binding;
        if (viewType == Constants.ITEM_VIEW_EMPTY) {
            binding = DataBindingUtil.inflate(inflater, R.layout.item_empty, parent, false);
        } else if (viewType == Constants.ITEM_VIEW_NO_PIC) {
            binding = DataBindingUtil.inflate(inflater, R.layout.item_news_no_pic, parent, false);
        } else if (viewType == Constants.ITEM_VIEW_ONE_PIC) {
            binding = DataBindingUtil.inflate(inflater, R.layout.item_news_one_pic, parent, false);
        } else {
            binding = DataBindingUtil.inflate(inflater, R.layout.item_news_more_pic, parent, false);
        }

        return new BaseViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        if (mNewsList.size() > 0) {
            NewsModel.ContentListBean bean = mNewsList.get(position);
            if (bean.isHavePic()) {
                if (bean.getImageurls().size() < 3) {
                    holder.bind(bean, bean.getImageurls().get(0).getUrl(), null);
                } else {
                    holder.bind(bean, bean.getImageurls().get(0).getUrl(),
                            bean.getImageurls().get(1).getUrl(),
                            bean.getImageurls().get(2).getUrl(), null);
                }
            } else {
                holder.bind(bean);
            }

        }
    }

    @Override
    public int getItemCount() {
        return mNewsList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (mNewsList.size() > 0) {
            NewsModel.ContentListBean news = mNewsList.get(position);
            if (news.isHavePic()) {
                int picSize = news.getImageurls().size();
                if (picSize > 3) {
                    return Constants.ITEM_VIEW_MORE_PIC;
                } else {
                    return Constants.ITEM_VIEW_ONE_PIC;
                }
            } else {
                return Constants.ITEM_VIEW_NO_PIC;
            }
        }

        return -1;
    }

    public void addAll(List<NewsModel.ContentListBean> listBeen) {

        if (mNewsList.size() > 0) {
            mNewsList.addAll(0, listBeen);
        } else {
            mNewsList.addAll(listBeen);
        }

        notifyItemRangeChanged(0, listBeen.size() - 1);
    }
}
