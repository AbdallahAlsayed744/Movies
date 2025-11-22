package com.hyperdesign.moviesapp.common.ui.dialoge.loading

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun MoviesLoadingDialog(modifier: Modifier = Modifier) {
    Dialog(onDismissRequest = {}) {
        Box(
            modifier = modifier
                .background(color = MaterialTheme.colorScheme.background, shape = RoundedCornerShape(24.dp))
                .padding(50.dp)
        ) {
            CircularProgressIndicator(color = MaterialTheme.colorScheme.secondary)
        }
    }
}