package com.adobe.pixabaysample.viewholders;

import android.view.View;
import android.widget.ImageView;

import com.adobe.pixabaysample.databinding.ItemVideoPreviewBinding;
import com.adobe.pixabaysample.datamodels.VideoPreview;
import com.bumptech.glide.Glide;

public class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
    private final ItemVideoPreviewBinding binding;

    public final void bind(VideoPreview video, int position) {
        ImageView imageView;
        if (position % 5 == 0) {
            imageView = this.binding.starredImageview;
            imageView.setVisibility(View.VISIBLE);
        } else {
            imageView = this.binding.starredImageview;
            imageView.setVisibility(View.INVISIBLE);
            Glide.with(binding.getRoot())
                    .load("https://i.vimeocdn.com/video/" + video.getThumbnailUrl() +"_960x540.jpg")
                    .into(binding.videoPreviewImageview);

        }
    }

    public ViewHolder(ItemVideoPreviewBinding binding) {
        super((View)binding.getRoot());
        this.binding = binding;
    }
}

