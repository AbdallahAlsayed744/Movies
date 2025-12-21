package com.hyperdesign.moviesapp.features.home.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.hyperdesign.moviesapp.features.home.domain.model.MovieDetailsResponse

@Composable
fun MovieHeroSection(movieDetails: MovieDetailsResponse) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(450.dp)
    ) {
        HeroImage(imageUrl = movieDetails.primaryImage.url, title = movieDetails.primaryTitle)
        GradientOverlay()
        BackButton()
        RatingBadge(rating = movieDetails.rating.aggregateRating)
    }
}

@Composable
private fun HeroImage(imageUrl: String, title: String) {
    AsyncImage(
        model = imageUrl,
        contentDescription = title,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )
}

@Composable
private fun BoxScope.GradientOverlay() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color.Transparent,
                        Color(0xFF1C1C1E).copy(alpha = 0.8f),
                        Color(0xFF1C1C1E)
                    ),
                    startY = 200f
                )
            )
    )
}

@Composable
private fun BoxScope.BackButton() {
    IconButton(
        onClick = { /* Handle back navigation */ },
        modifier = Modifier
            .padding(16.dp)
            .align(Alignment.TopStart)
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back",
            tint = Color.White
        )
    }
}

@Composable
private fun BoxScope.RatingBadge(rating: Double) {
    Surface(
        modifier = Modifier
            .align(Alignment.BottomEnd)
            .padding(16.dp),
        shape = RoundedCornerShape(8.dp),
        color = Color(0xFFFFA000)
    ) {
        Text(
            text = String.format("%.1f", rating),
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
    }
}