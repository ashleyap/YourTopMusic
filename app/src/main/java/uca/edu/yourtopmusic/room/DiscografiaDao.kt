package uca.edu.yourtopmusic.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DiscografiaDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(discografiaEntity: DiscografiaCacheEntity): Long
    @Query("select * from artist")
    suspend fun get(): List<DiscografiaCacheEntity>
}