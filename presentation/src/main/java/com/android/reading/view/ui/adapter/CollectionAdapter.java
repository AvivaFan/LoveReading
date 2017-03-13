package com.android.reading.view.ui.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.android.reading.R;
import com.android.reading.interactive.ClickHandler;
import com.android.reading.model.CollectionModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gu FanFan on 2017/3/10 1:47.
 * LoveReading.
 */

public class CollectionAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private static final int SECTION_HEADER_VIEW = 1;

    private List<CollectionModel> mCollectionModels = new ArrayList<>();
    private ClickHandler mClickHandler;

    public void setClickHandler(ClickHandler clickHandler) {
        mClickHandler = clickHandler;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding;
        if (viewType == SECTION_HEADER_VIEW) {
            binding = DataBindingUtil.inflate(inflater, R.layout.item_collection_header, parent, false);
        } else {
            binding = DataBindingUtil.inflate(inflater, R.layout.item_collection, parent, false);
        }
        return new BaseViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.bind(mCollectionModels.get(position), mClickHandler);
    }

    @Override
    public int getItemCount() {
        return mCollectionModels.size();
    }

    @Override
    public int getItemViewType(int position) {
        CollectionModel collectionModel = mCollectionModels.get(position);

        if (collectionModel.getHeader())
            return SECTION_HEADER_VIEW;

        return super.getItemViewType(position);
    }

    public void addAll(List<CollectionModel> collectionModels) {
        int oldSize = mCollectionModels.size();
        int newSize = collectionModels.size();

        mCollectionModels.clear();
        mCollectionModels.addAll(collectionModels);

        if (oldSize > 0 && oldSize > newSize) {
            notifyItemRangeRemoved(oldSize, oldSize - newSize);
        }

        if (oldSize != newSize)
            notifyItemRangeChanged(0, mCollectionModels.size() - 1);
    }
}
