package com.example.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.DeleteOutline
import androidx.compose.material.icons.filled.EditNote
import androidx.compose.material.icons.filled.GraphicEq
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.PersonalDiaryEntryEntity
import com.example.ui.theme.LocalBookFont
import com.example.ui.theme.LocalBookPalette
import com.example.util.AudioPlayerHelper
import com.example.util.PlaybackState
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun DiaryJournalScreen(
    entries: List<PersonalDiaryEntryEntity>,
    selectedCalendarDateMillis: Long?,
    selectedTag: String?,
    searchQuery: String,
    playbackState: PlaybackState,
    audioPlayer: AudioPlayerHelper,
    onDateSelect: (Long?) -> Unit,
    onTagSelect: (String?) -> Unit,
    onSearchChange: (String) -> Unit,
    onAddDiaryClick: () -> Unit,
    onDeleteEntry: (PersonalDiaryEntryEntity) -> Unit,
    onLockAppClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val palette = LocalBookPalette.current
    val fontFamily = LocalBookFont.current
    var isCalendarExpanded by remember { mutableStateOf(false) }

    val dateFormat = remember { SimpleDateFormat("dd MMMM yyyy, hh:mm a", Locale.getDefault()) }
    val dayFormat = remember { SimpleDateFormat("EEE\ndd", Locale.getDefault()) }

    // Generate current week dates for quick calendar strip
    val calendarDays = remember {
        val list = mutableListOf<Calendar>()
        val cal = Calendar.getInstance()
        cal.add(Calendar.DAY_OF_YEAR, -6)
        for (i in 0..13) {
            val c = Calendar.getInstance().apply { timeInMillis = cal.timeInMillis }
            list.add(c)
            cal.add(Calendar.DAY_OF_YEAR, 1)
        }
        list
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(palette.background)
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(bottom = 96.dp)
        ) {
            // Diary Header Bar
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "Ruhani Diary & Tajurbaat",
                            style = MaterialTheme.typography.titleMedium.copy(fontFamily = fontFamily),
                            fontWeight = FontWeight.Bold,
                            color = palette.textPrimary
                        )
                        Text(
                            text = "Daily reflections, voice notes & personal logs",
                            style = MaterialTheme.typography.bodySmall,
                            color = palette.textSecondary
                        )
                    }

                    Row {
                        IconButton(onClick = { isCalendarExpanded = !isCalendarExpanded }) {
                            Icon(
                                imageVector = Icons.Default.CalendarMonth,
                                contentDescription = "Calendar",
                                tint = if (selectedCalendarDateMillis != null || isCalendarExpanded) palette.accent else palette.textSecondary
                            )
                        }

                        IconButton(onClick = onLockAppClick) {
                            Icon(
                                imageVector = Icons.Default.Lock,
                                contentDescription = "Lock Diary",
                                tint = palette.accent
                            )
                        }
                    }
                }
            }

            // Search Bar for Old Diary Events & Logs (Requested)
            item {
                Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                    OutlinedTextField(
                        value = searchQuery,
                        onValueChange = onSearchChange,
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("search_diary_bar"),
                        placeholder = {
                            Text(
                                "Purani diary entries ya tags search karein...",
                                style = MaterialTheme.typography.bodySmall,
                                color = palette.textSecondary
                            )
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "Search",
                                tint = palette.accent
                            )
                        },
                        trailingIcon = {
                            if (searchQuery.isNotEmpty()) {
                                IconButton(onClick = { onSearchChange("") }) {
                                    Icon(
                                        imageVector = Icons.Default.Clear,
                                        contentDescription = "Clear",
                                        tint = palette.textSecondary
                                    )
                                }
                            }
                        },
                        shape = RoundedCornerShape(12.dp),
                        singleLine = true,
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedContainerColor = palette.surface,
                            unfocusedContainerColor = palette.surface,
                            focusedBorderColor = palette.accent,
                            unfocusedBorderColor = palette.border
                        )
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }

            // Calendar View Strip (visualize entries over time)
            item {
                AnimatedVisibility(visible = isCalendarExpanded || selectedCalendarDateMillis != null) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 4.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Tareekh ke mutabiq mutala (Calendar View):",
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.SemiBold,
                                color = palette.textPrimary
                            )
                            if (selectedCalendarDateMillis != null) {
                                Text(
                                    text = "Filter Hatayein",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = palette.accent,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.clickable { onDateSelect(null) }
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(6.dp))

                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            items(calendarDays) { cal ->
                                val calTime = cal.timeInMillis
                                val isSelected = selectedCalendarDateMillis?.let {
                                    val sel = Calendar.getInstance().apply { timeInMillis = it }
                                    sel.get(Calendar.YEAR) == cal.get(Calendar.YEAR) &&
                                    sel.get(Calendar.DAY_OF_YEAR) == cal.get(Calendar.DAY_OF_YEAR)
                                } ?: false

                                Surface(
                                    shape = RoundedCornerShape(10.dp),
                                    color = if (isSelected) palette.accent else palette.surface,
                                    border = BorderStroke(1.dp, if (isSelected) palette.accent else palette.border),
                                    modifier = Modifier
                                        .size(54.dp, 60.dp)
                                        .clickable {
                                            if (isSelected) onDateSelect(null) else onDateSelect(calTime)
                                        }
                                ) {
                                    Box(
                                        modifier = Modifier.fillMaxSize(),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Text(
                                            text = dayFormat.format(Date(calTime)),
                                            style = MaterialTheme.typography.labelSmall,
                                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                                            color = if (isSelected) MaterialTheme.colorScheme.onPrimary else palette.textPrimary,
                                            textAlign = TextAlign.Center
                                        )
                                    }
                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                    }
                }
            }

            // Tags Filter Row
            item {
                val availableTags = listOf("Reflection", "Dua", "Gratitude", "Sabar", "Learning", "Habit", "Draft")
                LazyRow(
                    contentPadding = PaddingValues(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    modifier = Modifier.padding(bottom = 12.dp)
                ) {
                    item {
                        Surface(
                            shape = RoundedCornerShape(16.dp),
                            color = if (selectedTag == null) palette.accent else palette.surface,
                            border = BorderStroke(1.dp, if (selectedTag == null) palette.accent else palette.border),
                            modifier = Modifier.clickable { onTagSelect(null) }
                        ) {
                            Text(
                                text = "Sabhi Logs (${entries.size})",
                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                                style = MaterialTheme.typography.labelSmall,
                                color = if (selectedTag == null) MaterialTheme.colorScheme.onPrimary else palette.textPrimary
                            )
                        }
                    }

                    items(availableTags) { tag ->
                        val isSelected = selectedTag?.equals(tag, ignoreCase = true) == true
                        Surface(
                            shape = RoundedCornerShape(16.dp),
                            color = if (isSelected) palette.accent else palette.surface,
                            border = BorderStroke(1.dp, if (isSelected) palette.accent else palette.border),
                            modifier = Modifier.clickable {
                                if (isSelected) onTagSelect(null) else onTagSelect(tag)
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
            }

            // Entries List
            if (entries.isEmpty()) {
                item {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(40.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            imageVector = Icons.Default.EditNote,
                            contentDescription = null,
                            tint = palette.textSecondary,
                            modifier = Modifier.size(54.dp)
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            text = "Diary me abhi koi entry nahi hai.",
                            style = MaterialTheme.typography.titleSmall,
                            color = palette.textPrimary,
                            fontWeight = FontWeight.SemiBold
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "Neeche diye gaye button se apna pehla tajurba ya voice note record karein.",
                            style = MaterialTheme.typography.bodySmall,
                            color = palette.textSecondary,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            } else {
                items(entries, key = { it.id }) { entry ->
                    DiaryItemCard(
                        entry = entry,
                        dateFormat = dateFormat,
                        palette = palette,
                        fontFamily = fontFamily,
                        playbackState = playbackState,
                        audioPlayer = audioPlayer,
                        onDelete = { onDeleteEntry(entry) },
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp)
                    )
                }
            }
        }

        // FAB: Add Voice Note / Diary Entry
        FloatingActionButton(
            onClick = onAddDiaryClick,
            containerColor = palette.accent,
            contentColor = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = 80.dp, end = 20.dp)
                .testTag("add_diary_fab")
        ) {
            Row(
                modifier = Modifier.padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(imageVector = Icons.Default.Mic, contentDescription = null)
                Spacer(modifier = Modifier.width(8.dp))
                Text("Record / Likhien", fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Composable
private fun DiaryItemCard(
    entry: PersonalDiaryEntryEntity,
    dateFormat: SimpleDateFormat,
    palette: com.example.ui.theme.BookPalette,
    fontFamily: androidx.compose.ui.text.font.FontFamily,
    playbackState: PlaybackState,
    audioPlayer: AudioPlayerHelper,
    onDelete: () -> Unit,
    modifier: Modifier = Modifier
) {
    val hasVoiceNote = !entry.voiceNoteFilePath.isNullOrBlank()
    val isPlayingThis = playbackState.isPlaying && playbackState.currentFilePath == entry.voiceNoteFilePath

    Card(
        modifier = modifier
            .fillMaxWidth()
            .testTag("diary_entry_${entry.id}"),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = palette.surface),
        border = BorderStroke(1.dp, palette.border),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            // Header: Date & Delete Button
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = dateFormat.format(Date(entry.dateMillis)),
                    style = MaterialTheme.typography.labelSmall,
                    color = palette.accent,
                    fontWeight = FontWeight.SemiBold
                )

                IconButton(
                    onClick = onDelete,
                    modifier = Modifier.size(28.dp).testTag("delete_entry_${entry.id}")
                ) {
                    Icon(
                        imageVector = Icons.Default.DeleteOutline,
                        contentDescription = "Delete",
                        tint = MaterialTheme.colorScheme.error,
                        modifier = Modifier.size(16.dp)
                    )
                }
            }

            // Title
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = entry.title,
                style = MaterialTheme.typography.titleMedium.copy(fontFamily = fontFamily),
                fontWeight = FontWeight.Bold,
                color = palette.textPrimary
            )

            // Content Text
            if (entry.content.isNotBlank()) {
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = entry.content,
                    style = MaterialTheme.typography.bodyMedium.copy(fontFamily = fontFamily),
                    color = palette.textPrimary,
                    lineHeight = 22.sp
                )
            }

            // Voice Note Player (if attached)
            if (hasVoiceNote) {
                Spacer(modifier = Modifier.height(10.dp))
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = palette.border.copy(alpha = 0.35f),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp, vertical = 6.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(
                            onClick = {
                                entry.voiceNoteFilePath?.let { audioPlayer.playAudio(it) }
                            },
                            modifier = Modifier.size(36.dp).testTag("play_entry_audio_${entry.id}")
                        ) {
                            Icon(
                                imageVector = if (isPlayingThis) Icons.Default.Pause else Icons.Default.PlayArrow,
                                contentDescription = "Play/Pause",
                                tint = palette.accent,
                                modifier = Modifier.size(24.dp)
                            )
                        }

                        Spacer(modifier = Modifier.width(8.dp))

                        Column(modifier = Modifier.weight(1f)) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = if (isPlayingThis) "Playing Voice Note..." else "Voice Note Recorded",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = palette.textPrimary,
                                    fontWeight = FontWeight.Medium
                                )
                                Text(
                                    text = "${entry.voiceDurationSeconds}s",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = palette.accent
                                )
                            }
                            if (isPlayingThis && playbackState.durationMs > 0) {
                                Spacer(modifier = Modifier.height(4.dp))
                                LinearProgressIndicator(
                                    progress = { playbackState.currentPositionMs.toFloat() / playbackState.durationMs },
                                    modifier = Modifier.fillMaxWidth().height(3.dp),
                                    color = palette.accent,
                                    trackColor = palette.border
                                )
                            }
                        }
                    }
                }
            }

            // Tags
            if (entry.tags.isNotBlank()) {
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    entry.tags.split(",").forEach { rawTag ->
                        val t = rawTag.trim()
                        if (t.isNotBlank()) {
                            Text(
                                text = if (t.startsWith("#")) t else "#$t",
                                style = MaterialTheme.typography.labelSmall,
                                color = palette.accent,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }
                }
            }
        }
    }
}
