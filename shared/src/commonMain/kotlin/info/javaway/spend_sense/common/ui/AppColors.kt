package info.javaway.spend_sense.common.ui

import androidx.compose.ui.graphics.Color

data class AppColors(
    val accent: Color,
    val surface: Color,
    val onSurface: Color,
    val background: Color,
    val onBackground: Color
)

val lightPalette = AppColors(
    accent = Color(0xFF4CAF50),        // Приятный зелёный для акцентов
    background = Color(0xFFFFFFFF),    // Белый фон
    onBackground = Color(0xFF000000),  // Чёрный текст на фоне
    surface = Color(0xFFF0F0F0),       // Светло-серый для карточек и элементов
    onSurface = Color(0xFF333333),     // Тёмно-серый текст на surface
)
val darkPalette = AppColors(
    accent = Color(0xFFAF9363),
    background = Color(0xFF060D16),
    onBackground = Color(0xFFF6F6F6),
    surface = Color(0xFF001E31),
    onSurface = Color(0xFF99A6B5)
)