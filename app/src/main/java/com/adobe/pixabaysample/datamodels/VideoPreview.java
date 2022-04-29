package com.adobe.pixabaysample.datamodels;

import java.io.Serializable;

public final class VideoPreview implements Serializable {
    private final String thumbnailUrl;
    private final String videoUrl;

    public final String getThumbnailUrl() {
        return this.thumbnailUrl;
    }

    public final String getVideoUrl() {
        return this.videoUrl;
    }

    public VideoPreview(String thumbnailUrl, String videoUrl) {
        super();
        this.thumbnailUrl = thumbnailUrl;
        this.videoUrl = videoUrl;
    }

    public final VideoPreview copy(String thumbnailUrl, String videoUrl) {
        return new VideoPreview(thumbnailUrl, videoUrl);
    }

    public String toString() {
        return "VideoPreview(thumbnailUrl=" + this.thumbnailUrl + ", videoUrl=" + this.videoUrl + ")";
    }

    public int hashCode() {
        String var10000 = this.thumbnailUrl;
        int var1 = (var10000 != null ? var10000.hashCode() : 0) * 31;
        String var10001 = this.videoUrl;
        return var1 + (var10001 != null ? var10001.hashCode() : 0);
    }

    public boolean equals(Object var1) {
        if (this != var1) {
            if (var1 instanceof VideoPreview) {
                VideoPreview var2 = (VideoPreview)var1;
                if (this.thumbnailUrl.equals(var2.thumbnailUrl) && this.videoUrl.equals(var2.videoUrl)) {
                    return true;
                }
            }
            return false;
        } else {
            return true;
        }
    }
}
