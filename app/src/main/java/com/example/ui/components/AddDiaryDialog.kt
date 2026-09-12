package com.example.ui.components

import android.Manifest
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.GraphicEq
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Stop
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.core.content.ContextCompat
import com.example.util.AudioPlayerHelper
import com.example.util.AudioRecorderHelper
import com.example.ui.theme.LocalBookPalette
import kotlinx.coroutines.delay
import java.io.File

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun AddDiaryDialog(
    audioRecorder: AudioRecorderHelper,
    audioPlayer: AudioPlayerHelper,
    onDismiss: () -> Unit,
    onSave: (title: String, content: String, tags: String, voiceFile: File?, durationSeconds: Int) -> Unit
) {
    val palette = LocalBookPalette.current
    val context = LocalContext.current

    var title by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }
    var tagsInput by remember { mutableStateOf("Reflection") }

    var isRecording by remember { mutableStateOf(false) }
    var recordingTimerSeconds by remember { mutableIntStateOf(0) }
    var recordedAudioFile by remember { mutableStateOf<File?>(null) }
    var recordedDurationSeconds by remember { mutableIntStateOf(0) }
    var isPlayingPreview by remember { mutableStateOf(false) }

    val presetTags = listOf("Reflection", "Dua", "Gratitude", "Sabar", "Learning", "Habit", "Draft")

    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { granted ->
        if (granted) {
            val file = audioRecorder.startRecording()
            if (file != null) {
                isRecording = true
                recordingTimerSeconds = 0
            }
        }
    }

    LaunchedEffect(isRecording) {
        if (isRecording) {
            while (isRecording) {
                delay(1000)
                recordingTimerSeconds += 1
            }
        }
    }

    Dialog(
        onDismissRequest = {
            if (isRecording) audioRecorder.cancelRecording()
            audioPlayer.stopAudio()
            onDismiss()
        },
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth(0.94f)
                .heightIn(max = 680.dp)
                .testTag("add_diary_dialog"),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = palette.surface),
            border = BorderStroke(1.dp, palette.border)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {
                // Header
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Rozana Tajurba & Voice Note Darj Karein",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = palette.textPrimary
                    )
                    IconButton(onClick = {
                        if (isRecording) audioRecorder.cancelRecording()
                        audioPlayer.stopAudio()
                        onDismiss()
                    }) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Close",
                            tint = palette.textSecondary
                        )
                    }
                }

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .verticalScroll(rememberScrollState())
                        .padding(vertical = 8.dp)
                ) {
                    OutlinedTextField(
                        value = title,
                        onValueChange = { title = it },
                        label = { Text("Unwaan / Title (e.g. Hazrat Yusuf ke sabr par tadabbur)") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp)
                            .testTag("diary_title_input"),
                        singleLine = true
                    )

                    OutlinedTextField(
                        value = content,
                        onValueChange = { content = it },
                        label = { Text("Apne Dilli Ehsaas / Reflections Likhien...") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp)
                            .testTag("diary_content_input"),
                        minLines = 4,
                        maxLines = 8
                    )

                    // Tag categorization system
                    Text(
                        text = "Tags / Categories (#tag):",
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.SemiBold,
                        color = palette.textPrimary,
                        modifier = Modifier.padding(top = 4.dp, bottom = 4.dp)
                    )

                    FlowRow(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp),
                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                        verticalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        presetTags.forEach { tag ->
                            val isSelected = tagsInput.contains(tag, ignoreCase = true)
                            Surface(
                                shape = RoundedCornerShape(16.dp),
                                color = if (isSelected) palette.accent else palette.border.copy(alpha = 0.3f),
                                modifier = Modifier.clickable {
                                    tagsInput = if (isSelected) {
                                        tagsInput.split(",").map { it.trim() }.filter { !it.equals(tag, ignoreCase = true) }.joinToString(", ")
                                    } else {
                                        if (tagsInput.isBlank()) tag else "$tagsInput, $tag"
                                    }
                                }
                            ) {
                                Text(
                                    text = "#$tag",
                                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                                    style = MaterialTheme.typography.labelSmall,
                                    color = if (isSelected) MaterialTheme.colorScheme.onPrimary else palette.textPrimary
                                )
                            }
                        }
                    }

                    OutlinedTextField(
                        value = tagsInput,
                        onValueChange = { tagsInput = it },
                        label = { Text("Custom Tags (comma-separated)") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 12.dp),
                        singleLine = true
                    )

                    // VOICE NOTE RECORDING SECTION (Requested feature)
                    Surface(
                        shape = RoundedCornerShape(12.dp),
                        color = palette.border.copy(alpha = 0.25f),
                        border = BorderStroke(1.dp, palette.border),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier.padding(14.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "🎙️ Voice Note Recording (Audio Diary)",
                                style = MaterialTheme.typography.bodySmall,
                                fontWeight = FontWeight.Bold,
                                color = palette.textPrimary
                            )
                            Spacer(modifier = Modifier.height(8.dp))

                            if (isRecording) {
                                // Live recording UI
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.Center
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.GraphicEq,
                                        contentDescription = null,
                                        tint = MaterialTheme.colorScheme.error,
                                        modifier = Modifier.size(24.dp)
                                    )
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Text(
                                        text = "Recording... ${String.format("%02d:%02d", recordingTimerSeconds / 60, recordingTimerSeconds % 60)}",
                                        style = MaterialTheme.typography.titleMedium,
                                        color = MaterialTheme.colorScheme.error,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                                Spacer(modifier = Modifier.height(10.dp))
                                Button(
                                    onClick = {
                                        val (file, duration) = audioRecorder.stopRecording()
                                        recordedAudioFile = file
                                        recordedDurationSeconds = duration
                                        isRecording = false
                                    },
                                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error),
                                    shape = RoundedCornerShape(8.dp),
                                    modifier = Modifier.testTag("stop_recording_button")
                                ) {
                                    Icon(imageVector = Icons.Default.Stop, contentDescription = null)
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Text("Stop & Save Recording")
                                }
                            } else if (recordedAudioFile != null) {
                                // Recorded voice preview
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        IconButton(
                                            onClick = {
                                                recordedAudioFile?.let {
                                                    if (isPlayingPreview) {
                                                        audioPlayer.pauseAudio()
                                                        isPlayingPreview = false
                                                    } else {
                                                        audioPlayer.playAudio(it.absolutePath)
                                                        isPlayingPreview = true
                                                    }
                                                }
                                            },
                                            modifier = Modifier.testTag("play_preview_button")
                                        ) {
                                            Icon(
                                                imageVector = if (isPlayingPreview) Icons.Default.Pause else Icons.Default.PlayArrow,
                                                contentDescription = "Play/Pause",
                                                tint = palette.accent
                                            )
                                        }
                                        Text(
                                            text = "Voice Note (${recordedDurationSeconds}s)",
                                            style = MaterialTheme.typography.bodyMedium,
                                            fontWeight = FontWeight.Medium,
                                            color = palette.textPrimary
                                        )
                                    }

                                    IconButton(
                                        onClick = {
                                            audioPlayer.stopAudio()
                                            recordedAudioFile?.delete()
                                            recordedAudioFile = null
                                            recordedDurationSeconds = 0
                                            isPlayingPreview = false
                                        },
                                        modifier = Modifier.testTag("delete_voice_note_button")
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Delete,
                                            contentDescription = "Delete Voice",
                                            tint = MaterialTheme.colorScheme.error
                                        )
                                    }
                                }
                            } else {
                                // Ready to record
                                Button(
                                    onClick = {
                                        val hasPermission = ContextCompat.checkSelfPermission(
                                            context,
                                            Manifest.permission.RECORD_AUDIO
                                        ) == PackageManager.PERMISSION_GRANTED
                                        if (hasPermission) {
                                            val file = audioRecorder.startRecording()
                                            if (file != null) {
                                                isRecording = true
                                                recordingTimerSeconds = 0
                                            }
                                        } else {
                                            permissionLauncher.launch(Manifest.permission.RECORD_AUDIO)
                                        }
                                    },
                                    colors = ButtonDefaults.buttonColors(containerColor = palette.accent),
                                    shape = RoundedCornerShape(8.dp),
                                    modifier = Modifier.testTag("start_recording_button")
                                ) {
                                    Icon(imageVector = Icons.Default.Mic, contentDescription = null)
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Text("Apni Aawaz Me Voice Note Record Karein")
                                }
                            }
                        }
                    }
                }

                // Action Buttons
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    OutlinedButton(
                        onClick = {
                            if (isRecording) audioRecorder.cancelRecording()
                            audioPlayer.stopAudio()
                            onDismiss()
                        },
                        modifier = Modifier.padding(end = 8.dp)
                    ) {
                        Text("Cancel", color = palette.textSecondary)
                    }

                    Button(
                        onClick = {
                            if (title.isNotBlank() || content.isNotBlank() || recordedAudioFile != null) {
                                audioPlayer.stopAudio()
                                onSave(
                                    title,
                                    content,
                                    tagsInput,
                                    recordedAudioFile,
                                    recordedDurationSeconds
                                )
                            }
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = palette.accent),
                        modifier = Modifier.testTag("save_diary_button")
                    ) {
                        Text("Diary Me Mehfooz Karein", fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}
