package com.example.digikala.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.example.digikala.R
import com.example.digikala.navigation.Screens
import com.example.digikala.ui.component.RoundedIconBox
import com.example.digikala.ui.theme.LocalSpacing
import com.example.digikala.ui.theme.amber
import com.example.digikala.ui.theme.grayCategory
import com.example.digikala.utils.Constants.AUCTION_URL
import com.example.digikala.utils.Constants.DIGIJET_URL
import com.example.digikala.utils.Constants.DIGIPAY_URL
import com.example.digikala.utils.Constants.DIGIPLUS_URL
import com.example.digikala.utils.Constants.GIFT_CARD_URL
import com.example.digikala.utils.Constants.MORE_URL
import com.example.digikala.utils.Constants.PINDO_URL
import com.example.digikala.utils.Constants.SHOPPING_URL


@Composable
fun ShowCaseSection(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = LocalSpacing.current.semiMedium,
                vertical = LocalSpacing.current.biggerSmall
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = LocalSpacing.current.semiSmall),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            RoundedIconBox(
                image = painterResource(id = R.drawable.digijet),
                title = stringResource(id = R.string.digikala_jet),
                onClick = onBoxClick(
                    navController = navController,
                    url = DIGIJET_URL
                )
            )
            RoundedIconBox(
                image = painterResource(id = R.drawable.auction),
                title = stringResource(id = R.string.digi_style),
                onClick = onBoxClick(
                    navController = navController,
                    url = AUCTION_URL
                )
            )
            RoundedIconBox(
                image = painterResource(id = R.drawable.digipay),
                title = stringResource(id = R.string.digi_pay),
                onClick = onBoxClick(
                    navController = navController,
                    url = DIGIPAY_URL
                )
            )
            RoundedIconBox(
                image = painterResource(id = R.drawable.pindo),
                title = stringResource(id = R.string.pindo),
                bgColor = MaterialTheme.colors.amber,
                onClick = onBoxClick(
                    navController = navController,
                    url = PINDO_URL
                )
            )
        }


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = LocalSpacing.current.semiSmall),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            RoundedIconBox(
                image = painterResource(id = R.drawable.shopping),
                title = stringResource(id = R.string.digi_shopping),
                onClick = onBoxClick(
                    navController = navController,
                    url = SHOPPING_URL
                )
            )
            RoundedIconBox(
                image = painterResource(id = R.drawable.giftcard),
                title = stringResource(id = R.string.gift_card),
                onClick = onBoxClick(
                    navController = navController,
                    url = GIFT_CARD_URL
                )
            )
            RoundedIconBox(
                image = painterResource(id = R.drawable.digiplus),
                title = stringResource(id = R.string.digi_plus),
                onClick = onBoxClick(
                    navController = navController,
                    url = DIGIPLUS_URL
                )
            )
            RoundedIconBox(
                image = painterResource(id = R.drawable.more),
                title = stringResource(id = R.string.more),
                bgColor = MaterialTheme.colors.grayCategory,
                onClick = onBoxClick(
                    navController = navController,
                    url = MORE_URL
                )
            )
        }
    }
}


@Composable
fun onBoxClick(
    navController: NavHostController, url: String
): () -> Unit = {
    navController.navigate(route = Screens.WebView.route + "?url=${url}")
}