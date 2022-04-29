package com.adobe.pixabaysample.activities;

import android.os.Bundle;
import android.view.View;

import com.adobe.pixabaysample.R;
import com.adobe.pixabaysample.viewmodels.BrowseViewState;

import androidx.appcompat.app.AppCompatActivity;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public final class MainActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.main_activity);
    }
}

