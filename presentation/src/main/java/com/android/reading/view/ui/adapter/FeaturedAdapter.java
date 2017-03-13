package com.android.reading.view.ui.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.android.reading.R;
import com.android.reading.interactive.ClickHandler;
import com.android.reading.model.FeaturedModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gu FanFan on 2017/3/8 8:49.
 * LoveReading.
 */

public class FeaturedAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private List<FeaturedModel> mFeaturedModels = new ArrayList<>();
    private ClickHandler mHandler;

    public void setHandler(ClickHandler handler) {
        mHandler = handler;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new BaseViewHolder(DataBindingUtil.inflate(inflater, R.layout.item_featured, parent, false));
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.bind(mFeaturedModels.get(position), mHandler);
    }

    @Override
    public int getItemCount() {
        return mFeaturedModels.size();
    }

    public void addAll(List<FeaturedModel> featuredModels) {
        if (mFeaturedModels.size() > 0) {
            mFeaturedModels.addAll(featuredModels);
        } else {
            mFeaturedModels.addAll(featuredModels);
        }

        notifyItemRangeInserted(0, featuredModels.size() - 1);
    }
}
