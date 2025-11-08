package com.hyperdesign.moviesapp.common.ui.component.appbar.bottombar

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.hyperdesign.moviesapp.common.ui.navigation.INavigator
import kotlinx.coroutines.launch

@Composable
fun MoviesBottomNavigationBar(
    navHostController: NavHostController,
    navigator: INavigator, modifier: Modifier = Modifier,
) {
    val scope = rememberCoroutineScope()
    val currentBackStackEntry by navHostController.currentBackStackEntryAsState()
    var selectedDestinationIndex by rememberSaveable {
        mutableIntStateOf(MoviesNavigationBarItem.destinations.indices.first)
    }
    val isVisible by remember {
        derivedStateOf {
            MoviesNavigationBarItem.destinations.any {
                currentBackStackEntry?.destination?.hasRoute(it.destination::class) == true
            }
        }
    }
    AnimatedVisibility(
        visible = isVisible,
        enter = slideInVertically(initialOffsetY = { it }),
        exit = slideOutVertically(targetOffsetY = { it })
    ) {
        Box(
            modifier = modifier.height(IntrinsicSize.Min),
            contentAlignment = Alignment.BottomCenter
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 24.dp)
                    .shadow(
                        elevation = 20.dp,
                        ambientColor = MaterialTheme.colorScheme.scrim,
                        spotColor = MaterialTheme.colorScheme.scrim
                    )
                    .background(color = MaterialTheme.colorScheme.background)
                    .navigationBarsPadding()
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .navigationBarsPadding(),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                MoviesNavigationBarItem.destinations.forEachIndexed { index, item ->
                    BottomNavigationBarItem(
                        modifier = Modifier.padding(top = 6.dp),
                        icon = ImageVector.vectorResource(item.icon),
                        label = stringResource(item.label),
                        currentIndex = index,
                        selectedDestinationIndex = selectedDestinationIndex,
                        onItemClick = {
                            scope.launch {
                                navigator.navigate(destination = item.destination)
                                selectedDestinationIndex = index
                            }
                        }
                    )
                }
            }
        }
    }
}

@SuppressLint("UseOfNonLambdaOffsetOverload")
@Composable
fun BottomNavigationBarItem(
    modifier: Modifier = Modifier, icon: ImageVector, label: String, currentIndex: Int,
    selectedDestinationIndex: Int,
    onItemClick: () -> Unit,
) {
    val selected = selectedDestinationIndex == currentIndex
    val targetColor = if (selected) MaterialTheme.colorScheme.onBackground else MaterialTheme.colorScheme.surface

    val animatedColor by animateColorAsState(
        targetValue = targetColor,
        animationSpec = tween(durationMillis = 250)
    )

    Column(
        modifier = modifier
            .heightIn(min = 59.dp)
            .clickable(
                onClick = onItemClick,
                enabled = selected.not(),
                indication = null,
                interactionSource = null
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(6.dp, alignment = Alignment.Bottom)
    ) {
        AnimatedContent(
            targetState = selected,
            transitionSpec = {
                fadeIn(animationSpec = tween(durationMillis = 100)) togetherWith
                        fadeOut(animationSpec = tween(durationMillis = 100))
            },
            contentAlignment = Alignment.Center
        ) { isSelected ->
            if (isSelected) {
                Box(
                    modifier = Modifier
                        .shadow(
                            elevation = 1.dp,
                            shape = CircleShape,
                            clip = false
                        )
                        .size(51.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.background)
                        .padding(5.dp)
                        .clip(CircleShape)
                        .background(color = MaterialTheme.colorScheme.primary),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        modifier = Modifier,
                        imageVector = icon,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onPrimary,
                    )
                }
            } else {
                Icon(
                    modifier = Modifier,
                    imageVector = icon,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.surface,
                )
            }
        }
        Text(
            text = label,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.bodySmall,
            color = animatedColor
        )
    }
}