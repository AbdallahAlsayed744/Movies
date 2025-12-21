package com.hyperdesign.moviesapp.features.home.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hyperdesign.moviesapp.features.home.domain.model.MovieDetailsResponse


@Composable
fun CastTab(movieDetails: MovieDetailsResponse) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        movieDetails.directors.forEach { director ->
            CastCard(
                name = director.displayName,
                role = director.primaryProfessions.firstOrNull() ?: "Director"
            )
        }
    }
}
