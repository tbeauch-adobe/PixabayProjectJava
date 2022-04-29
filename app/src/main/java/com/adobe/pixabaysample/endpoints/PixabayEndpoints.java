package com.adobe.pixabaysample.endpoints;

import com.adobe.pixabaysample.datamodels.Hits;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PixabayEndpoints {
    @GET("videos/")
    Call<Hits> loadVideos(@Query("key") String var1, @Query("q") String var2);
}

