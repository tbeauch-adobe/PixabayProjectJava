package com.adobe.pixabaysample.adapters;

import androidx.recyclerview.widget.DiffUtil.ItemCallback;
import com.adobe.pixabaysample.datamodels.VideoPreview;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class VideosDiffCallback extends ItemCallback<VideoPreview> {
    public boolean areItemsTheSame(@NotNull VideoPreview oldItem, @NotNull VideoPreview newItem) {
        return oldItem.equals(newItem);
    }

    public boolean areContentsTheSame(@NotNull VideoPreview oldItem, @NotNull VideoPreview newItem) {
        return oldItem.getVideoUrl().equals(newItem.getVideoUrl()) && oldItem.getThumbnailUrl().equals(newItem.getThumbnailUrl());
    }
}

