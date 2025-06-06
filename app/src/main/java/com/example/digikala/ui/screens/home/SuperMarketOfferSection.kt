package com.example.digikala.ui.screens.home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.digikala.R
import com.example.digikala.data.model.home.AmazingItem
import com.example.digikala.data.remote.NetworkResults
import com.example.digikala.log
import com.example.digikala.ui.theme.DigikalaLightGreen
import com.example.digikala.viewModel.HomeViewModel

@Composable
fun SuperMarketOfferSection(
    viewModel: HomeViewModel = hiltViewModel()
) {


    var superMarketItemList by remember {
        mutableStateOf<List<AmazingItem>>(emptyList())
    }

    var loading by remember {
        mutableStateOf(false)
    }

    val superMarketItemResult by viewModel.superMarketItems.collectAsState()

    when (superMarketItemResult) {
        is NetworkResults.Success -> {
            superMarketItemList = superMarketItemResult.data ?: emptyList()
            loading = false
            log("item: ${superMarketItemList[0].name}")
        }

        is NetworkResults.Error -> {
            loading = false
            log("superMarket Offer Section Error: ${superMarketItemResult.message}")
        }

        is NetworkResults.Loading -> {
            loading = true
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.DigikalaLightGreen)
    ) {
        LazyRow(
            modifier = Modifier.background(MaterialTheme.colors.DigikalaLightGreen)
        ) {
            item {
                AmazingOfferCard(
                    topImageResId = R.drawable.supermarketamazings,
                    bottomImageResId = R.drawable.fresh
                )
            }

            items(superMarketItemList) { item ->
                AmazingItem(item = item)
            }

            item {
                AmazingShowMoreItem()
            }
        }
    }

}