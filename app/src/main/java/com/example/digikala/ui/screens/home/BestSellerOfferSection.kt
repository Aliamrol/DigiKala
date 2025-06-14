package com.example.digikala.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.digikala.R
import com.example.digikala.data.model.home.StoreProduct
import com.example.digikala.data.remote.NetworkResults
import com.example.digikala.log
import com.example.digikala.ui.theme.darkText
import com.example.digikala.ui.theme.spacing
import com.example.digikala.utils.DigitHelper.digitByLocate
import com.example.digikala.viewModel.DeviceInfoViewModel
import com.example.digikala.viewModel.HomeViewModel


@Composable
fun BestSellerOfferSection(
    viewModel: HomeViewModel = hiltViewModel(),
    deviceInfoViewModel: DeviceInfoViewModel = hiltViewModel()
) {
    var bestSellerOfferList by remember {
        mutableStateOf<List<StoreProduct>>(emptyList())
    }

    var loading by remember { mutableStateOf(false) }

    val bestSellerOfferResult by viewModel.bestSellerItems.collectAsState()

    when (bestSellerOfferResult) {
        is NetworkResults.Success -> {
            loading = false
            bestSellerOfferList = bestSellerOfferResult.data ?: emptyList()
        }

        is NetworkResults.Error -> {
            loading = false
            log("Best Seller Offer Section Error!")
        }

        is NetworkResults.Loading -> {
            loading = true
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(MaterialTheme.spacing.small)
    ) {
        Text(
            text = stringResource(R.string.best_selling_products),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.h3,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colors.darkText
        )

        LazyHorizontalGrid(
            rows = GridCells.Fixed(3),
            modifier = Modifier
                .padding(top = MaterialTheme.spacing.medium)
                .height((deviceInfoViewModel.screenHeight * 0.31).dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            itemsIndexed(bestSellerOfferList) { index, item ->
                ProductHorizontalCard(
                    name = item.name,
                    id = digitByLocate((index + 1).toString()),
                    imageUrl = item.image
                )
            }
        }
    }
}
