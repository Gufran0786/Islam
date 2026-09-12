package com.example.ui.components

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddPhotoAlternate
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.R
import com.example.data.ProphetEventEntity
import com.example.ui.theme.LocalBookPalette

@Composable
fun EditEventDialog(
    event: ProphetEventEntity?,
    prophetId: Int,
    onDismiss: () -> Unit,
    onSave: (ProphetEventEntity) -> Unit
) {
    val palette = LocalBookPalette.current
    val context = LocalContext.current

    var title by remember { mutableStateOf(event?.title ?: "") }
    var summary by remember { mutableStateOf(event?.summary ?: "") }
    var detailedNarrative by remember { mutableStateOf(event?.detailedNarrative ?: "") }
    var quranicReference by remember { mutableStateOf(event?.quranicReference ?: "") }
    var moralLesson by remember { mutableStateOf(event?.moralLesson ?: "") }
    var photoUriString by remember { mutableStateOf(event?.eventPhotoUrlOrRes ?: "img_book_banner") }

    val photoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia()
    ) { uri: Uri? ->
        if (uri != null) {
            photoUriString = uri.toString()
        }
    }

    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth(0.94f)
                .heightIn(max = 680.dp)
                .testTag("edit_event_dialog"),
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
                        text = if (event == null || event.id == 0) "Nayi Ghatna Darj Karein" else "Ghatna Edit Karein",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = palette.textPrimary
                    )
                    IconButton(onClick = onDismiss) {
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
                    // Event Photo Preview and Change
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(80.dp, 60.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .background(palette.border.copy(alpha = 0.4f))
                                .clickable {
                                    photoPickerLauncher.launch(
                                        PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                                    )
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            val photoModel: Any = when {
                                photoUriString.startsWith("content://") ||
                                photoUriString.startsWith("http") ||
                                photoUriString.startsWith("file://") -> photoUriString
                                photoUriString == "img_app_icon" -> R.drawable.img_app_icon
                                else -> R.drawable.img_book_banner
                            }

                            AsyncImage(
                                model = ImageRequest.Builder(context)
                                    .data(photoModel)
                                    .crossfade(true)
                                    .build(),
                                placeholder = painterResource(R.drawable.img_book_banner),
                                error = painterResource(R.drawable.img_book_banner),
                                contentDescription = "Event Photo",
                                modifier = Modifier.matchParentSize(),
                                contentScale = ContentScale.Crop
                            )
                        }

                        Spacer(modifier = Modifier.width(12.dp))

                        Column {
                            Text(
                                text = "Ghatna Ki Photo / Illustration",
                                style = MaterialTheme.typography.bodySmall,
                                fontWeight = FontWeight.SemiBold,
                                color = palette.textPrimary
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Button(
                                onClick = {
                                    photoPickerLauncher.launch(
                                        PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                                    )
                                },
                                shape = RoundedCornerShape(8.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = palette.accent),
                                modifier = Modifier.testTag("pick_event_photo_button")
                            ) {
                                Icon(
                                    imageVector = Icons.Default.AddPhotoAlternate,
                                    contentDescription = null,
                                    modifier = Modifier.size(16.dp)
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Text("Photo Change Karein", fontSize = 12.sp)
                            }
                        }
                    }

                    OutlinedTextField(
                        value = title,
                        onValueChange = { title = it },
                        label = { Text("Ghatna Ka Unwaan (Event Title)") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp)
                            .testTag("input_event_title"),
                        singleLine = true
                    )

                    OutlinedTextField(
                        value = summary,
                        onValueChange = { summary = it },
                        label = { Text("Quick Summary / Khulasa (Highlights)") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp)
                            .testTag("input_event_summary"),
                        minLines = 2,
                        maxLines = 3
                    )

                    OutlinedTextField(
                        value = detailedNarrative,
                        onValueChange = { detailedNarrative = it },
                        label = { Text("Mufassal Bayan / Kitabi Waqia (Detailed Story)") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp)
                            .testTag("input_event_narrative"),
                        minLines = 4,
                        maxLines = 8
                    )

                    OutlinedTextField(
                        value = quranicReference,
                        onValueChange = { quranicReference = it },
                        label = { Text("Quranic Hawala (Surah & Ayat)") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp),
                        singleLine = true
                    )

                    OutlinedTextField(
                        value = moralLesson,
                        onValueChange = { moralLesson = it },
                        label = { Text("Ibrat / Hidayat (Moral Lesson)") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp),
                        minLines = 2,
                        maxLines = 3
                    )
                }

                // Action Buttons
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    OutlinedButton(
                        onClick = onDismiss,
                        modifier = Modifier.padding(end = 8.dp)
                    ) {
                        Text("Cancel", color = palette.textSecondary)
                    }

                    Button(
                        onClick = {
                            if (title.isNotBlank() && detailedNarrative.isNotBlank()) {
                                val saved = event?.copy(
                                    title = title.trim(),
                                    summary = summary.trim().ifBlank { title.trim() },
                                    detailedNarrative = detailedNarrative.trim(),
                                    eventPhotoUrlOrRes = photoUriString,
                                    quranicReference = quranicReference.trim(),
                                    moralLesson = moralLesson.trim(),
                                    lastUpdated = System.currentTimeMillis()
                                ) ?: ProphetEventEntity(
                                    prophetId = prophetId,
                                    title = title.trim(),
                                    summary = summary.trim().ifBlank { title.trim() },
                                    detailedNarrative = detailedNarrative.trim(),
                                    eventPhotoUrlOrRes = photoUriString,
                                    quranicReference = quranicReference.trim(),
                                    moralLesson = moralLesson.trim()
                                )
                                onSave(saved)
                            }
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = palette.accent),
                        modifier = Modifier.testTag("save_event_button")
                    ) {
                        Text("Save Karein", fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}
