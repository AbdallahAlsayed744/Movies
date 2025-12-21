package com.hyperdesign.moviesapp.features.home.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.hyperdesign.moviesapp.features.home.domain.model.PrimaryImage
import com.hyperdesign.moviesapp.features.home.domain.model.Title

@Composable
fun FilmItem(title: Title,navToMovieDetails: (String) -> Unit) {
    Box(
        modifier = Modifier
            .width(200.dp)
            .height(320.dp)
            .clip(RoundedCornerShape(10.dp))
            .clickable {
                navToMovieDetails(title.id)

            }
    ) {
        AsyncImage(
            model = title.primaryImage?.url,
            contentDescription = title.primaryTitle ,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
}