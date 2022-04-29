package com.adobe.pixabaysample.usecase;

import com.adobe.pixabaysample.datamodels.VideoDetails;
import com.adobe.pixabaysample.datamodels.VideoPreview;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public final class LoadedVideoMapUseCase {
    /**
     * Filter the given list of VideoDetails objects that have a view count greater than the viewCount
     * value passed in to this function. Map the resulting filtered results to the VideoPreview
     * view state object.
     */
    public final List<VideoPreview> filterAndMapLoadedVideos(List<VideoDetails> videoDetails, int viewCount) {
        ArrayList<VideoPreview> result = new ArrayList<>();
        for (int i = 0; i < videoDetails.size(); i++)
        {
            VideoDetails currentVideoDetail = videoDetails.get(i);
            if (currentVideoDetail.getViews() > viewCount) {
                result.add(new VideoPreview(currentVideoDetail.getPicture_id(),
                        currentVideoDetail.getVideos().getMedium().getUrl()));
            }
        }
        return result;
    }

    @Inject
    public LoadedVideoMapUseCase() {}
}
