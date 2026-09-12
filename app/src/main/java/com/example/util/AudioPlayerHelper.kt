package com.example.util

import android.content.Context
import android.media.MediaPlayer
import android.net.Uri
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import java.io.File

data class PlaybackState(
    val isPlaying: Boolean = false,
    val currentFilePath: String? = null,
    val currentPositionMs: Int = 0,
    val durationMs: Int = 0
)

class AudioPlayerHelper(private val context: Context) {
    private var mediaPlayer: MediaPlayer? = null
    private var progressJob: Job? = null
    private val scope = CoroutineScope(Dispatchers.Main)

    private val _playbackState = MutableStateFlow(PlaybackState())
    val playbackState: StateFlow<PlaybackState> = _playbackState.asStateFlow()

    fun playAudio(filePath: String) {
        val file = File(filePath)
        if (!file.exists()) return

        if (_playbackState.value.currentFilePath == filePath && mediaPlayer != null) {
            if (mediaPlayer?.isPlaying == true) {
                pauseAudio()
                return
            } else {
                mediaPlayer?.start()
                _playbackState.value = _playbackState.value.copy(isPlaying = true)
                startProgressTracker()
                return
            }
        }

        stopAudio()

        try {
            mediaPlayer = MediaPlayer().apply {
                setDataSource(context, Uri.fromFile(file))
                prepare()
                start()
                _playbackState.value = PlaybackState(
                    isPlaying = true,
                    currentFilePath = filePath,
                    currentPositionMs = 0,
                    durationMs = duration
                )
                setOnCompletionListener {
                    _playbackState.value = _playbackState.value.copy(isPlaying = false, currentPositionMs = 0)
                    progressJob?.cancel()
                }
            }
            startProgressTracker()
        } catch (e: Exception) {
            e.printStackTrace()
            stopAudio()
        }
    }

    fun pauseAudio() {
        mediaPlayer?.let {
            if (it.isPlaying) {
                it.pause()
                _playbackState.value = _playbackState.value.copy(isPlaying = false)
            }
        }
        progressJob?.cancel()
    }

    fun stopAudio() {
        progressJob?.cancel()
        try {
            mediaPlayer?.apply {
                if (isPlaying) stop()
                release()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            mediaPlayer = null
            _playbackState.value = PlaybackState()
        }
    }

    private fun startProgressTracker() {
        progressJob?.cancel()
        progressJob = scope.launch {
            while (isActive && mediaPlayer?.isPlaying == true) {
                mediaPlayer?.let { player ->
                    _playbackState.value = _playbackState.value.copy(
                        currentPositionMs = player.currentPosition,
                        durationMs = player.duration
                    )
                }
                delay(200)
            }
        }
    }
}
