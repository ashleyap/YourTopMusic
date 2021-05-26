package uca.edu.yourtopmusic.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import uca.edu.yourtopmusic.repository.DiscografiaRepository
import uca.edu.yourtopmusic.retrofit.DiscografiaRetrofit
import uca.edu.yourtopmusic.retrofit.NetworkMapper
import uca.edu.yourtopmusic.room.CacheMapper
import uca.edu.yourtopmusic.room.DiscografiaDao
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object RepositoryModule {
    @Singleton
    @Provides
    fun provideDiscografiaRepository(
        discografiaDao: DiscografiaDao,
        discografiaRetrofit: DiscografiaRetrofit,
        cacheMapper: CacheMapper,
        networkMapper: NetworkMapper
    ): DiscografiaRepository{
        return DiscografiaRepository(discografiaDao, discografiaRetrofit,
            cacheMapper, networkMapper)
    }
}