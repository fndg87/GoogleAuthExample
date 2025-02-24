package com.elasticrent.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.elasticrent.app.navigation.SetupNavGraph
import com.elasticrent.app.presentation.screen.login.LoginScreen
import com.elasticrent.app.ui.theme.GoogleAuthExampleTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GoogleAuthExampleTheme {
                val navController = rememberNavController()
//                SetupNavGraph(navController = navController)
                LoginScreen(
                    navHostController = navController
                )
            }
        }
    }
}
