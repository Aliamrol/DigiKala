package com.example.digikala.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.digikala.R
import com.example.digikala.ui.theme.LocalElevation
import com.example.digikala.ui.theme.LocalShape
import com.example.digikala.ui.theme.LocalSpacing
import com.example.digikala.ui.theme.searchBarBg
import com.example.digikala.ui.theme.unSelectedBottomBar
import com.example.digikala.utils.Constants.ENGLISH_LANGUAGE
import com.example.digikala.utils.Constants.USER_LANGUAGE
import com.example.digikala.viewModel.DeviceInfoViewModel


@Composable
fun SearchBarSection(
    deviceInfoViewModel: DeviceInfoViewModel = hiltViewModel()
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height((deviceInfoViewModel.screenHeight * 0.08).dp),
        elevation = LocalElevation.current.extraSmall
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(LocalSpacing.current.small)
                .clip(LocalShape.current.biggerSmall)
                .background(MaterialTheme.colors.searchBarBg)
        ) {
            SearchBarContent()
        }

    }
}

@Composable
private fun SearchBarContent(
    deviceInfoViewModel: DeviceInfoViewModel = hiltViewModel()
) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Icon(
            modifier = Modifier.height((deviceInfoViewModel.screenHeight * 0.03).dp),
            painter = painterResource(R.drawable.search),
            contentDescription = ""
        )
        Text(
            modifier = Modifier.padding(start = 20.dp),
            textAlign = TextAlign.Center,
            color = MaterialTheme.colors.unSelectedBottomBar,
            style = MaterialTheme.typography.h2,
            fontWeight = FontWeight.Normal,
            text = stringResource(R.string.search_in)
        )
        Image(
            modifier = Modifier
                .width((deviceInfoViewModel.screenWidth * 0.24).dp)
                .padding(start = 5.dp),
            painter = digikalaLogoChangeByLanguage(),
            contentDescription = ""
        )
    }
}


@Composable
private fun digikalaLogoChangeByLanguage(): Painter =
    if (USER_LANGUAGE == ENGLISH_LANGUAGE) painterResource(R.drawable.digi_red_english) else painterResource(
        R.drawable.digi_red_persian
    )

