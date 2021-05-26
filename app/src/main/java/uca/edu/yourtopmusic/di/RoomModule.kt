package uca.edu.yourtopmusic.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import uca.edu.yourtopmusic.room.DiscografiaDao
import uca.edu.yourtopmusic.room.DiscografiaDatabase
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object RoomModule {
    @Singleton
    @Provides
    fun provideDiscografiaDb(@ApplicationContext context: Context): DiscografiaDatabase {
        return Room
            .databaseBuilder(context, DiscografiaDatabase::class.java, DiscografiaDatabase.DATABASE_NAME).fallbackToDestructiveMigration().build()
    }

    @Singleton
    @Provides
    fun provideDiscografiaDao(discografiaDatabase: DiscografiaDatabase): DiscografiaDao {
        return discografiaDatabase.discografiaDao()
    }
}