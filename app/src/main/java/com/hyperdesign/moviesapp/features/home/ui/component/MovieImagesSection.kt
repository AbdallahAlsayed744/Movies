package com.hyperdesign.moviesapp.features.home.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.hyperdesign.moviesapp.features.home.domain.model.MovieDetailsResponse

@Composable
fun MovieImagesSection(movieDetails: MovieDetailsResponse) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
    ) {
        Text(
            text = "Images",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )

        MovieImagesRow(movieDetails = movieDetails)
    }
}

@Composable
private fun MovieImagesRow(movieDetails: MovieDetailsResponse) {
    // Create a list of images from the movie
    val images = buildList {
        // Add primary image
        add(movieDetails.primaryImage.url)

        // Add images from interests/genres if available
        movieDetails.interests.forEach { interest ->
            interest.primaryImage?.url?.let { add(it) }
        }

        // Add images from writers if available
        movieDetails.writers?.forEach { writer ->
            writer.primaryImage?.url?.let { add(it) }
        }
    }.take(5) // Limit to 5 images

    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(images) { imageUrl ->
            MovieImageCard(imageUrl = imageUrl)
        }
    }
}

@Composable
private fun MovieImageCard(imageUrl: String) {
    Card(
        modifier = Modifier
            .width(120.dp)
            .height(180.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        AsyncImage(
            model = imageUrl,
            contentDescription = "Movie image",
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp)),
            contentScale = ContentScale.Crop
        )
    }
}