package com.adobe.pixabaysample.datamodels;

public final class VideoProps {
    private final String url;

    public final String getUrl() {
        return this.url;
    }

    public VideoProps(String url) {
        super();
        this.url = url;
    }

    public final VideoProps copy(String url) {
        return new VideoProps(url);
    }

    public String toString() {
        return "VideoProps(url=" + this.url + ")";
    }

    public int hashCode() {
        String var10000 = this.url;
        return var10000 != null ? var10000.hashCode() : 0;
    }

    public boolean equals(Object var1) {
        if (this != var1) {
            if (var1 instanceof VideoProps) {
                VideoProps var2 = (VideoProps)var1;
                if (this.url.equals(var2.url)) {
                    return true;
                }
            }
            return false;
        } else {
            return true;
        }
    }
}