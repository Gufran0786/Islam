package com.example.util

import android.content.Context
import android.media.MediaRecorder
import android.os.Build
import android.os.SystemClock
import java.io.File
import java.io.IOException

class AudioRecorderHelper(private val context: Context) {

    private var mediaRecorder: MediaRecorder? = null
    private var currentOutputFile: File? = null
    private var startTimeMillis: Long = 0L

    var isRecording: Boolean = false
        private set

    fun startRecording(): File? {
        if (isRecording) return currentOutputFile

        val audioDir = File(context.filesDir, "voice_notes").apply { mkdirs() }
        val file = File(audioDir, "note_${System.currentTimeMillis()}.m4a")
        currentOutputFile = file

        mediaRecorder = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            MediaRecorder(context)
        } else {
            @Suppress("DEPRECATION")
            MediaRecorder()
        }.apply {
            try {
                setAudioSource(MediaRecorder.AudioSource.MIC)
                setOutputFormat(MediaRecorder.OutputFormat.MPEG_4)
                setAudioEncoder(MediaRecorder.AudioEncoder.AAC)
                setAudioEncodingBitRate(128000)
                setAudioSamplingRate(44100)
                setOutputFile(file.absolutePath)
                prepare()
                start()
                isRecording = true
                startTimeMillis = SystemClock.elapsedRealtime()
            } catch (e: IOException) {
                e.printStackTrace()
                isRecording = false
                return null
            } catch (e: IllegalStateException) {
                e.printStackTrace()
                isRecording = false
                return null
            }
        }

        return file
    }

    fun stopRecording(): Pair<File?, Int> {
        if (!isRecording) return Pair(null, 0)

        val durationSeconds = ((SystemClock.elapsedRealtime() - startTimeMillis) / 1000).toInt()
        try {
            mediaRecorder?.apply {
                stop()
                release()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            mediaRecorder = null
            isRecording = false
        }

        return Pair(currentOutputFile, durationSeconds.coerceAtLeast(1))
    }

    fun cancelRecording() {
        if (isRecording) {
            try {
                mediaRecorder?.apply {
                    stop()
                    release()
                }
            } catch (e: Exception) {
                // Ignore cancellation error
            } finally {
                mediaRecorder = null
                isRecording = false
            }
            currentOutputFile?.delete()
            currentOutputFile = null
        }
    }
}
