package com.example.ui.components

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.R
import com.example.data.ProphetEntity
import com.example.ui.theme.LocalBookFont
import com.example.ui.theme.LocalBookPalette

@Composable
fun ProphetCard(
    prophet: ProphetEntity,
    onClick: () -> Unit,
    onToggleBookmark: () -> Unit,
    onEdit: () -> Unit,
    language: com.example.data.AppLanguage = com.example.data.AppLanguage.HINDI,
    modifier: Modifier = Modifier
) {
    val palette = LocalBookPalette.current
    val fontFamily = LocalBookFont.current
    val context = LocalContext.current

    val ageLabel = com.example.util.AppLocaleManager.getUiString("age", language)
    val fatherLabel = com.example.util.AppLocaleManager.getUiString("father", language)
    val motherLabel = com.example.util.AppLocaleManager.getUiString("mother", language)
    val localizedTitle = com.example.util.AppLocaleManager.getLocalizedProphetTitle(prophet.title, language)

    Card(
        modifier = modifier
            .fillMaxWidth()
            .testTag("prophet_card_${prophet.id}")
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = palette.surface
        ),
        border = BorderStroke(1.dp, palette.border),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Header Row: Order Number Badge + Arabic Name + Bookmark Button
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = palette.accent.copy(alpha = 0.15f),
                    border = BorderStroke(1.dp, palette.accent.copy(alpha = 0.3f))
                ) {
                    Text(
                        text = "#${prophet.orderIndex}",
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp),
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold,
                        color = palette.accent
                    )
                }

                Text(
                    text = prophet.nameArabic,
                    style = MaterialTheme.typography.titleLarge.copy(fontFamily = fontFamily),
                    fontWeight = FontWeight.Bold,
                    color = palette.accent,
                    fontSize = 22.sp
                )

                Row {
                    IconButton(
                        onClick = onEdit,
                        modifier = Modifier
                            .size(36.dp)
                            .testTag("edit_prophet_${prophet.id}")
                    ) {
                        Icon(
                            imageVector = Icons.Default.Edit,
                            contentDescription = "Edit Prophet",
                            tint = palette.textSecondary,
                            modifier = Modifier.size(18.dp)
                        )
                    }

                    IconButton(
                        onClick = onToggleBookmark,
                        modifier = Modifier
                            .size(36.dp)
                            .testTag("bookmark_prophet_${prophet.id}")
                    ) {
                        Icon(
                            imageVector = if (prophet.isBookmarked) Icons.Default.Bookmark else Icons.Outlined.BookmarkBorder,
                            contentDescription = "Bookmark",
                            tint = if (prophet.isBookmarked) palette.accent else palette.textSecondary,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Body Row: Photo / Emblem + Roman Name + Title + Quick Highlights
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Top
            ) {
                // Photo / Emblem
                Box(
                    modifier = Modifier
                        .size(56.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(palette.accent.copy(alpha = 0.1f))
                        .padding(2.dp),
                    contentAlignment = Alignment.Center
                ) {
                    val photoModel: Any = when {
                        prophet.photoUrlOrRes.startsWith("content://") || prophet.photoUrlOrRes.startsWith("http") || prophet.photoUrlOrRes.startsWith("file://") ->
                            prophet.photoUrlOrRes
                        prophet.photoUrlOrRes == "img_book_banner" ->
                            R.drawable.img_book_banner
                        else ->
                            R.drawable.img_app_icon
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
                            .size(52.dp)
                            .clip(RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Crop
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = prophet.nameRoman,
                        style = MaterialTheme.typography.titleMedium.copy(fontFamily = fontFamily),
                        fontWeight = FontWeight.Bold,
                        color = palette.textPrimary,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )

                    Text(
                        text = localizedTitle,
                        style = MaterialTheme.typography.bodySmall,
                        color = palette.accent,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = prophet.summaryHighlights,
                        style = MaterialTheme.typography.bodySmall.copy(fontFamily = fontFamily),
                        color = palette.textSecondary,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        lineHeight = 18.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Bio Details Chips (Umar, Walid, Walida, Bhai-Bahen)
            Surface(
                shape = RoundedCornerShape(8.dp),
                color = palette.border.copy(alpha = 0.35f),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "⏳ $ageLabel: ${prophet.ageYears}",
                            style = MaterialTheme.typography.labelSmall,
                            color = palette.textPrimary,
                            fontWeight = FontWeight.Medium,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier.weight(1f)
                        )
                        Text(
                            text = "📍 ${prophet.eraLocation}",
                            style = MaterialTheme.typography.labelSmall,
                            color = palette.textSecondary,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier.weight(1f)
                        )
                    }

                    Spacer(modifier = Modifier.height(2.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "👨 $fatherLabel: ${prophet.fatherName}",
                            style = MaterialTheme.typography.labelSmall,
                            color = palette.textSecondary,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier.weight(1f)
                        )
                        Text(
                            text = "👩 $motherLabel: ${prophet.motherName}",
                            style = MaterialTheme.typography.labelSmall,
                            color = palette.textSecondary,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            }
        }
    }
}
