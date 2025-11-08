package com.hyperdesign.moviesapp.features.launchflow.splash.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.hyperdesign.moviesapp.R
import com.hyperdesign.moviesapp.features.launchflow.splash.ui.viewmodel.SplashScreenViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun SplashScreen(splashViewModel: SplashScreenViewModel= koinViewModel()){

    SplashScreenContent()
}


@Composable
fun SplashScreenContent(){

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background), contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier.width(120.dp).height(120.dp),
            painter = painterResource(R.drawable.popcorn),

            contentDescription = null,
            contentScale = ContentScale.Crop
        )
    }

}