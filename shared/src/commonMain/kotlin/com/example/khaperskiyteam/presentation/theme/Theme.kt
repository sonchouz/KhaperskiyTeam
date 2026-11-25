package com.example.khaperskiyteam.presentation.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable

private val TeamColorScheme = darkColorScheme(
    primary = TeamRed,
    onPrimary = White,
    secondary = Gray,
    background = Background,
    onBackground = White,
    surface = Surface,
    onSurface = White,
    surfaceVariant = SurfaceLight,
    onSurfaceVariant = LightGray,
    error = Error
)

@Composable
fun KhaperskiyTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = TeamColorScheme,
        content = content
    )
}