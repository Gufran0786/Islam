package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.AccountTree
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.ProphetEntity
import com.example.data.ProphetFamilyTreeData
import com.example.data.ProphetTreeNode
import com.example.ui.theme.LocalBookPalette

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProphetFamilyTreeScreen(
    prophets: List<ProphetEntity>,
    onSelectProphet: (ProphetEntity) -> Unit,
    modifier: Modifier = Modifier
) {
    val palette = LocalBookPalette.current
    var selectedBranch by remember { mutableStateOf("All") }
    var searchQuery by remember { mutableStateOf("") }

    val branches = listOf(
        "All" to "تمام انبیاء (All Prophets)",
        "Awwaleen" to "اوّلین (Adam تا Nuh)",
        "Bani Ismail" to "بنی اسماعیل (سلسلۂ مصطفیٰ ﷺ)",
        "Bani Israel" to "بنی اسرائیل (اسحاق تا عیسیٰ)",
        "Arab-e-Baidah" to "عربِ بائدہ (ہود، صالح، شعیب)"
    )

    val filteredNodes = remember(selectedBranch, searchQuery) {
        ProphetFamilyTreeData.nodes.filter { node ->
            val matchesBranch = when (selectedBranch) {
                "Awwaleen" -> node.branch.contains("Awwaleen", ignoreCase = true)
                "Bani Ismail" -> node.branch.contains("Bani Ismail", ignoreCase = true) || node.id == "ibrahim" || node.id == "ismail" || node.id == "muhammad"
                "Bani Israel" -> node.branch.contains("Bani Israel", ignoreCase = true) || node.id == "ibrahim" || node.id == "ishaq"
                "Arab-e-Baidah" -> node.branch.contains("Arab-e-Baidah", ignoreCase = true) || node.id == "hud" || node.id == "saleh" || node.id == "shuaib"
                else -> true
            }

            val matchesSearch = if (searchQuery.isBlank()) true else {
                val q = searchQuery.trim().lowercase()
                node.nameRoman.lowercase().contains(q) ||
                        node.nameArabic.contains(q) ||
                        node.nameHindi.lowercase().contains(q) ||
                        node.nameUrdu.contains(q) ||
                        node.fatherName.lowercase().contains(q) ||
                        node.lineageChain.lowercase().contains(q)
            }

            matchesBranch && matchesSearch
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = "شجرۂ نسبِ انبیاء کرام",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            color = palette.textPrimary
                        )
                        Text(
                            text = "Prophets Family Tree • आदम (अ.स.) से रसूलुल्लाह (सल्ल.) तक",
                            style = MaterialTheme.typography.bodySmall,
                            color = palette.textSecondary
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = palette.surface
                )
            )
        },
        modifier = modifier
    ) { innerPadding ->
        LazyColumn(
            contentPadding = PaddingValues(
                start = 16.dp,
                end = 16.dp,
                top = innerPadding.calculateTopPadding() + 8.dp,
                bottom = innerPadding.calculateBottomPadding() + 80.dp
            ),
            verticalArrangement = Arrangement.spacedBy(14.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            // Header Info Banner
            item {
                Card(
                    colors = CardDefaults.cardColors(containerColor = palette.cardBackground),
                    shape = RoundedCornerShape(16.dp),
                    border = CardDefaults.outlinedCardBorder().copy(brush = androidx.compose.ui.graphics.SolidColor(palette.border)),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(48.dp)
                                .clip(CircleShape)
                                .background(palette.accent.copy(alpha = 0.15f)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.AccountTree,
                                contentDescription = null,
                                tint = palette.accent,
                                modifier = Modifier.size(28.dp)
                            )
                        }
                        Spacer(modifier = Modifier.width(14.dp))
                        Column {
                            Text(
                                text = "مقدس خاندانی سلسلہ (Sacred Lineage)",
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.Bold,
                                color = palette.accent
                            )
                            Text(
                                text = "تمام انبیاء کرام کا نسبی تعلق، باپ، بیٹے اور نسلوں کا مستند تاریخی ریکارڈ۔",
                                style = MaterialTheme.typography.bodySmall,
                                color = palette.textSecondary
                            )
                        }
                    }
                }
            }

            // Search in Family Tree
            item {
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    placeholder = {
                        Text("نام، والد یا نسب تلاش کریں (Search Prophet / Lineage)...", style = MaterialTheme.typography.bodySmall)
                    },
                    leadingIcon = {
                        Icon(Icons.Default.Search, contentDescription = "Search", tint = palette.accent)
                    },
                    trailingIcon = {
                        if (searchQuery.isNotEmpty()) {
                            IconButton(onClick = { searchQuery = "" }) {
                                Icon(Icons.Default.Close, contentDescription = "Clear", tint = palette.textSecondary)
                            }
                        }
                    },
                    shape = RoundedCornerShape(14.dp),
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth().testTag("tree_search_bar")
                )
            }

            // Filter Chips
            item {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(branches) { (branchKey, label) ->
                        FilterChip(
                            selected = selectedBranch == branchKey,
                            onClick = { selectedBranch = branchKey },
                            label = { Text(label, style = MaterialTheme.typography.labelSmall) },
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = palette.accent,
                                selectedLabelColor = Color.White,
                                containerColor = palette.surface,
                                labelColor = palette.textPrimary
                            )
                        )
                    }
                }
            }

            // Tree Nodes Count
            item {
                Text(
                    text = "مظاہرہ: ${filteredNodes.size} انبیاء کے شجرۂ نسب",
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.Bold,
                    color = palette.accent
                )
            }

            // Tree Items
            items(filteredNodes, key = { it.id }) { node ->
                ProphetTreeNodeCard(
                    node = node,
                    onClickProfile = {
                        val matching = prophets.find { it.orderIndex == node.orderIndex }
                            ?: prophets.find { it.nameRoman.contains(node.nameRoman.split(" ").getOrNull(1) ?: "", ignoreCase = true) }
                        if (matching != null) {
                            onSelectProphet(matching)
                        }
                    }
                )
            }
        }
    }
}

@Composable
private fun ProphetTreeNodeCard(
    node: ProphetTreeNode,
    onClickProfile: () -> Unit,
    modifier: Modifier = Modifier
) {
    val palette = LocalBookPalette.current

    Card(
        colors = CardDefaults.cardColors(containerColor = palette.cardBackground),
        shape = RoundedCornerShape(16.dp),
        border = CardDefaults.outlinedCardBorder().copy(
            brush = androidx.compose.ui.graphics.SolidColor(palette.border)
        ),
        modifier = modifier
            .fillMaxWidth()
            .testTag("tree_node_${node.id}")
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            // Top Row: Generation Badge and Branch
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = palette.accent.copy(alpha = 0.15f)
                ) {
                    Text(
                        text = "نسل (Gen) #${node.generationLevel} • ترتیب #${node.orderIndex}",
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold,
                        color = palette.accent,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                }

                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = palette.surface
                ) {
                    Text(
                        text = node.branch,
                        style = MaterialTheme.typography.labelSmall,
                        color = palette.textSecondary,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Prophet Names & Calligraphy
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = node.nameRoman,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = palette.textPrimary
                    )
                    Text(
                        text = "${node.nameHindi} • ${node.nameUrdu}",
                        style = MaterialTheme.typography.bodySmall,
                        color = palette.textSecondary
                    )
                    Text(
                        text = node.title,
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.SemiBold,
                        color = palette.accent
                    )
                }

                Text(
                    text = node.nameArabic,
                    style = MaterialTheme.typography.titleMedium.copy(fontSize = 18.sp),
                    fontWeight = FontWeight.Bold,
                    color = palette.accent,
                    textAlign = TextAlign.End
                )
            }

            Spacer(modifier = Modifier.height(12.dp))
            Divider(color = palette.border.copy(alpha = 0.5f), thickness = 0.5.dp)
            Spacer(modifier = Modifier.height(10.dp))

            // Family Relations Breakdown
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "👨 والد (Father):",
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold,
                        color = palette.textSecondary
                    )
                    Text(
                        text = node.fatherName,
                        style = MaterialTheme.typography.bodySmall,
                        color = palette.textPrimary
                    )
                }
                Spacer(modifier = Modifier.width(12.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "👩 والدہ (Mother):",
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold,
                        color = palette.textSecondary
                    )
                    Text(
                        text = node.motherName,
                        style = MaterialTheme.typography.bodySmall,
                        color = palette.textPrimary
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Era / Location
            Text(
                text = "📍 مقام و خطّہ:",
                style = MaterialTheme.typography.labelSmall,
                fontWeight = FontWeight.Bold,
                color = palette.textSecondary
            )
            Text(
                text = node.eraLocation,
                style = MaterialTheme.typography.bodySmall,
                color = palette.textPrimary
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Lineage Chain (سلسلۂ نسب)
            Surface(
                shape = RoundedCornerShape(10.dp),
                color = palette.surface,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(10.dp)) {
                    Text(
                        text = "📜 سلسلۂ نسب (Lineage Chain):",
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold,
                        color = palette.accent
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = node.lineageChain,
                        style = MaterialTheme.typography.bodySmall,
                        color = palette.textPrimary
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = node.relationDescription,
                        style = MaterialTheme.typography.labelSmall,
                        color = palette.textSecondary
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // View Profile Button
            Button(
                onClick = onClickProfile,
                colors = ButtonDefaults.buttonColors(containerColor = palette.accent),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.fillMaxWidth().testTag("btn_view_profile_${node.id}")
            ) {
                Icon(
                    imageVector = Icons.Default.MenuBook,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "مکمل سوانح و حیات دیکھیں (View Full Profile)",
                    color = Color.White,
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}
