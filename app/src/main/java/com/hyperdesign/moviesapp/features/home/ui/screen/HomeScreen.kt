package com.hyperdesign.moviesapp.features.home.ui.screen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.hyperdesign.moviesapp.R
import com.hyperdesign.moviesapp.features.home.ui.component.FilmItem
import com.hyperdesign.moviesapp.features.home.ui.component.ImageGridCell
import com.hyperdesign.moviesapp.features.home.ui.component.ScrollableTabLayoutEnhanced
import com.hyperdesign.moviesapp.features.home.ui.component.SearchBar
import com.hyperdesign.moviesapp.features.home.ui.viewmodel.HomeScreenContract
import com.hyperdesign.moviesapp.features.home.ui.viewmodel.HomeViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(homeViewModel: HomeViewModel = koinViewModel()){

    val state by homeViewModel.state.collectAsState()

    Log.d("moviesssssss",state.movies.toString())

    HomeScreenContent(state = state, action = homeViewModel::onActionTrigger)
}


@Composable
fun HomeScreenContent(
    state: HomeScreenContract.HomeScreenState,
    action:( HomeScreenContract.HomeScreenAction)->Unit
){
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()
            .padding(bottom = 24.dp)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        item {
            Text(
                stringResource(R.string.what_do_you_want_to_watch),
                color = MaterialTheme.colorScheme.onSecondary,
                fontWeight = FontWeight.Bold
            )
        }

        item {
            SearchBar(
                query = state.query,
                onQueryChange = { action(HomeScreenContract.HomeScreenAction.chabgeQuery(it)) },
                onSearch = {}
            )
        }

        item {
            LazyRow(modifier = Modifier.fillMaxWidth()) {
                state.movies?.let {
                    items(it.titles, key = { item -> item.id }) { movieImage ->
                        FilmItem(movieImage, navToMovieDetails = {
                            action(HomeScreenContract.HomeScreenAction.changeMovieId(it))
                            action(HomeScreenContract.HomeScreenAction.navigateToMovieDetails(it))
                        })
                        Spacer(modifier = Modifier.width(5.dp))
                    }
                }
            }
        }

        item {
            state.cateogreies?.let {
                ScrollableTabLayoutEnhanced(
                    tabs = it.categories,
                    selectedTabIndex = state.categoryChangeNumber,
                    onTabSelected = { action(HomeScreenContract.HomeScreenAction.chabgeCategoryNumber(it)) },
                    onTabClick = { categoryId ->
                        action(HomeScreenContract.HomeScreenAction.ChangeCategoryId(categoryId))
                    }
                )
            }
        }

        state.categoryByIdResponse?.let { response ->
            items(response.similarInterests.size) { index ->
                if (index % 2 == 0) {
                    val firstItem = response.similarInterests.getOrNull(index)
                    val secondItem = response.similarInterests.getOrNull(index + 1)

                   Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        if (firstItem != null) {
                            Box(
                                modifier = Modifier
                                    .weight(1f)
                            ) {
                                ImageGridCell(cateogry = response,firstItem, navToMovieDetails = {
                                    action(HomeScreenContract.HomeScreenAction.changeMovieId(it))
                                    action(HomeScreenContract.HomeScreenAction.navigateToMovieDetails(it))
                                })
                            }
                        } else {
                            Spacer(
                                modifier = Modifier.weight(1f)
                            )
                        }

                        if (secondItem != null) {
                            Box(
                                modifier = Modifier
                                    .weight(1f)
                            ) {
                                ImageGridCell(cateogry = response,secondItem, navToMovieDetails = {
                                    action(HomeScreenContract.HomeScreenAction.changeMovieId(it))
                                    action(HomeScreenContract.HomeScreenAction.navigateToMovieDetails(it))
                                })
                            }
                        } else {
                            Spacer(
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }
                }
            }
        }
    }
}