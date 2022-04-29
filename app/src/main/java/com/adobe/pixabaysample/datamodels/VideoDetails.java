package com.adobe.pixabaysample.datamodels;

public final class VideoDetails {
    private final String picture_id;
    private final VideoSet videos;
    private final int views;

    public String getPicture_id() {
        return this.picture_id;
    }

    public VideoSet getVideos() {
        return this.videos;
    }

    public int getViews() {
        return this.views;
    }

    public VideoDetails(String picture_id, VideoSet videos, int views) {
        super();
        this.picture_id = picture_id;
        this.videos = videos;
        this.views = views;
    }

    public final VideoDetails copy(String picture_id, VideoSet videos, int views) {
        return new VideoDetails(picture_id, videos, views);
    }

    public String toString() {
        return "VideoDetails(picture_id=" + this.picture_id + ", videos=" + this.videos + ", views=" + this.views + ")";
    }

    public int hashCode() {
        String var10000 = this.picture_id;
        int var1 = (var10000 != null ? var10000.hashCode() : 0) * 31;
        VideoSet var10001 = this.videos;
        return (var1 + (var10001 != null ? var10001.hashCode() : 0)) * 31 + Integer.hashCode(this.views);
    }

    public boolean equals(Object var1) {
        if (this != var1) {
            if (var1 instanceof VideoDetails) {
                VideoDetails var2 = (VideoDetails)var1;
                return (this.picture_id.equals(var2.picture_id)) && (this.videos.equals(var2.videos)) && this.views == var2.views;
            }

            return false;
        } else {
            return true;
        }
    }
}