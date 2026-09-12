package com.example.ui.screens

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.LocalBookFont
import com.example.ui.theme.LocalBookPalette
import kotlinx.coroutines.delay

@Composable
fun LoadingSplashScreen(
    onLoadingComplete: () -> Unit,
    modifier: Modifier = Modifier
) {
    val palette = LocalBookPalette.current
    val fontFamily = LocalBookFont.current

    LaunchedEffect(Unit) {
        delay(1800L)
        onLoadingComplete()
    }

    val infiniteTransition = rememberInfiniteTransition(label = "pulse_splash")
    val scale by infiniteTransition.animateFloat(
        initialValue = 0.95f,
        targetValue = 1.05f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = EaseInOutQuad),
            repeatMode = RepeatMode.Reverse
        ),
        label = "pulse_scale"
    )
    val alphaAnim by infiniteTransition.animateFloat(
        initialValue = 0.6f,
        targetValue = 1.0f,
        animationSpec = infiniteRepeatable(
            animation = tween(800, easing = EaseInOutQuad),
            repeatMode = RepeatMode.Reverse
        ),
        label = "pulse_alpha"
    )

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(palette.background),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(24.dp)
        ) {
            // Emblem with scale animation
            Box(
                modifier = Modifier
                    .size(96.dp)
                    .scale(scale)
                    .clip(CircleShape)
                    .background(palette.accent.copy(alpha = 0.15f)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "﷽",
                    fontSize = 38.sp,
                    color = palette.accent,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // App Name (Prominently displayed)
            Text(
                text = "Qisas Anbiya",
                style = MaterialTheme.typography.headlineLarge.copy(fontFamily = fontFamily),
                fontWeight = FontWeight.ExtraBold,
                color = palette.textPrimary,
                textAlign = TextAlign.Center
            )

            Text(
                text = "قصص الأنبياء عليهم السلام",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = palette.accent,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(10.dp))

            // USER EXPLICIT REQUEST: "create by Gufran Khan"
            Surface(
                shape = CircleShape,
                color = palette.accent.copy(alpha = 0.12f),
                modifier = Modifier.padding(vertical = 4.dp)
            ) {
                Text(
                    text = "create by Gufran Khan",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = palette.accent,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp),
                    textAlign = TextAlign.Center
                )
            }

            Spacer(modifier = Modifier.height(36.dp))

            // Loading indicator
            CircularProgressIndicator(
                color = palette.accent,
                strokeWidth = 3.dp,
                modifier = Modifier
                    .size(36.dp)
                    .alpha(alphaAnim)
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "تلاوت، تاریخ و برکات کا سفر شروع ہو رہا ہے...",
                style = MaterialTheme.typography.bodySmall,
                color = palette.textSecondary,
                textAlign = TextAlign.Center
            )
        }
    }
}
