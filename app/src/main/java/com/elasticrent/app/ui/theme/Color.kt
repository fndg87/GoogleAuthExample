package com.elasticrent.app.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext


val Gray200 = Color(0xFF819ca9)
val Gray500 = Color(0xFF546e7a)
val Gray700 = Color(0xFF29434e)
val Teal200 = Color(0xFF03DAC5)
val ErrorRed = Color(0xFFFF6C60)
val InfoGreen = Color(0xFF00C096)
val LoadingBlue = Color(0xFF1A73E8)

//@Composable
//fun DarkOrLight(){
//    val systemIsDark = isSystemInDarkTheme()
//    val dynamicColor = true // Set to true to use dynamic color if available
//    val colorScheme = if (dynamicColor && android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.S) {
//        val applicationContext = LocalContext.current
//        if (systemIsDark) dynamicDarkColorScheme(context = applicationContext) else dynamicLightColorScheme(context = applicationContext)
//    } else {
//        if (systemIsDark) darkColorScheme() else lightColorScheme()
//    }
//}

val ColorScheme.topAppBarContentColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Color.White else Color.LightGray

val ColorScheme.topAppBarBackgroundColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Gray500 else Color.Black

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)