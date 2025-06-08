package com.example.digikala.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.digikala.R
import com.example.digikala.ui.theme.LocalSpacing
import com.example.digikala.viewModel.DeviceInfoViewModel

@Composable
fun AmazingOfferCard(
    topImageResId: Int,
    bottomImageResId: Int,
    deviceInfoViewModel: DeviceInfoViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier
            .width((deviceInfoViewModel.screenWidth * 0.39).dp)
            .height((deviceInfoViewModel.screenHeight * 0.47).dp)
            .padding(
                vertical = LocalSpacing.current.medium,
                horizontal = LocalSpacing.current.extraSmall
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.height((deviceInfoViewModel.screenHeight * 0.073).dp))
        Image(
            painterResource(id = topImageResId),
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .height((deviceInfoViewModel.screenHeight * 0.12).dp)
        )
        Spacer(modifier = Modifier.height((deviceInfoViewModel.screenHeight * 0.02).dp))
        Image(
            painterResource(id = bottomImageResId),
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .height((deviceInfoViewModel.screenHeight * 0.15).dp)
        )
        Spacer(modifier = Modifier.height((deviceInfoViewModel.screenHeight * 0.05).dp))

        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom
        ) {
            Text(
                text = stringResource(R.string.see_all),
                style = MaterialTheme.typography.h6,
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            )
            Icon(
                imageVector = Icons.Filled.KeyboardArrowLeft,
                contentDescription = "",
                tint = Color.White
            )
        }
    }
}