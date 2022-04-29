package com.adobe.pixabaysample.datamodels;

import java.util.List;

public final class Hits {

    private final List<VideoDetails> hits;

    public final List<VideoDetails> getHits() {
        return this.hits;
    }

    public Hits(List<VideoDetails> hits) {
        super();
        this.hits = hits;
    }

    public final Hits copy(List<VideoDetails> hits) {
        return new Hits(hits);
    }

    public String toString() {
        return "Hits(hits=" + this.hits + ")";
    }

    public int hashCode() {
        List<VideoDetails> videoDetails = this.hits;
        return videoDetails != null ? videoDetails.hashCode() : 0;
    }

    public boolean equals(Object var1) {
        if (this != var1) {
            if (var1 instanceof Hits) {
                Hits var2 = (Hits)var1;
                return this.hits.equals(var2.hits);
            }
            return false;
        } else {
            return true;
        }
    }
}
