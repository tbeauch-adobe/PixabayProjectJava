package com.adobe.pixabaysample.injection;

import android.content.Context;
import android.content.SharedPreferences;
import com.adobe.pixabaysample.endpoints.PixabayEndpoints;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.android.components.ViewModelComponent;
import dagger.hilt.android.qualifiers.ApplicationContext;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;
import retrofit2.Converter.Factory;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn({ActivityComponent.class, ViewModelComponent.class})
public final class PixabayModule {
    @Singleton
    @Provides
    public final SharedPreferences provideSharedPreferences(@ApplicationContext @NotNull Context context) {
        return context.getSharedPreferences("MainPrefs", 0);
    }

    @Provides
    public final Retrofit provideRetrofitPixabay() {
        return (new Builder()).baseUrl("https://pixabay.com/api/").addConverterFactory((Factory)GsonConverterFactory.create()).build();
    }

    @Provides
    public final PixabayEndpoints providePixabayEndpoints(@NotNull Retrofit retrofit) {
        return retrofit.create(PixabayEndpoints.class);
    }
}
