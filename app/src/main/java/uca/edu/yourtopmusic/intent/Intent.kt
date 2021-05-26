package uca.edu.yourtopmusic.intent

sealed class Intent {
    object GetDiscografiaEvent: Intent()
    object None: Intent()
}