package com.adobe.pixabaysample.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import com.adobe.pixabaysample.R;
import com.adobe.pixabaysample.adapters.ListVideosAdapter;
import com.adobe.pixabaysample.databinding.FragmentPixabaySearchBinding;
import com.adobe.pixabaysample.viewmodels.BrowseVideosViewModel;
import com.adobe.pixabaysample.viewmodels.BrowseViewState;
import dagger.hilt.android.AndroidEntryPoint;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@AndroidEntryPoint
public final class PixabaySearchFragment extends Fragment {
    private FragmentPixabaySearchBinding viewBinding;
    private final ListVideosAdapter adapter = new ListVideosAdapter();
    private BrowseVideosViewModel browseVideosViewModel;

    public ListVideosAdapter getAdapter() {
        return adapter;
    }

    public BrowseVideosViewModel getBrowseVideosViewModel() {
        return browseVideosViewModel;
    }

    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        browseVideosViewModel = new ViewModelProvider(this).get(BrowseVideosViewModel.class);
        this.viewBinding = FragmentPixabaySearchBinding.inflate(inflater, container, false);
        viewBinding.imagesListRecyclerview.setLayoutManager(new GridLayoutManager(getContext(),
                getResources().getInteger(R.integer.browse_column_count)));
        viewBinding.imagesListRecyclerview.setAdapter(adapter);

        return viewBinding.getRoot();
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        browseVideosViewModel.getViewState().observe(this.getViewLifecycleOwner(), (new Observer<BrowseViewState>() {
            @Override
            public void onChanged(BrowseViewState browseViewState) {
                if (browseViewState != null) {
                    adapter.submitList(browseViewState.getVideoPreviews());
                    viewBinding.searchTermEdittext.setText(browseViewState.getSearchTerm());
                }
            }
        }));
    }

    public PixabaySearchFragment() { }
}