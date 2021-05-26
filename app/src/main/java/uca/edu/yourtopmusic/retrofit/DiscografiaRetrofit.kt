package uca.edu.yourtopmusic.retrofit

import retrofit2.http.GET

interface DiscografiaRetrofit {
    @GET("artist")
    suspend fun get(): List<DiscografiaNetworkEntity>
}