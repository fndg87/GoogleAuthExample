package com.elasticrent.app.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import coil.compose.rememberAsyncImagePainter
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
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.elasticrent.app.R
import com.elasticrent.app.ui.theme.PurpleGrey40

@Composable
fun CustomSizedImage(
    image: Any, // Can be a drawable resource ID, URL, or other image data
    width: Int? = null, // Optional width in pixels
    height: Int? = null, // Optional height in pixels
    contentScale: ContentScale = ContentScale.Fit, // How the image should be scaled
    alignment: Alignment = Alignment.Center // Alignment within the bounds
) {
    val modifier = if (width != null && height != null) {
        Modifier.size(width = width.dp, height = height.dp) // Explicit size
    } else if (width != null) {
        Modifier.width(width = width.dp) // Only width specified
    } else if (height != null) {
        Modifier.height(height = height.dp) // Only height specified
    } else {
        Modifier.fillMaxSize() // Fills the available space (be careful with this!)
    }

    val imagePainter = when (image) {
        is Int -> painterResource(id = image)  // Drawable Resource ID
        else -> {
            val context = LocalContext.current
            rememberAsyncImagePainter(
                model = image, // URL, Bitmap, etc.
                imageLoader = coil.ImageLoader(context) // Ensure you have Coil set up
            )
        }
    }


    Image(
        painter = imagePainter,
        contentDescription = null, // Provide a meaningful description if needed
        modifier = modifier,
        contentScale = contentScale,
        alignment = alignment
    )
}

@Composable
fun GoogleButton(
    modifier: Modifier = Modifier,
    loadingState: Boolean = false,
    primaryText: String = "Sign in with Google",
    secondaryText: String = "Please wait...",
    icon: Int = R.drawable.g,
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
            modifier= Modifier.padding(12.dp)
                .animateContentSize(animationSpec = tween(durationMillis = 300, easing = LinearOutSlowInEasing)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){
            CustomSizedImage(image = R.drawable.g, width = 50, height = 40)
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
    GoogleButton{}
}