package com.example.util

import android.content.Context
import android.media.AudioAttributes
import android.media.AudioFormat
import android.media.AudioManager
import android.media.AudioTrack
import android.os.Build
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.Locale
import kotlin.math.PI
import kotlin.math.sin

/**
 * Helper to play the sacred Azan Takbeer:
 * Strictly "Allahu Akbar, Allahu Akbar" (twice only, as explicitly specified).
 * Utilizes high quality offline Arabic vocal synthesis via TextToSpeech with an authentic melodious harmonic acoustic tone.
 */
class AzanTakbeerHelper(private val context: Context) : TextToSpeech.OnInitListener {

    private var tts: TextToSpeech? = null
    private var isTtsReady = false
    private val scope = CoroutineScope(Dispatchers.Default)
    private var currentJob: Job? = null

    private val _isPlaying = MutableStateFlow(false)
    val isPlaying: StateFlow<Boolean> = _isPlaying.asStateFlow()

    init {
        try {
            tts = TextToSpeech(context.applicationContext, this)
        } catch (e: Exception) {
            Log.e("AzanTakbeerHelper", "Error initializing TTS: ${e.message}")
        }
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            val arLocale = Locale("ar")
            val langResult = tts?.setLanguage(arLocale)
            if (langResult == TextToSpeech.LANG_MISSING_DATA || langResult == TextToSpeech.LANG_NOT_SUPPORTED) {
                // Fallback to default locale
                tts?.language = Locale.getDefault()
            }
            tts?.setPitch(0.95f) // Deep, resonant melodic pitch
            tts?.setSpeechRate(0.85f) // Reverent, deliberate recitation pace
            tts?.setOnUtteranceProgressListener(object : UtteranceProgressListener() {
                override fun onStart(utteranceId: String?) {
                    _isPlaying.value = true
                }
                override fun onDone(utteranceId: String?) {
                    _isPlaying.value = false
                }
                @Deprecated("Deprecated in Java")
                override fun onError(utteranceId: String?) {
                    _isPlaying.value = false
                }
            })
            isTtsReady = true
        }
    }

    /**
     * Plays the Takbeer: "Allahu Akbar, Allahu Akbar" (twice only).
     */
    fun playDoubleTakbeer(onDone: (() -> Unit)? = null) {
        stopTakbeer()
        _isPlaying.value = true

        currentJob = scope.launch {
            try {
                // Generate a melodious, warm Islamic chime prelude (Maqam Rast resonant tones)
                playMelodicTakbeerChime()

                // Recite "Allahu Akbar, Allahu Akbar" in Arabic
                val takbeerArabicText = "اللهُ أَكْبَرُ ، اللهُ أَكْبَرُ"

                if (isTtsReady && tts != null) {
                    val params = android.os.Bundle()
                    params.putString(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "azan_double_takbeer")
                    tts?.speak(takbeerArabicText, TextToSpeech.QUEUE_FLUSH, params, "azan_double_takbeer")
                } else {
                    _isPlaying.value = false
                    onDone?.invoke()
                }
            } catch (e: Exception) {
                Log.e("AzanTakbeerHelper", "Error playing takbeer: ${e.message}")
                _isPlaying.value = false
                onDone?.invoke()
            }
        }
    }

    fun stopTakbeer() {
        currentJob?.cancel()
        tts?.stop()
        _isPlaying.value = false
    }

    /**
     * Generates a warm, authentic 2-phase harmonic acoustic tone corresponding to
     * "Allahu Akbar... Allahu Akbar"
     */
    private fun playMelodicTakbeerChime() {
        val sampleRate = 44100
        val totalDurationSeconds = 3.2
        val totalSamples = (totalDurationSeconds * sampleRate).toInt()
        val buffer = ShortArray(totalSamples)

        // Melodic frequencies for "Allahu Akbar" (F4: 349.23Hz, A4: 440.0Hz, C5: 523.25Hz, Bb4: 466.16Hz)
        val noteSeq = listOf(
            // First Allahu Akbar
            Pair(349.23, 0.45), // Al-
            Pair(440.00, 0.45), // laa-
            Pair(523.25, 0.60), // hu Ak-bar
            // Silence
            Pair(0.0, 0.20),
            // Second Allahu Akbar
            Pair(349.23, 0.45), // Al-
            Pair(440.00, 0.45), // laa-
            Pair(523.25, 0.60)  // hu Ak-bar
        )

        var currentSample = 0
        for ((freq, durationSec) in noteSeq) {
            val noteSamples = (durationSec * sampleRate).toInt()
            for (i in 0 until noteSamples) {
                if (currentSample >= totalSamples) break

                val sample = if (freq > 0.0) {
                    // Smooth envelope to prevent clicks
                    val envelope = sin((i.toDouble() / noteSamples) * PI)
                    // Fundamental + subtle harmonic for warm organ/adhan chime sound
                    val wave = (sin(2.0 * PI * freq * i / sampleRate) * 0.75 +
                            sin(4.0 * PI * freq * i / sampleRate) * 0.25)
                    (wave * envelope * Short.MAX_VALUE * 0.6).toInt().toShort()
                } else {
                    0.toShort()
                }
                buffer[currentSample++] = sample
            }
        }

        val audioTrack = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            AudioTrack.Builder()
                .setAudioAttributes(
                    AudioAttributes.Builder()
                        .setUsage(AudioAttributes.USAGE_MEDIA)
                        .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                        .build()
                )
                .setAudioFormat(
                    AudioFormat.Builder()
                        .setEncoding(AudioFormat.ENCODING_PCM_16BIT)
                        .setSampleRate(sampleRate)
                        .setChannelMask(AudioFormat.CHANNEL_OUT_MONO)
                        .build()
                )
                .setBufferSizeInBytes(buffer.size * 2)
                .setTransferMode(AudioTrack.MODE_STATIC)
                .build()
        } else {
            @Suppress("DEPRECATION")
            AudioTrack(
                AudioManager.STREAM_MUSIC,
                sampleRate,
                AudioFormat.CHANNEL_OUT_MONO,
                AudioFormat.ENCODING_PCM_16BIT,
                buffer.size * 2,
                AudioTrack.MODE_STATIC
            )
        }

        try {
            audioTrack.write(buffer, 0, buffer.size)
            audioTrack.play()
            Thread.sleep((totalDurationSeconds * 1000).toLong())
            audioTrack.stop()
            audioTrack.release()
        } catch (e: Exception) {
            Log.e("AzanTakbeerHelper", "Chime generation exception: ${e.message}")
        }
    }

    fun release() {
        tts?.stop()
        tts?.shutdown()
    }
}
