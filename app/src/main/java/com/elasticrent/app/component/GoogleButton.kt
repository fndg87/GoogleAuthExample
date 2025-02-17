package com.elasticrent.app.component

import android.widget.Space
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes

import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.elasticrent.app.R
import com.elasticrent.app.ui.theme.PurpleGrey40

@Composable
fun GoogleButton(
    modifier: Modifier = Modifier,
    loadingState: Boolean = false,
    primaryText: String = "Sign in with Google",
    secondaryText: String = "Please wait...",
    icon: Int = R.drawable.ic_g_logo_background,
    shape: Shape = Shapes().medium,
    borderColor: Color =  Color.LightGray,
    backgroundColor: Color = MaterialTheme.colorScheme.surface,
    progressIndicatorColor : Color = PurpleGrey40,
    onClick: () -> Unit
){
    // Dealing with the button text depending of state
    var buttonText by remember { mutableStateOf(primaryText) }
    LaunchedEffect( key1= loadingState) {
        buttonText = if(loadingState) secondaryText else primaryText
    }

    Surface(
        modifier=modifier.clickable(enabled = !loadingState) { onClick()},
        shape=shape,
        border = BorderStroke(width = 1.dp,color=borderColor),
        color = backgroundColor
    ){
        Row(
            modifier= Modifier.padding(start = 12.dp, end=16.dp, top = 12.dp, bottom = 12.dp).animateContentSize(animationSpec = tween(durationMillis = 300, easing = LinearOutSlowInEasing)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){
            Image(painter= painterResource(icon), contentDescription = "Google Logo")
            Spacer(modifier = Modifier.width(8.dp))
            Text(text=buttonText)
            if(loadingState){
                Spacer(modifier = Modifier.width(16.dp))
                CircularProgressIndicator(modifier=Modifier.size(16.dp), strokeWidth = 2.dp, color = progressIndicatorColor)
            }
        }

    }

}

@Composable
@Preview
fun googleButtonPreview(){
    GoogleButton{

    }
}