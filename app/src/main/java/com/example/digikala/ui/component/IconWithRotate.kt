package com.example.digikala.ui.component

import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.digikala.utils.Constants.ENGLISH_LANGUAGE
import com.example.digikala.utils.Constants.USER_LANGUAGE
import com.example.digikala.viewModel.DeviceInfoViewModel

@Composable
fun IconWithRotate(imageVector: ImageVector) {

    if (USER_LANGUAGE == ENGLISH_LANGUAGE) {
        Icon(
            imageVector = imageVector,
            contentDescription = "",
            tint = Color.White,
            modifier = Modifier
                .graphicsLayer(rotationZ = 180f)
        )
    } else {
        Icon(
            imageVector = imageVector,
            contentDescription = "",
            tint = Color.White
        )
    }

}

@Composable
fun IconWithRotate(
    painter: Painter,
    tint: Color,
    deviceInfoViewModel: DeviceInfoViewModel = hiltViewModel()
) {

    if (USER_LANGUAGE == ENGLISH_LANGUAGE) {
        Icon(
            painter = painter,
            contentDescription = "",
            tint = tint,
            modifier = Modifier
                .graphicsLayer(rotationZ = 180f)
                .size((deviceInfoViewModel.screenWidth * 0.1).dp)
        )
    } else {
        Icon(
            painter = painter,
            contentDescription = "",
            tint = tint,
            modifier = Modifier
                .size((deviceInfoViewModel.screenWidth * 0.1).dp)
        )
    }

}