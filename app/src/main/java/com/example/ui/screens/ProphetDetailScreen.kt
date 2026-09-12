package com.example.ui.screens

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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddPhotoAlternate
import androidx.compose.material.icons.filled.AutoStories
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Palette
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.R
import com.example.data.ProphetEntity
import com.example.data.ProphetEventEntity
import com.example.ui.components.EventItemView
import com.example.ui.theme.LocalBookFont
import com.example.ui.theme.LocalBookPalette

@Composable
fun ProphetDetailScreen(
    prophet: ProphetEntity,
    events: List<ProphetEventEntity>,
    onBack: () -> Unit,
    onToggleBookmark: () -> Unit,
    onEditProphet: () -> Unit,
    onAddEvent: () -> Unit,
    onEditEvent: (ProphetEventEntity) -> Unit,
    onDeleteEvent: (ProphetEventEntity) -> Unit,
    onOpenAppearanceSheet: () -> Unit,
    onUpdatePhoto: (String) -> Unit,
    language: com.example.data.AppLanguage = com.example.data.AppLanguage.HINDI,
    modifier: Modifier = Modifier
) {
    val palette = LocalBookPalette.current
    val fontFamily = LocalBookFont.current
    val context = LocalContext.current

    val ageLabel = com.example.util.AppLocaleManager.getUiString("age", language)
    val fatherLabel = com.example.util.AppLocaleManager.getUiString("father", language)
    val motherLabel = com.example.util.AppLocaleManager.getUiString("mother", language)
    val siblingsLabel = com.example.util.AppLocaleManager.getUiString("siblings", language)
    val eraLabel = com.example.util.AppLocaleManager.getUiString("era_location", language)
    val childrenLabel = com.example.util.AppLocaleManager.getUiString("children", language)
    val wivesLabel = com.example.util.AppLocaleManager.getUiString("wives", language)
    val summaryTitle = com.example.util.AppLocaleManager.getUiString("summary_highlights", language)
    val keyEventsTitle = com.example.util.AppLocaleManager.getUiString("key_events", language)
    val pageLabel = com.example.util.AppLocaleManager.getUiString("page", language)
    val localizedTitle = com.example.util.AppLocaleManager.getLocalizedProphetTitle(prophet.title, language)

    val photoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia()
    ) { uri: Uri? ->
        if (uri != null) {
            onUpdatePhoto(uri.toString())
        }
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
            // Top Navigation Bar
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = onBack, modifier = Modifier.testTag("detail_back_button")) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = palette.textPrimary
                        )
                    }

                    Text(
                        text = "$pageLabel #${prophet.orderIndex}",
                        style = MaterialTheme.typography.titleSmall.copy(fontFamily = fontFamily),
                        fontWeight = FontWeight.Bold,
                        color = palette.accent
                    )

                    Row {
                        IconButton(onClick = onOpenAppearanceSheet) {
                            Icon(
                                imageVector = Icons.Default.Palette,
                                contentDescription = "Styles",
                                tint = palette.accent
                            )
                        }

                        IconButton(onClick = onToggleBookmark) {
                            Icon(
                                imageVector = if (prophet.isBookmarked) Icons.Default.Bookmark else Icons.Outlined.BookmarkBorder,
                                contentDescription = "Bookmark",
                                tint = if (prophet.isBookmarked) palette.accent else palette.textSecondary
                            )
                        }

                        IconButton(onClick = onEditProphet) {
                            Icon(
                                imageVector = Icons.Default.Edit,
                                contentDescription = "Edit Prophet",
                                tint = palette.textSecondary
                            )
                        }
                    }
                }
            }

            // Prophet Chapter Header Card
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 4.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = palette.surface),
                    border = BorderStroke(1.dp, palette.border)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        // Changeable Photo / Emblem
                        Box(
                            modifier = Modifier
                                .size(96.dp)
                                .clip(CircleShape)
                                .background(palette.accent.copy(alpha = 0.15f))
                                .clickable {
                                    photoPickerLauncher.launch(
                                        PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                                    )
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            val photoModel: Any = when {
                                prophet.photoUrlOrRes.startsWith("content://") ||
                                prophet.photoUrlOrRes.startsWith("http") ||
                                prophet.photoUrlOrRes.startsWith("file://") -> prophet.photoUrlOrRes
                                prophet.photoUrlOrRes == "img_book_banner" -> R.drawable.img_book_banner
                                else -> R.drawable.img_app_icon
                            }

                            AsyncImage(
                                model = ImageRequest.Builder(context)
                                    .data(photoModel)
                                    .crossfade(true)
                                    .build(),
                                placeholder = painterResource(R.drawable.img_app_icon),
                                error = painterResource(R.drawable.img_app_icon),
                                contentDescription = prophet.nameRoman,
                                modifier = Modifier
                                    .size(90.dp)
                                    .clip(CircleShape),
                                contentScale = ContentScale.Crop
                            )
                        }

                        Spacer(modifier = Modifier.height(4.dp))
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.clickable {
                                photoPickerLauncher.launch(
                                    PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                                )
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.AddPhotoAlternate,
                                contentDescription = null,
                                tint = palette.accent,
                                modifier = Modifier.size(14.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = "Photo Badlein (Tap to change)",
                                style = MaterialTheme.typography.labelSmall,
                                color = palette.accent
                            )
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        // Arabic Calligraphy Name
                        Text(
                            text = prophet.nameArabic,
                            style = MaterialTheme.typography.headlineMedium.copy(fontFamily = fontFamily),
                            fontWeight = FontWeight.Bold,
                            color = palette.accent,
                            fontSize = 28.sp,
                            textAlign = TextAlign.Center
                        )

                        // Roman Name
                        Text(
                            text = prophet.nameRoman,
                            style = MaterialTheme.typography.titleMedium.copy(fontFamily = fontFamily),
                            fontWeight = FontWeight.Bold,
                            color = palette.textPrimary,
                            textAlign = TextAlign.Center
                        )

                        // Title / Laqab
                        if (localizedTitle.isNotBlank()) {
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(
                                text = "“$localizedTitle”",
                                style = MaterialTheme.typography.bodyMedium,
                                color = palette.accent,
                                fontWeight = FontWeight.SemiBold
                            )
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        // Full Bio & Family Details Table
                        Surface(
                            shape = RoundedCornerShape(12.dp),
                            color = palette.border.copy(alpha = 0.3f),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(modifier = Modifier.padding(14.dp)) {
                                DetailRow("⏳ $ageLabel:", prophet.ageYears, palette)
                                Divider(color = palette.border.copy(alpha = 0.5f), thickness = 0.5.dp, modifier = Modifier.padding(vertical = 4.dp))
                                DetailRow("📍 $eraLabel:", prophet.eraLocation, palette)
                                Divider(color = palette.border.copy(alpha = 0.5f), thickness = 0.5.dp, modifier = Modifier.padding(vertical = 4.dp))
                                DetailRow("👨 $fatherLabel:", prophet.fatherName, palette)
                                Divider(color = palette.border.copy(alpha = 0.5f), thickness = 0.5.dp, modifier = Modifier.padding(vertical = 4.dp))
                                DetailRow("👩 $motherLabel:", prophet.motherName, palette)
                                Divider(color = palette.border.copy(alpha = 0.5f), thickness = 0.5.dp, modifier = Modifier.padding(vertical = 4.dp))
                                DetailRow("🤝 $siblingsLabel:", prophet.siblings, palette)
                                Divider(color = palette.border.copy(alpha = 0.5f), thickness = 0.5.dp, modifier = Modifier.padding(vertical = 4.dp))
                                DetailRow("👶 $childrenLabel:", prophet.children, palette)
                                if (prophet.wives.isNotBlank()) {
                                    Divider(color = palette.border.copy(alpha = 0.5f), thickness = 0.5.dp, modifier = Modifier.padding(vertical = 4.dp))
                                    DetailRow("💍 $wivesLabel:", prophet.wives, palette)
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        // Quick Summary Section (Requested)
                        Surface(
                            shape = RoundedCornerShape(12.dp),
                            color = palette.accent.copy(alpha = 0.1f),
                            border = BorderStroke(1.dp, palette.accent.copy(alpha = 0.3f)),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(modifier = Modifier.padding(14.dp)) {
                                Text(
                                    text = "📖 $summaryTitle",
                                    style = MaterialTheme.typography.labelMedium,
                                    fontWeight = FontWeight.Bold,
                                    color = palette.accent,
                                    letterSpacing = 1.sp
                                )
                                Spacer(modifier = Modifier.height(6.dp))
                                Text(
                                    text = prophet.summaryHighlights,
                                    style = MaterialTheme.typography.bodyMedium.copy(fontFamily = fontFamily),
                                    color = palette.textPrimary,
                                    lineHeight = 22.sp
                                )
                            }
                        }
                    }
                }
            }

            // Events Timeline Header
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = keyEventsTitle,
                            style = MaterialTheme.typography.titleMedium.copy(fontFamily = fontFamily),
                            fontWeight = FontWeight.Bold,
                            color = palette.textPrimary
                        )
                        Text(
                            text = "${events.size} azeem waqiat kitab me shamil",
                            style = MaterialTheme.typography.bodySmall,
                            color = palette.textSecondary
                        )
                    }

                    Button(
                        onClick = onAddEvent,
                        colors = ButtonDefaults.buttonColors(containerColor = palette.accent),
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier.testTag("add_event_button")
                    ) {
                        Icon(imageVector = Icons.Default.Add, contentDescription = null, modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("Naya Waqia", fontSize = 12.sp)
                    }
                }
            }

            // List of Events
            if (events.isEmpty()) {
                item {
                    Text(
                        text = "Is Nabi ke waqiat abhi darj nahi hain. 'Naya Waqia' dabakar jodein.",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(24.dp),
                        style = MaterialTheme.typography.bodyMedium,
                        color = palette.textSecondary,
                        textAlign = TextAlign.Center
                    )
                }
            } else {
                items(events, key = { it.id }) { event ->
                    EventItemView(
                        event = event,
                        onEdit = { onEditEvent(event) },
                        onDelete = { onDeleteEvent(event) },
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun DetailRow(label: String, value: String, palette: com.example.ui.theme.BookPalette) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall,
            fontWeight = FontWeight.SemiBold,
            color = palette.textPrimary,
            modifier = Modifier.weight(0.45f)
        )
        Text(
            text = value.ifBlank { "—" },
            style = MaterialTheme.typography.bodySmall,
            color = palette.textSecondary,
            modifier = Modifier.weight(0.55f),
            textAlign = TextAlign.End
        )
    }
}
