package uca.edu.yourtopmusic.repository

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import uca.edu.yourtopmusic.retrofit.DiscografiaRetrofit
import uca.edu.yourtopmusic.retrofit.NetworkMapper
import uca.edu.yourtopmusic.room.CacheMapper
import uca.edu.yourtopmusic.room.DiscografiaDao
import uca.edu.yourtopmusic.utils.DataState

class DiscografiaRepository constructor(
    private val discografiaDao: DiscografiaDao,
    private val discografiaRetrofit: DiscografiaRetrofit,
    private val cacheMapper: CacheMapper,
    private val networkMapper: NetworkMapper
) {
    suspend fun getDiscografias(): Flow<DataState> = flow {
        emit(DataState.Loading)
        try {
            val discografiaData = discografiaRetrofit.get()
            val discografiaMap = networkMapper.mapFromEntityList(discografiaData)
            Log.d("AppDebug", "Tamaño de la lista: " + discografiaMap.size)

            for (tmpDiscografia in discografiaMap){
                discografiaDao.insert(cacheMapper.mapToEntity(tmpDiscografia))
                Log.d("AppDebug", "Probando cada item: " + discografiaMap.size)
            }

            val cacheDiscografia = discografiaDao.get()
            emit(DataState.Success(cacheMapper.mapFromEntityList(cacheDiscografia)))
        }catch (e: Exception){
            val cacheDiscografia = discografiaDao.get()

            emit(DataState.Success(cacheMapper.mapFromEntityList(cacheDiscografia)))
        }
    }
}