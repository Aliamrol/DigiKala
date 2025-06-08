package com.example.digikala.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
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
import com.example.digikala.ui.theme.DarkCyan
import com.example.digikala.ui.theme.LocalSpacing
import com.example.digikala.ui.theme.darkText
import com.example.digikala.viewModel.DeviceInfoViewModel

@Composable
fun MostFavoriteProductShowMore(
    deviceInfoViewModel: DeviceInfoViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier
            .size(width = (deviceInfoViewModel.screenWidth * 0.44).dp, height = (deviceInfoViewModel.screenHeight * 0.46).dp)
            .padding(
                end = LocalSpacing.current.medium,
                start = LocalSpacing.current.semiSmall,
                top = LocalSpacing.current.semiLarge
            )
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Icon(
            painter = painterResource(id = R.drawable.show_more),
            contentDescription = "",
            tint = MaterialTheme.colors.DarkCyan,
            modifier = Modifier.size((deviceInfoViewModel.screenWidth * 0.10).dp)
        )
        Spacer(modifier = Modifier.height((deviceInfoViewModel.screenHeight * 0.025).dp))
        Text(
            text = stringResource(R.string.see_all),
            style = MaterialTheme.typography.h6,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colors.darkText
        )
    }
}