package com.elasticrent.app.component

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.elasticrent.app.domain.model.MessageBarState


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(){
Scaffold(
    topBar = {
        LoginTopBar()
             },
    content = {
        LoginContent(
            signedInState = false,
            messageBarState = MessageBarState(),
            onButtonClicked = {}
        )
    }
 )
}

@Preview
@Composable
fun PreviewLoginScreen(){
    LoginScreen()
}