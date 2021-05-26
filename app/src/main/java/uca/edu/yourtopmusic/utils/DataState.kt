package uca.edu.yourtopmusic.utils

import uca.edu.yourtopmusic.model.Discografia

sealed class DataState {
    object Idle: DataState()
    data class Success(val discografia: List<Discografia>) : DataState()
    data class Error(val exception: Exception) : DataState()
    object Loading: DataState()
}