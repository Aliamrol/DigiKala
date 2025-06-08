package com.example.digikala.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
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
import com.example.digikala.ui.component.IconWithRotate
import com.example.digikala.ui.theme.DigikalaLightRed
import com.example.digikala.ui.theme.LocalShape
import com.example.digikala.ui.theme.LocalSpacing
import com.example.digikala.ui.theme.darkText
import com.example.digikala.viewModel.DeviceInfoViewModel

@Composable
fun AmazingShowMoreItem(deviceInfoViewModel: DeviceInfoViewModel = hiltViewModel()) {
    Card(
        modifier = Modifier
            .size(
                width = (deviceInfoViewModel.screenWidth * 0.43).dp,
                height = (deviceInfoViewModel.screenHeight * 0.44).dp
            )
            .padding(
                end = LocalSpacing.current.medium,
                start = LocalSpacing.current.semiSmall,
                top = LocalSpacing.current.semiLarge
            ),
        shape = LocalShape.current.small,
        contentColor = Color.White
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            IconWithRotate(
                painter = painterResource(R.drawable.show_more),
                tint = MaterialTheme.colors.DigikalaLightRed
            )

            Spacer(modifier = Modifier.height((deviceInfoViewModel.screenHeight * 0.05).dp))
            Text(
                text = stringResource(R.string.see_all),
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colors.darkText
            )
        }
    }
}