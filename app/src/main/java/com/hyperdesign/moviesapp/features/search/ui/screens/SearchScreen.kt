package com.hyperdesign.moviesapp.features.search.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.hyperdesign.moviesapp.R
import com.hyperdesign.moviesapp.features.home.ui.component.SearchBar
import com.hyperdesign.moviesapp.features.home.ui.viewmodel.HomeScreenContract
import com.hyperdesign.moviesapp.features.search.ui.compmnent.TitleCard
import com.hyperdesign.moviesapp.features.search.ui.viewmodel.SearchScreenContract
import com.hyperdesign.moviesapp.features.search.ui.viewmodel.SearchScreenViewModel
import org.koin.compose.viewmodel.koinViewModel


@Composable
fun SearchScreen(
    searchViewModel: SearchScreenViewModel = koinViewModel()
){

    val state by searchViewModel.state.collectAsState()

    SearchScreenContent(
        state = state,
        action = searchViewModel::onActionTrigger
    )

}


@Composable
fun SearchScreenContent(
    state: SearchScreenContract.SearchScreenState,
    action: (SearchScreenContract.SearchScreenAction) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                SearchBar(
                    query = state.query,
                    onQueryChange = { action(SearchScreenContract.SearchScreenAction.changeQuery(it)) },
                    onSearch = {}
                )
            }

            state.searchResult?.titles?.let { titles ->
                if (titles.isNotEmpty()) {
                    items(titles, key = { it.id }) { title ->
                        TitleCard(title)
                    }
                }
            }
        }

        if (state.query.isNotEmpty() || state.searchResult?.titles.isNullOrEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 80.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.search_img),
                    contentDescription = "No results found",
                    modifier = Modifier.size(120.dp)
                )
            }
        }

    }
}

