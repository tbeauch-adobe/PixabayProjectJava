package com.adobe.pixabaysample.datamodels;

public final class VideoSet {
    private final VideoProps medium;

    public final VideoProps getMedium() {
        return this.medium;
    }

    public VideoSet(VideoProps medium) {
        super();
        this.medium = medium;
    }

    public final VideoSet copy(VideoProps medium) {
        return new VideoSet(medium);
    }

    public String toString() {
        return "VideoSet(medium=" + this.medium + ")";
    }

    public int hashCode() {
        VideoProps var10000 = this.medium;
        return var10000 != null ? var10000.hashCode() : 0;
    }

    public boolean equals(Object var1) {
        if (this != var1) {
            if (var1 instanceof VideoSet) {
                VideoSet var2 = (VideoSet)var1;
                if (this.medium.equals(var2.medium)) {
                    return true;
                }
            }
            return false;
        } else {
            return true;
        }
    }
}