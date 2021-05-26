package uca.edu.yourtopmusic.di

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import uca.edu.yourtopmusic.utils.AdapterDiscografia
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object AdapterModule {
    @Singleton
    @Provides
    fun provideAdapterDiscografia(application: Application): AdapterDiscografia {
        return AdapterDiscografia()
    }
}