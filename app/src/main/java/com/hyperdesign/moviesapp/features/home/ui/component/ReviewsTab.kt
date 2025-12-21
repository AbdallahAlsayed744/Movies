package com.hyperdesign.moviesapp.features.home.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hyperdesign.moviesapp.features.home.domain.model.MovieDetailsResponse


@Composable
fun ReviewsTab(movieDetails: MovieDetailsResponse) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        movieDetails.writers?.take(2)?.forEach { writer ->
            ReviewCard(
                name = writer.displayName?:"",
                rating = movieDetails.rating.aggregateRating,
                review = "From DC Comics comes the Suicide Squad, an antihero team of incarcerated supervillains who act as deniable assets for the United States government.",
                imageUrl = writer.primaryImage?.url
            )
        }
    }
}