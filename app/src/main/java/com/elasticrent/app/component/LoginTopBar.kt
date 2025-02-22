package com.elasticrent.app.component

import androidx.compose.foundation.background
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.elasticrent.app.ui.theme.darkOrLight


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginTopBar() {
        val color = darkOrLight()
        TopAppBar(
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = color.primaryContainer,
                titleContentColor = color.primary,
            ),
            title = {
                Text("Sign in")
            }
        )
}


@Composable
@Preview
fun previewLoginTopBar(){
    LoginTopBar()
}