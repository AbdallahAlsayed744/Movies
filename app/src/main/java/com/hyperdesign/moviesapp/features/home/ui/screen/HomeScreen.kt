package com.hyperdesign.moviesapp.features.home.ui.screen

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(16.dp)
            .verticalScroll(scrollState)

    ) {

        Text(stringResource(R.string.what_do_you_want_to_watch), color = MaterialTheme.colorScheme.onSecondary, fontWeight = FontWeight.Bold)


        Spacer(modifier = Modifier.height(20.dp))

        SearchBar(
            query =state.query,
            onQueryChange = {action(HomeScreenContract.HomeScreenAction.chabgeQuery(it))},
            onSearch = {}
        )

        Spacer(modifier = Modifier.height(30.dp))

        LazyRow (modifier = Modifier.fillMaxWidth()){

            state.movies?.let {
                items(it.titles, key = {item->item.id}){movieImage->
                    FilmItem(movieImage)
                    Spacer(modifier = Modifier.width(5.dp))

                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))


        state.cateogreies?.let { ScrollableTabLayoutEnhanced(tabs = it.categories) }







    }
}