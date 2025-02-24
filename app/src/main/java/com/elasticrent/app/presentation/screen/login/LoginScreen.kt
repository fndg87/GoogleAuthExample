package com.elasticrent.app.presentation.screen.login

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.elasticrent.app.domain.model.MessageBarState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.elasticrent.app.navigation.SetupNavGraph

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    navHostController: NavHostController,
    loginViewModel: LoginViewModel = hiltViewModel()
){
    val signedInState by loginViewModel.signedInState
    val messageBarState by loginViewModel.messageBarState
Scaffold(
    topBar = {
        LoginTopBar()
             },
    content = {
        LoginContent(
            signedInState = signedInState,
            messageBarState = messageBarState,
            onButtonClicked = {loginViewModel.saveSignedInState(signedIn = true)}
        )
    }
 )
}

@Preview
@Composable
fun PreviewLoginScreen(){
    val navController = rememberNavController()
    LoginScreen(navController)
}