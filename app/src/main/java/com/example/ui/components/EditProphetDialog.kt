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
import com.example.data.ProphetEntity
import com.example.ui.theme.LocalBookPalette

@Composable
fun EditProphetDialog(
    prophet: ProphetEntity?,
    isNew: Boolean = false,
    onDismiss: () -> Unit,
    onSave: (ProphetEntity) -> Unit
) {
    val palette = LocalBookPalette.current
    val context = LocalContext.current

    var nameRoman by remember { mutableStateOf(prophet?.nameRoman ?: "") }
    var nameArabic by remember { mutableStateOf(prophet?.nameArabic ?: "") }
    var title by remember { mutableStateOf(prophet?.title ?: "") }
    var ageYears by remember { mutableStateOf(prophet?.ageYears ?: "") }
    var fatherName by remember { mutableStateOf(prophet?.fatherName ?: "") }
    var motherName by remember { mutableStateOf(prophet?.motherName ?: "") }
    var siblings by remember { mutableStateOf(prophet?.siblings ?: "") }
    var children by remember { mutableStateOf(prophet?.children ?: "") }
    var wives by remember { mutableStateOf(prophet?.wives ?: "") }
    var eraLocation by remember { mutableStateOf(prophet?.eraLocation ?: "") }
    var summaryHighlights by remember { mutableStateOf(prophet?.summaryHighlights ?: "") }
    var photoUriString by remember { mutableStateOf(prophet?.photoUrlOrRes ?: "img_app_icon") }

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
                .testTag("edit_prophet_dialog"),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = palette.surface),
            border = BorderStroke(1.dp, palette.border)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {
                // Dialog Title Bar
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = if (isNew) "Naya Nabi Profile Shamil Karein" else "Nabi Ki Jankari Edit Karein",
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

                // Scrollable Form Fields
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .verticalScroll(rememberScrollState())
                        .padding(vertical = 8.dp)
                ) {
                    // Photo Picker Section
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(72.dp)
                                .clip(RoundedCornerShape(10.dp))
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
                                photoUriString == "img_book_banner" -> R.drawable.img_book_banner
                                else -> R.drawable.img_app_icon
                            }

                            AsyncImage(
                                model = ImageRequest.Builder(context)
                                    .data(photoModel)
                                    .crossfade(true)
                                    .build(),
                                placeholder = painterResource(R.drawable.img_app_icon),
                                error = painterResource(R.drawable.img_app_icon),
                                contentDescription = "Prophet Photo",
                                modifier = Modifier.matchParentSize(),
                                contentScale = ContentScale.Crop
                            )
                        }

                        Spacer(modifier = Modifier.width(16.dp))

                        Column {
                            Text(
                                text = "Nabi / Paighambar Ki Photo / Emblem",
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
                                modifier = Modifier.testTag("pick_photo_button")
                            ) {
                                Icon(
                                    imageVector = Icons.Default.AddPhotoAlternate,
                                    contentDescription = null,
                                    modifier = Modifier.size(16.dp)
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Text("Gallery se Photo Chunein", fontSize = 12.sp)
                            }
                        }
                    }

                    OutlinedTextField(
                        value = nameRoman,
                        onValueChange = { nameRoman = it },
                        label = { Text("Naam (Roman / English / Hindi)") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp)
                            .testTag("input_name_roman"),
                        singleLine = true
                    )

                    OutlinedTextField(
                        value = nameArabic,
                        onValueChange = { nameArabic = it },
                        label = { Text("Arabi Naam (Calligraphy)") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp)
                            .testTag("input_name_arabic"),
                        singleLine = true
                    )

                    OutlinedTextField(
                        value = title,
                        onValueChange = { title = it },
                        label = { Text("Laqab / Title (Jaise Khalilullah, Kalimullah)") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp),
                        singleLine = true
                    )

                    Row(modifier = Modifier.fillMaxWidth()) {
                        OutlinedTextField(
                            value = ageYears,
                            onValueChange = { ageYears = it },
                            label = { Text("Umar (Lifespan)") },
                            modifier = Modifier
                                .weight(1f)
                                .padding(end = 4.dp, bottom = 8.dp),
                            singleLine = true
                        )
                        OutlinedTextField(
                            value = eraLocation,
                            onValueChange = { eraLocation = it },
                            label = { Text("Zamana / Muqam") },
                            modifier = Modifier
                                .weight(1f)
                                .padding(start = 4.dp, bottom = 8.dp),
                            singleLine = true
                        )
                    }

                    Row(modifier = Modifier.fillMaxWidth()) {
                        OutlinedTextField(
                            value = fatherName,
                            onValueChange = { fatherName = it },
                            label = { Text("Walid (Father)") },
                            modifier = Modifier
                                .weight(1f)
                                .padding(end = 4.dp, bottom = 8.dp),
                            singleLine = true
                        )
                        OutlinedTextField(
                            value = motherName,
                            onValueChange = { motherName = it },
                            label = { Text("Walida (Mother)") },
                            modifier = Modifier
                                .weight(1f)
                                .padding(start = 4.dp, bottom = 8.dp),
                            singleLine = true
                        )
                    }

                    OutlinedTextField(
                        value = siblings,
                        onValueChange = { siblings = it },
                        label = { Text("Bhai aur Bahen (Brothers & Sisters)") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp),
                        singleLine = true
                    )

                    OutlinedTextField(
                        value = children,
                        onValueChange = { children = it },
                        label = { Text("Aulad (Children)") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp),
                        singleLine = true
                    )

                    OutlinedTextField(
                        value = wives,
                        onValueChange = { wives = it },
                        label = { Text("Biwiyan (Wife / Wives)") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp),
                        singleLine = true
                    )

                    OutlinedTextField(
                        value = summaryHighlights,
                        onValueChange = { summaryHighlights = it },
                        label = { Text("Mukhya Khulasa (Summary Highlights)") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp),
                        minLines = 2,
                        maxLines = 4
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
                            if (nameRoman.isNotBlank()) {
                                val updated = prophet?.copy(
                                    nameRoman = nameRoman.trim(),
                                    nameArabic = nameArabic.trim().ifBlank { nameRoman },
                                    title = title.trim(),
                                    ageYears = ageYears.trim(),
                                    fatherName = fatherName.trim(),
                                    motherName = motherName.trim(),
                                    siblings = siblings.trim(),
                                    children = children.trim(),
                                    wives = wives.trim(),
                                    eraLocation = eraLocation.trim(),
                                    summaryHighlights = summaryHighlights.trim(),
                                    photoUrlOrRes = photoUriString,
                                    lastUpdated = System.currentTimeMillis()
                                ) ?: ProphetEntity(
                                    orderIndex = 43,
                                    nameRoman = nameRoman.trim(),
                                    nameArabic = nameArabic.trim().ifBlank { nameRoman },
                                    title = title.trim(),
                                    ageYears = ageYears.trim(),
                                    fatherName = fatherName.trim(),
                                    motherName = motherName.trim(),
                                    siblings = siblings.trim(),
                                    children = children.trim(),
                                    wives = wives.trim(),
                                    eraLocation = eraLocation.trim(),
                                    summaryHighlights = summaryHighlights.trim(),
                                    photoUrlOrRes = photoUriString
                                )
                                onSave(updated)
                            }
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = palette.accent),
                        modifier = Modifier.testTag("save_prophet_button")
                    ) {
                        Text("Save Karein", fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}
