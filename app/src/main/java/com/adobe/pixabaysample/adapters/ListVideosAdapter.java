package com.adobe.pixabaysample.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.DiffUtil.ItemCallback;
import com.adobe.pixabaysample.databinding.ItemVideoPreviewBinding;
import com.adobe.pixabaysample.datamodels.VideoPreview;
import com.adobe.pixabaysample.viewholders.ViewHolder;

public final class ListVideosAdapter extends ListAdapter<VideoPreview, ViewHolder> {
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemVideoPreviewBinding itemVideoPreviewBinding = ItemVideoPreviewBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(itemVideoPreviewBinding);
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        VideoPreview videoPreview = (VideoPreview) this.getItem(position);
        holder.bind(videoPreview, position);
    }

    public ListVideosAdapter() {
        super((ItemCallback)(new VideosDiffCallback()));
    }
}

