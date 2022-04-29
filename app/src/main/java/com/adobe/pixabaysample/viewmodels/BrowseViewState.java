package com.adobe.pixabaysample.viewmodels;

import com.adobe.pixabaysample.datamodels.VideoPreview;

import java.util.List;

public final class BrowseViewState {
    private String searchTerm = "Dogs";
    private List<VideoPreview> videoPreviews;

    public String getSearchTerm() {
        return this.searchTerm;
    }

    public List<VideoPreview> getVideoPreviews() {
        return this.videoPreviews;
    }

    public BrowseViewState(String searchTerm, List<VideoPreview> videoPreviews) {
        super();
        this.searchTerm = searchTerm;
        this.videoPreviews = videoPreviews;
    }

    public BrowseViewState(List<VideoPreview> videoPreviews) {
        super();
        this.videoPreviews = videoPreviews;
    }

    public BrowseViewState copy(String searchTerm, List<VideoPreview> videoPreviews) {
        return new BrowseViewState(searchTerm, videoPreviews);
    }

    public BrowseViewState copy(List<VideoPreview> videoPreviews) {
        return new BrowseViewState(videoPreviews);
    }

    public String toString() {
        return "BrowseViewState(searchTerm=" + this.searchTerm + ", videoPreviews=" + this.videoPreviews + ")";
    }

    public int hashCode() {
        String var10000 = this.searchTerm;
        int var1 = (var10000 != null ? var10000.hashCode() : 0) * 31;
        List<VideoPreview> var10001 = this.videoPreviews;
        return var1 + (var10001 != null ? var10001.hashCode() : 0);
    }

    public boolean equals(Object var1) {
        if (this != var1) {
            if (var1 instanceof BrowseViewState) {
                BrowseViewState var2 = (BrowseViewState)var1;
                if (this.searchTerm.equals(var2.searchTerm) && this.videoPreviews.equals(var2.videoPreviews)) {
                    return true;
                }
            }
            return false;
        } else {
            return true;
        }
    }
}
