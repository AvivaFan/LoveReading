package com.android.reading.view.ui.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.android.reading.R;
import com.android.reading.interactive.ClickHandler;
import com.android.reading.model.NewsModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gu FanFan on 2017/3/5 15:04.
 * LoveReading.
 */

public class NewsCategoryAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private List<NewsModel> mNewsModels = new ArrayList<>();
    private ClickHandler mClickHandler;

    public void setClickHandler(ClickHandler clickHandler) {
        mClickHandler = clickHandler;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new BaseViewHolder(DataBindingUtil.inflate(inflater, R.layout.item_news, parent, false));
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.bind(mNewsModels.get(position), mClickHandler);
    }

    @Override
    public int getItemCount() {
        return mNewsModels.size();
    }

    public void addAll(List<NewsModel> newsModels) {
        if (mNewsModels.size() > 0)
            mNewsModels.clear();

        mNewsModels.addAll(newsModels);
        notifyItemRangeInserted(0, mNewsModels.size() - 1);
    }
}
