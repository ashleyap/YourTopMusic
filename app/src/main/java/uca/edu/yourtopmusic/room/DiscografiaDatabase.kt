package uca.edu.yourtopmusic.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [DiscografiaCacheEntity::class], version = 1)
abstract class DiscografiaDatabase: RoomDatabase() {
    companion object{
        val DATABASE_NAME = "DiscografiaDB"
    }

    abstract fun discografiaDao(): DiscografiaDao
}