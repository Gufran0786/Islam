package com.example.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import com.example.data.BookFont
import com.example.data.PaperStyle

data class BookPalette(
    val background: Color,
    val surface: Color,
    val surfaceVariant: Color,
    val border: Color,
    val textPrimary: Color,
    val textSecondary: Color,
    val accent: Color,
    val isDark: Boolean
) {
    val cardBackground: Color get() = surface
}

val LocalBookPalette = staticCompositionLocalOf {
    BookPalette(
        background = ParchmentBg,
        surface = ParchmentCard,
        surfaceVariant = ParchmentCard,
        border = ParchmentBorder,
        textPrimary = ParchmentTextPrimary,
        textSecondary = ParchmentTextSecondary,
        accent = GoldAccent,
        isDark = false
    )
}

val LocalBookFont = staticCompositionLocalOf<FontFamily> {
    FontFamily.Serif
}

fun getPaletteForPaperStyle(paperStyle: PaperStyle, isForceDark: Boolean): BookPalette {
    if (isForceDark) {
        return BookPalette(
            background = DarkBg,
            surface = DarkCard,
            surfaceVariant = DarkCard,
            border = DarkBorder,
            textPrimary = DarkTextPrimary,
            textSecondary = DarkTextSecondary,
            accent = GoldAccent,
            isDark = true
        )
    }

    return when (paperStyle) {
        PaperStyle.PARCHMENT -> BookPalette(
            background = ParchmentBg,
            surface = ParchmentCard,
            surfaceVariant = ParchmentCard,
            border = ParchmentBorder,
            textPrimary = ParchmentTextPrimary,
            textSecondary = ParchmentTextSecondary,
            accent = AmberWarm,
            isDark = false
        )
        PaperStyle.CREAM -> BookPalette(
            background = CreamBg,
            surface = CreamCard,
            surfaceVariant = CreamCard,
            border = CreamBorder,
            textPrimary = CreamTextPrimary,
            textSecondary = CreamTextSecondary,
            accent = AmberWarm,
            isDark = false
        )
        PaperStyle.WHITE -> BookPalette(
            background = WhiteBg,
            surface = WhiteCard,
            surfaceVariant = WhiteCard,
            border = WhiteBorder,
            textPrimary = WhiteTextPrimary,
            textSecondary = WhiteTextSecondary,
            accent = EmeraldLight,
            isDark = false
        )
        PaperStyle.FOREST -> BookPalette(
            background = ForestBg,
            surface = ForestCard,
            surfaceVariant = ForestCard,
            border = ForestBorder,
            textPrimary = ForestTextPrimary,
            textSecondary = ForestTextSecondary,
            accent = GoldAccent,
            isDark = true
        )
        PaperStyle.DARK -> BookPalette(
            background = DarkBg,
            surface = DarkCard,
            surfaceVariant = DarkCard,
            border = DarkBorder,
            textPrimary = DarkTextPrimary,
            textSecondary = DarkTextSecondary,
            accent = GoldAccent,
            isDark = true
        )
        PaperStyle.AMOLED -> BookPalette(
            background = AmoledBg,
            surface = AmoledCard,
            surfaceVariant = AmoledCard,
            border = AmoledBorder,
            textPrimary = AmoledTextPrimary,
            textSecondary = AmoledTextSecondary,
            accent = GoldAccent,
            isDark = true
        )
    }
}

fun getFontFamily(fontOption: BookFont): FontFamily {
    return when (fontOption) {
        BookFont.SERIF -> FontFamily.Serif
        BookFont.SANS -> FontFamily.SansSerif
        BookFont.MONO -> FontFamily.Monospace
    }
}

@Composable
fun QisasAnbiyaTheme(
    paperStyle: PaperStyle = PaperStyle.PARCHMENT,
    bookFont: BookFont = BookFont.SERIF,
    isDarkMode: Boolean = false,
    content: @Composable () -> Unit
) {
    val palette = getPaletteForPaperStyle(paperStyle, isDarkMode)
    val fontFamily = getFontFamily(bookFont)

    val colorScheme: ColorScheme = if (palette.isDark) {
        darkColorScheme(
            primary = palette.accent,
            onPrimary = Color.Black,
            secondary = EmeraldLight,
            background = palette.background,
            onBackground = palette.textPrimary,
            surface = palette.surface,
            onSurface = palette.textPrimary,
            surfaceVariant = palette.surfaceVariant,
            outline = palette.border
        )
    } else {
        lightColorScheme(
            primary = palette.accent,
            onPrimary = Color.White,
            secondary = EmeraldMedium,
            background = palette.background,
            onBackground = palette.textPrimary,
            surface = palette.surface,
            onSurface = palette.textPrimary,
            surfaceVariant = palette.surfaceVariant,
            outline = palette.border
        )
    }

    CompositionLocalProvider(
        LocalBookPalette provides palette,
        LocalBookFont provides fontFamily
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = Typography,
            content = content
        )
    }
}
