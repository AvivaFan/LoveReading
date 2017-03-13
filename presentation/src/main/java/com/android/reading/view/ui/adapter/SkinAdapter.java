package com.android.reading.view.ui.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.android.reading.R;
import com.android.reading.interactive.ClickHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gu FanFan on 2017/3/10 23:58.
 * LoveReading.
 */

public class SkinAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private List<Integer> mThemeColor = new ArrayList<>();
    private ClickHandler mClickHandler;

    public void setClickHandler(ClickHandler clickHandler) {
        mClickHandler = clickHandler;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new BaseViewHolder(DataBindingUtil.inflate(inflater, R.layout.item_skin, parent, false));
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.bind(mThemeColor.get(position), mClickHandler);
    }

    @Override
    public int getItemCount() {
        return mThemeColor.size();
    }

    public void addAll(List<Integer> themeColors) {
        int oldSize = mThemeColor.size();
        int newSize = themeColors.size();

        mThemeColor.addAll(themeColors);

        if (oldSize != newSize)
            notifyItemRangeChanged(0, mThemeColor.size() - 1);
    }
}
