package com.adobe.pixabaysample.viewmodels;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.adobe.pixabaysample.datamodels.Hits;
import com.adobe.pixabaysample.datamodels.VideoPreview;
import com.adobe.pixabaysample.repositories.VideoLoadRepository;
import com.adobe.pixabaysample.usecase.LoadedVideoMapUseCase;
import dagger.hilt.android.lifecycle.HiltViewModel;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@HiltViewModel
public final class BrowseVideosViewModel extends ViewModel {
    private final MutableLiveData<BrowseViewState> viewState;
    private final VideoLoadRepository repository;
    private final LoadedVideoMapUseCase loadedVideoMapUseCase;

    public final MutableLiveData<BrowseViewState> getViewState() {
        return this.viewState;
    }

    @Inject
    public BrowseVideosViewModel(VideoLoadRepository repository, LoadedVideoMapUseCase loadedVideoMapUseCase) {
        super();
        this.repository = repository;
        this.loadedVideoMapUseCase = loadedVideoMapUseCase;
        this.viewState = new MutableLiveData<>(new BrowseViewState("Dogs", new ArrayList<VideoPreview>()));
    }

    public final void loadVideoPreviews(final String searchTerm) {
        final Hits[] loadedVideos = new Hits[1];
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        loadedVideos[0] = BrowseVideosViewModel.this.repository.loadVideos(searchTerm);
                    } catch (Exception e) {
                        Log.e("BrowseVideosViewModel", "Error loading videos: " + e.toString());
                    }
                    if (loadedVideos[0] != null && loadedVideos[0].getHits() != null) {
                        List<VideoPreview> result = loadedVideoMapUseCase.filterAndMapLoadedVideos(loadedVideos[0].getHits(), 50);
                        viewState.postValue(viewState.getValue().copy(result));
                    }
                }
            }).start();
    }
}

