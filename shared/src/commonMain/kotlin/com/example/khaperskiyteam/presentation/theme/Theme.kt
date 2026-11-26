package com.example.khaperskiyteam.presentation.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val KTColorScheme = darkColorScheme(

    primary = KTColors.Red,
    onPrimary = KTColors.White,

    secondary = KTColors.TextSecondary,
    onSecondary = KTColors.Black,

    background = KTColors.Background,
    onBackground = KTColors.TextPrimary,

    surface = KTColors.Surface,
    onSurface = KTColors.TextPrimary,

    surfaceVariant = KTColors.SurfaceVariant,
    onSurfaceVariant = KTColors.TextSecondary,

    outline = KTColors.Border,

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