package com.hyperdesign.moviesapp.features.home.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hyperdesign.moviesapp.features.home.domain.model.MovieDetailsResponse

@Composable
fun MovieInfoSection(movieDetails: MovieDetailsResponse) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(8.dp))

        MovieTitle(title = movieDetails.primaryTitle)

        Spacer(modifier = Modifier.height(8.dp))

        MovieMetadata(
            year = movieDetails.startYear,
            type = movieDetails.type
        )

        Spacer(modifier = Modifier.height(24.dp))


        MovieImagesSection(movieDetails = movieDetails)

        Spacer(modifier = Modifier.height(24.dp))

        MovieTabs(movieDetails = movieDetails)
    }
}

@Composable
private fun MovieTitle(title: String) {
    Text(
        text = title,
        fontSize = 28.sp,
        fontWeight = FontWeight.Bold,
        color = Color.White
    )
}

@Composable
private fun MovieMetadata(year: Int, type: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        MetadataItem(
            icon = Icons.Default.DateRange,
            text = year.toString()
        )

        MetadataDivider()

        MetadataItem(
            icon = Icons.Default.Warning,
            text = "148 Minutes"
        )

        MetadataDivider()

        MetadataItem(
            icon = Icons.Default.Star,
            text = type
        )
    }
}

@Composable
private fun MetadataItem(icon: ImageVector, text: String) {
    Icon(
        imageVector = icon,
        contentDescription = null,
        tint = Color.Gray,
        modifier = Modifier.size(16.dp)
    )
    Text(
        text = text,
        color = Color.Gray,
        fontSize = 14.sp
    )
}

@Composable
private fun MetadataDivider() {
    Text(
        text = "•",
        color = Color.Gray,
        fontSize = 14.sp
    )
}