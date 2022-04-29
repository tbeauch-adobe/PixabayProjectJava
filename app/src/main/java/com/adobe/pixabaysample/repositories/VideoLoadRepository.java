package com.adobe.pixabaysample.repositories;

import android.util.Log;

import com.adobe.pixabaysample.BuildConfig;
import com.adobe.pixabaysample.datamodels.Hits;
import com.adobe.pixabaysample.endpoints.PixabayEndpoints;
import java.io.IOException;
import javax.inject.Inject;

public final class VideoLoadRepository {
    private final PixabayEndpoints endpoint;

    @Inject
    public VideoLoadRepository(PixabayEndpoints endpoint) {
        this.endpoint = endpoint;
    }

    public final Hits loadVideos(String term) throws IOException{
        return endpoint.loadVideos(BuildConfig.PIXABAY_API_KEY, term).execute().body();
    }
}
