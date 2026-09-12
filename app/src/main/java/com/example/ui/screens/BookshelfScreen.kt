package com.example.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AutoStories
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Palette
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.data.ProphetEntity
import com.example.ui.components.ProphetCard
import com.example.ui.theme.LocalBookFont
import com.example.ui.theme.LocalBookPalette

@Composable
fun BookshelfScreen(
    prophets: List<ProphetEntity>,
    searchQuery: String,
    bookmarksOnly: Boolean,
    language: com.example.data.AppLanguage = com.example.data.AppLanguage.HINDI,
    onOpenCalendarDialog: () -> Unit = {},
    onSearchChange: (String) -> Unit,
    onToggleBookmarkFilter: () -> Unit,
    onProphetClick: (ProphetEntity) -> Unit,
    onToggleBookmark: (ProphetEntity) -> Unit,
    onEditProphet: (ProphetEntity) -> Unit,
    onAddProphet: () -> Unit,
    onOpenAppearanceSheet: () -> Unit,
    onOpenSettings: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    val palette = LocalBookPalette.current
    val fontFamily = LocalBookFont.current

    val searchHint = com.example.util.AppLocaleManager.getUiString("search_prophet_hint", language)
    val appTitle = com.example.util.AppLocaleManager.getUiString("app_title", language)
    val appSubtitle = com.example.util.AppLocaleManager.getUiString("app_subtitle", language)
    val bookmarksOnlyLabel = com.example.util.AppLocaleManager.getUiString("bookmarks_only", language)

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(palette.background)
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(bottom = 96.dp)
        ) {
            // Book Hero Banner
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 12.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = palette.surface),
                    border = BorderStroke(1.dp, palette.border)
                ) {
                    Box(modifier = Modifier.fillMaxWidth().height(140.dp)) {
                        Image(
                            painter = painterResource(R.drawable.img_book_banner),
                            contentDescription = "Qisas Banner",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                        // Gradient Overlay for Readability
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(palette.surface.copy(alpha = 0.82f))
                        )
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp),
                            verticalArrangement = Arrangement.Center
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column(modifier = Modifier.weight(1f)) {
                                    Text(
                                        text = "قصص الأنبياء عليهم السلام",
                                        style = MaterialTheme.typography.titleMedium.copy(fontFamily = fontFamily),
                                        fontWeight = FontWeight.Bold,
                                        color = palette.accent,
                                        fontSize = 20.sp
                                    )
                                    Spacer(modifier = Modifier.height(2.dp))
                                    Text(
                                        text = "Qisas Anbiya (Stories of Prophets)",
                                        style = MaterialTheme.typography.titleSmall,
                                        fontWeight = FontWeight.SemiBold,
                                        color = palette.textPrimary
                                    )
                                    Text(
                                        text = "Naam, Umar, Walidain, Bhai-Bahen & Mukhya Waqiat",
                                        style = MaterialTheme.typography.bodySmall,
                                        color = palette.textSecondary,
                                        fontSize = 11.sp
                                    )
                                }

                                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                    Surface(
                                        shape = CircleShape,
                                        color = palette.accent.copy(alpha = 0.15f),
                                        border = BorderStroke(1.dp, palette.accent),
                                        modifier = Modifier
                                            .size(40.dp)
                                            .clickable(onClick = onOpenAppearanceSheet)
                                            .testTag("open_appearance_btn")
                                    ) {
                                        Box(contentAlignment = Alignment.Center) {
                                            Icon(
                                                imageVector = Icons.Default.Palette,
                                                contentDescription = "Paper & Font Styles",
                                                tint = palette.accent,
                                                modifier = Modifier.size(20.dp)
                                            )
                                        }
                                    }

                                    Surface(
                                        shape = CircleShape,
                                        color = palette.surface,
                                        border = BorderStroke(1.dp, palette.border),
                                        modifier = Modifier
                                            .size(40.dp)
                                            .clickable(onClick = onOpenSettings)
                                            .testTag("open_settings_btn")
                                    ) {
                                        Box(contentAlignment = Alignment.Center) {
                                            Icon(
                                                imageVector = Icons.Default.Settings,
                                                contentDescription = "Settings",
                                                tint = palette.accent,
                                                modifier = Modifier.size(20.dp)
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            // Real-Time Tri-Calendar Live Widget (Hijri, Hindi, English & Live Seconds)
            item {
                com.example.ui.calendar.LiveTriCalendarCard(
                    onOpenFullCalendar = onOpenCalendarDialog,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)
                )
            }

            // Search Bar (Real-time filter for old & new records)
            item {
                Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                    OutlinedTextField(
                        value = searchQuery,
                        onValueChange = onSearchChange,
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("search_prophets_bar"),
                        placeholder = {
                            Text(
                                searchHint,
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
                                        contentDescription = "Clear search",
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

                    // Filter Chips Row: All vs Bookmarks
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Surface(
                            shape = RoundedCornerShape(20.dp),
                            color = if (!bookmarksOnly) palette.accent else palette.surface,
                            border = BorderStroke(1.dp, if (!bookmarksOnly) palette.accent else palette.border),
                            modifier = Modifier
                                .clickable { if (bookmarksOnly) onToggleBookmarkFilter() }
                                .testTag("filter_all_prophets")
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = Icons.Default.AutoStories,
                                    contentDescription = null,
                                    modifier = Modifier.size(16.dp),
                                    tint = if (!bookmarksOnly) MaterialTheme.colorScheme.onPrimary else palette.textPrimary
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = "Tamam Kitab (${prophets.size})",
                                    style = MaterialTheme.typography.labelMedium,
                                    fontWeight = FontWeight.Medium,
                                    color = if (!bookmarksOnly) MaterialTheme.colorScheme.onPrimary else palette.textPrimary
                                )
                            }
                        }

                        Surface(
                            shape = RoundedCornerShape(20.dp),
                            color = if (bookmarksOnly) palette.accent else palette.surface,
                            border = BorderStroke(1.dp, if (bookmarksOnly) palette.accent else palette.border),
                            modifier = Modifier
                                .clickable { onToggleBookmarkFilter() }
                                .testTag("filter_bookmarks_prophets")
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Bookmark,
                                    contentDescription = null,
                                    modifier = Modifier.size(16.dp),
                                    tint = if (bookmarksOnly) MaterialTheme.colorScheme.onPrimary else palette.accent
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Text(
                                    text = "Nishaniyan (Bookmarks)",
                                    style = MaterialTheme.typography.labelMedium,
                                    fontWeight = FontWeight.Medium,
                                    color = if (bookmarksOnly) MaterialTheme.colorScheme.onPrimary else palette.textPrimary
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                }
            }

            // Empty State
            if (prophets.isEmpty()) {
                item {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(40.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            imageVector = Icons.Default.MenuBook,
                            contentDescription = null,
                            tint = palette.textSecondary,
                            modifier = Modifier.size(48.dp)
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            text = if (bookmarksOnly) "Koi bookmark nahi mila." else "Koi Nabi nahi mila.",
                            style = MaterialTheme.typography.titleSmall,
                            color = palette.textPrimary,
                            fontWeight = FontWeight.SemiBold
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "Search query ko tabdeel karein ya naya record add karein.",
                            style = MaterialTheme.typography.bodySmall,
                            color = palette.textSecondary,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            } else {
                items(prophets, key = { it.id }) { prophet ->
                    ProphetCard(
                        prophet = prophet,
                        onClick = { onProphetClick(prophet) },
                        onToggleBookmark = { onToggleBookmark(prophet) },
                        onEdit = { onEditProphet(prophet) },
                        language = language,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp)
                    )
                }
            }
        }

        // FAB: Add New Prophet
        FloatingActionButton(
            onClick = onAddProphet,
            containerColor = palette.accent,
            contentColor = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = 80.dp, end = 20.dp)
                .testTag("add_prophet_fab")
        ) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "Add Prophet")
        }
    }
}
