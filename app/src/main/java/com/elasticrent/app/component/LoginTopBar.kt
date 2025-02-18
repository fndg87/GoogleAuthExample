package com.elasticrent.app.component

import androidx.compose.foundation.background
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.elasticrent.app.ui.theme.topAppBarBackgroundColor
import com.elasticrent.app.ui.theme.topAppBarContentColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginTopBar() {
    TopAppBar(
        title = { Text("Sign in",
            color = MaterialTheme.colorScheme.topAppBarContentColor)
                },
        modifier = Modifier.background(color = MaterialTheme.colorScheme.topAppBarBackgroundColor ))
}


@Composable
@Preview
fun previewLoginTopBar(){
    LoginTopBar()
}