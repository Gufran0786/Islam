package com.example.ui.components

import androidx.compose.animation.AnimatedVisibility
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DeleteOutline
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.R
import com.example.data.ProphetEventEntity
import com.example.ui.theme.LocalBookFont
import com.example.ui.theme.LocalBookPalette

@Composable
fun EventItemView(
    event: ProphetEventEntity,
    onEdit: () -> Unit,
    onDelete: () -> Unit,
    modifier: Modifier = Modifier
) {
    val palette = LocalBookPalette.current
    val fontFamily = LocalBookFont.current
    val context = LocalContext.current
    var isExpanded by remember { mutableStateOf(true) }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .testTag("event_item_${event.id}"),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = palette.surface
        ),
        border = BorderStroke(1.dp, palette.border),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            // Title Header & Actions
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    modifier = Modifier.weight(1f),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.MenuBook,
                        contentDescription = null,
                        tint = palette.accent,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = event.title,
                        style = MaterialTheme.typography.titleMedium.copy(fontFamily = fontFamily),
                        fontWeight = FontWeight.Bold,
                        color = palette.textPrimary
                    )
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(
                        onClick = onEdit,
                        modifier = Modifier
                            .size(36.dp)
                            .testTag("edit_event_${event.id}")
                    ) {
                        Icon(
                            imageVector = Icons.Default.Edit,
                            contentDescription = "Edit Event",
                            tint = palette.textSecondary,
                            modifier = Modifier.size(18.dp)
                        )
                    }

                    IconButton(
                        onClick = onDelete,
                        modifier = Modifier
                            .size(36.dp)
                            .testTag("delete_event_${event.id}")
                    ) {
                        Icon(
                            imageVector = Icons.Default.DeleteOutline,
                            contentDescription = "Delete Event",
                            tint = MaterialTheme.colorScheme.error,
                            modifier = Modifier.size(18.dp)
                        )
                    }

                    IconButton(
                        onClick = { isExpanded = !isExpanded },
                        modifier = Modifier.size(36.dp)
                    ) {
                        Icon(
                            imageVector = if (isExpanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                            contentDescription = "Toggle Expand",
                            tint = palette.textSecondary
                        )
                    }
                }
            }

            // Quick Highlights / Summary Box (Requested feature)
            Spacer(modifier = Modifier.height(10.dp))
            Surface(
                shape = RoundedCornerShape(8.dp),
                color = palette.accent.copy(alpha = 0.1f),
                border = BorderStroke(1.dp, palette.accent.copy(alpha = 0.25f)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Lightbulb,
                            contentDescription = null,
                            tint = palette.accent,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "QUICK HIGHLIGHT / KHULASA",
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold,
                            color = palette.accent,
                            letterSpacing = 1.sp
                        )
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = event.summary,
                        style = MaterialTheme.typography.bodyMedium.copy(fontFamily = fontFamily),
                        color = palette.textPrimary,
                        lineHeight = 20.sp
                    )
                }
            }

            AnimatedVisibility(visible = isExpanded) {
                Column {
                    // Event Photo / Illustration (Changeable)
                    Spacer(modifier = Modifier.height(12.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(180.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(palette.border.copy(alpha = 0.2f))
                    ) {
                        val photoModel: Any = when {
                            event.eventPhotoUrlOrRes.startsWith("content://") ||
                            event.eventPhotoUrlOrRes.startsWith("http") ||
                            event.eventPhotoUrlOrRes.startsWith("file://") ->
                                event.eventPhotoUrlOrRes
                            event.eventPhotoUrlOrRes == "img_app_icon" ->
                                R.drawable.img_app_icon
                            else ->
                                R.drawable.img_book_banner
                        }

                        AsyncImage(
                            model = ImageRequest.Builder(context)
                                .data(photoModel)
                                .crossfade(true)
                                .build(),
                            placeholder = painterResource(R.drawable.img_book_banner),
                            error = painterResource(R.drawable.img_book_banner),
                            contentDescription = event.title,
                            modifier = Modifier.matchParentSize(),
                            contentScale = ContentScale.Crop
                        )

                        Surface(
                            shape = RoundedCornerShape(topStart = 8.dp),
                            color = palette.surface.copy(alpha = 0.85f),
                            modifier = Modifier
                                .align(Alignment.BottomEnd)
                                .clickable(onClick = onEdit)
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Edit,
                                    contentDescription = null,
                                    tint = palette.accent,
                                    modifier = Modifier.size(14.dp)
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = "Change Photo",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = palette.textPrimary
                                )
                            }
                        }
                    }

                    // Detailed Narrative (Book text)
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = event.detailedNarrative,
                        style = MaterialTheme.typography.bodyLarge.copy(fontFamily = fontFamily),
                        color = palette.textPrimary,
                        lineHeight = 24.sp
                    )

                    // Quranic Reference & Moral Lesson
                    Spacer(modifier = Modifier.height(12.dp))
                    if (event.quranicReference.isNotBlank()) {
                        Text(
                            text = "📖 Hawala: ${event.quranicReference}",
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = FontWeight.SemiBold,
                            color = palette.accent
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                    }

                    if (event.moralLesson.isNotBlank()) {
                        Surface(
                            shape = RoundedCornerShape(6.dp),
                            color = palette.border.copy(alpha = 0.3f),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "✨ Sabaq (Lesson): ${event.moralLesson}",
                                modifier = Modifier.padding(8.dp),
                                style = MaterialTheme.typography.bodySmall.copy(fontFamily = fontFamily),
                                color = palette.textSecondary
                            )
                        }
                    }
                }
            }
        }
    }
}
