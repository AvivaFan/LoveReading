package com.android.reading.view.ui.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.android.reading.R;
import com.android.reading.interactive.ClickHandler;
import com.android.reading.model.ChannelListModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gu FanFan on 2017/3/20 13:36.
 * LoveReading.
 */

public class LabelAdapter extends RecyclerView.Adapter<BaseViewHolder>{

    private List<ChannelListModel> mListModels = new ArrayList<>();
    private ClickHandler mClickHandler;
    private String mLabel;

    public LabelAdapter(String label) {
        mLabel = label;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_label, parent, false);
        return new BaseViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.bind(mListModels.get(position), mClickHandler);
    }

    public void setClickHandler(ClickHandler clickHandler) {
        mClickHandler = clickHandler;
    }

    @Override
    public int getItemCount() {
        return mListModels.size();
    }

    public void addAll(List<ChannelListModel> channelListModels) {

        if (mListModels.size() > 0) {
            mListModels.addAll(0, channelListModels);
        } else {
            mListModels.addAll(channelListModels);
        }

        notifyItemRangeChanged(0, channelListModels.size() - 1);
    }
}
