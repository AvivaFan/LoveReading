package com.android.reading.view.ui.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.android.reading.R;

/**
 * Created by Gu FanFan on 2017/3/20 21:41.
 * LoveReading.
 */

public class MineAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new BaseViewHolder(DataBindingUtil.inflate(inflater, R.layout.item_empty, parent, false));
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 1;
    }
}
