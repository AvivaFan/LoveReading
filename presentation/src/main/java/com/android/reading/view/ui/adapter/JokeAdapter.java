package com.android.reading.view.ui.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.android.reading.R;
import com.android.reading.model.JokeModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gu FanFan on 2017/3/7 3:57.
 * LoveReading.
 */

public class JokeAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private List<JokeModel> mJokeModels = new ArrayList<>();

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new BaseViewHolder(DataBindingUtil.inflate(inflater, R.layout.item_joke, parent, false));
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.bind(mJokeModels.get(position));
    }

    @Override
    public int getItemCount() {
        return mJokeModels.size();
    }

    public void addAll(List<JokeModel> jokeModels) {

        if (mJokeModels.size() > 0) {
            mJokeModels.addAll(0, jokeModels);
        } else {
            mJokeModels.addAll(jokeModels);
        }

        notifyItemRangeChanged(0, jokeModels.size() - 1);
    }
}
