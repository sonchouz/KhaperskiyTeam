package com.example.khaperskiyteam.presentation.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val KTColorScheme = darkColorScheme(
    primary = KTColors.Primary,
    onPrimary = KTColors.White,

    secondary = KTColors.PrimaryDark,
    onSecondary = KTColors.White,

    background = KTColors.Background,
    onBackground = KTColors.White,

    surface = KTColors.Surface,
    onSurface = KTColors.White,

    surfaceVariant = KTColors.Border,
    onSurfaceVariant = KTColors.Muted,

    outline = KTColors.Muted,

    error = KTColors.Error,
    onError = KTColors.White
)

@Composable
fun KhaperskiyTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = KTColorScheme,
        typography = KTTypography,
        shapes = KTShapes,
        content = content
    )
}