package com.hyperdesign.moviesapp.features.home.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.hyperdesign.moviesapp.features.home.domain.model.MovieDetailsResponse

@Composable
fun MovieTabs(movieDetails: MovieDetailsResponse) {
    var selectedTab by remember { mutableStateOf(0) }
    val tabs = listOf("About Movie", "Reviews", "Cast")

    Column {
        TabRow(
            selectedTab = selectedTab,
            tabs = tabs,
            onTabSelected = { selectedTab = it }
        )

        Spacer(modifier = Modifier.height(24.dp))

        TabContent(
            selectedTab = selectedTab,
            movieDetails = movieDetails
        )
    }
}

@Composable
private fun TabRow(
    selectedTab: Int,
    tabs: List<String>,
    onTabSelected: (Int) -> Unit
) {
    ScrollableTabRow(
        selectedTabIndex = selectedTab,
        containerColor = Color.Transparent,
        contentColor = Color.White,
        edgePadding = 0.dp,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTab]),
                color = Color(0xFFE50914),
                height = 3.dp
            )
        },
        divider = {}
    ) {
        tabs.forEachIndexed { index, title ->
            Tab(
                selected = selectedTab == index,
                onClick = { onTabSelected(index) },
                text = {
                    Text(
                        text = title,
                        fontWeight = if (selectedTab == index) FontWeight.Bold else FontWeight.Normal
                    )
                }
            )
        }
    }
}

@Composable
private fun TabContent(selectedTab: Int, movieDetails: MovieDetailsResponse) {
    when (selectedTab) {
        0 -> AboutMovieTab(movieDetails)
        1 -> ReviewsTab(movieDetails)
        2 -> CastTab(movieDetails)
    }
}
