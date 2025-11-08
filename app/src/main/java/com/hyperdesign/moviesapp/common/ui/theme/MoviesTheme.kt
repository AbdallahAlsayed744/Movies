package com.hyperdesign.moviesapp.common.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun MoviesAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val alTashiratColorScheme = when {
        darkTheme -> MoviesDarkColorScheme
        else -> MoviesLightColorScheme
    }
    MaterialTheme(
        colorScheme = alTashiratColorScheme,
//        typography = AlTashiratTypography,
        content = content,
//        shapes = AlTashiratShapes
    )
}