package com.hyperdesign.moviesapp.features.home.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.hyperdesign.moviesapp.features.home.domain.model.MovieDetailsResponse

@Composable
fun AboutMovieTab(movieDetails: MovieDetailsResponse) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = movieDetails.plot,
            color = Color.White.copy(alpha = 0.8f),
            fontSize = 14.sp,
            lineHeight = 22.sp
        )
    }
}