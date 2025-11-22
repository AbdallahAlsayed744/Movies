package com.hyperdesign.moviesapp.features.home.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hyperdesign.moviesapp.features.home.domain.model.Category
import androidx.compose.foundation.clickable


@Composable
fun ScrollableTabLayoutEnhanced(
    tabs: List<Category>,
    selectedTabIndex: Int = 0,
    onTabSelected: (Int) -> Unit = {}
) {
    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .height(56.dp)
            .background(Color.Transparent)
    ) {
        Row(
            modifier = Modifier
                .horizontalScroll(scrollState)
                .height(56.dp)
                .padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            tabs.forEachIndexed { index, category ->
                TabItemCustom(
                    label = category.category,
                    selected = selectedTabIndex == index,
                    onClick = { onTabSelected(index) }
                )
            }
        }
    }
}

@Composable
private fun TabItemCustom(
    label: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .clickable(onClick = onClick)
            .padding(horizontal = 12.dp, vertical = 4.dp)
            .then(
                if (selected) {
                    Modifier.background(
                        color = Color.Transparent,
                        shape = androidx.compose.foundation.shape.RoundedCornerShape(4.dp)
                    )
                } else Modifier
            )
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .height(50.dp)
                .padding(horizontal = 4.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = label,
                fontSize = 14.sp,
                color = if (selected) Color.White else Color.Gray
            )

            if (selected) {
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .height(3.dp)
                        .padding(horizontal = 4.dp)
                        .background(Color.Cyan)
                )
            }
        }
    }
}