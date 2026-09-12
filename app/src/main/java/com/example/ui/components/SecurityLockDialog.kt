package com.example.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Backspace
import androidx.compose.material.icons.filled.Fingerprint
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.LocalBookPalette

@Composable
fun SecurityLockScreen(
    actualPin: String,
    onSuccessUnlock: () -> Unit,
    onBiometricClick: () -> Unit
) {
    val palette = LocalBookPalette.current
    var enteredPin by remember { mutableStateOf("") }
    var isError by remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .testTag("security_lock_screen"),
        color = palette.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Lock Icon
            Box(
                modifier = Modifier
                    .size(72.dp)
                    .clip(CircleShape)
                    .background(palette.accent.copy(alpha = 0.15f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = null,
                    tint = palette.accent,
                    modifier = Modifier.size(36.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Hifazati Passcode (App Lock)",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = palette.textPrimary
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "Apni personal diary aur mutala ko mehfooz rakhne ke liye 4-hanso ka PIN darj karein",
                style = MaterialTheme.typography.bodySmall,
                color = palette.textSecondary,
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )

            Spacer(modifier = Modifier.height(24.dp))

            // PIN Dot Indicators
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                for (i in 0 until 4) {
                    val isFilled = i < enteredPin.length
                    Box(
                        modifier = Modifier
                            .size(16.dp)
                            .clip(CircleShape)
                            .background(
                                if (isError) MaterialTheme.colorScheme.error
                                else if (isFilled) palette.accent
                                else palette.border
                            )
                    )
                }
            }

            if (isError) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Ghalat PIN. Dubaara koshish karein.",
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.labelSmall
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Numeric Keypad (1 to 9, Biometric, 0, Backspace)
            val rows = listOf(
                listOf("1", "2", "3"),
                listOf("4", "5", "6"),
                listOf("7", "8", "9"),
                listOf("BIO", "0", "DEL")
            )

            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                for (row in rows) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        for (key in row) {
                            when (key) {
                                "BIO" -> {
                                    KeypadCircle(
                                        onClick = onBiometricClick,
                                        palette = palette
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Fingerprint,
                                            contentDescription = "Biometric",
                                            tint = palette.accent,
                                            modifier = Modifier.size(28.dp)
                                        )
                                    }
                                }
                                "DEL" -> {
                                    KeypadCircle(
                                        onClick = {
                                            if (enteredPin.isNotEmpty()) {
                                                enteredPin = enteredPin.dropLast(1)
                                                isError = false
                                            }
                                        },
                                        palette = palette
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Backspace,
                                            contentDescription = "Backspace",
                                            tint = palette.textSecondary,
                                            modifier = Modifier.size(24.dp)
                                        )
                                    }
                                }
                                else -> {
                                    KeypadCircle(
                                        onClick = {
                                            if (enteredPin.length < 4) {
                                                val newPin = enteredPin + key
                                                enteredPin = newPin
                                                isError = false
                                                if (newPin.length == 4) {
                                                    if (newPin == actualPin) {
                                                        onSuccessUnlock()
                                                    } else {
                                                        isError = true
                                                        enteredPin = ""
                                                    }
                                                }
                                            }
                                        },
                                        palette = palette
                                    ) {
                                        Text(
                                            text = key,
                                            style = MaterialTheme.typography.titleLarge,
                                            fontWeight = FontWeight.Bold,
                                            color = palette.textPrimary
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun KeypadCircle(
    onClick: () -> Unit,
    palette: com.example.ui.theme.BookPalette,
    content: @Composable () -> Unit
) {
    Card(
        modifier = Modifier
            .size(64.dp)
            .clickable(onClick = onClick),
        shape = CircleShape,
        colors = CardDefaults.cardColors(containerColor = palette.surface),
        border = BorderStroke(1.dp, palette.border)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            content()
        }
    }
}
