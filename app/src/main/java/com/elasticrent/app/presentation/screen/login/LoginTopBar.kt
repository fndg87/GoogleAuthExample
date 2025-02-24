package com.elasticrent.app.presentation.screen.login

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
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                titleContentColor = MaterialTheme.colorScheme.primary,
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