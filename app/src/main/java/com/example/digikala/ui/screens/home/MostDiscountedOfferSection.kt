package com.example.digikala.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.digikala.R
import com.example.digikala.data.model.home.StoreProduct
import com.example.digikala.data.remote.NetworkResults
import com.example.digikala.log
import com.example.digikala.ui.theme.darkText
import com.example.digikala.ui.theme.spacing
import com.example.digikala.viewModel.HomeViewModel

@Composable
fun MostDiscountedOfferSection(
    viewModel: HomeViewModel = hiltViewModel(),
) {

    var mostDiscountedList by remember {
        mutableStateOf<List<StoreProduct>>(emptyList())
    }

    var loading by remember { mutableStateOf(false) }

    val mostDiscountedResult by viewModel.mostDiscountedItems.collectAsState()

    when (mostDiscountedResult) {
        is NetworkResults.Success -> {
            loading = false
            mostDiscountedList = mostDiscountedResult.data ?: emptyList()
        }

        is NetworkResults.Error -> {
            loading = false
            log("Most Discounted Offer Section Error! : ${mostDiscountedResult.message}")
        }

        is NetworkResults.Loading<*> -> {
            loading = true
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = stringResource(R.string.most_discounted_products),
            modifier = Modifier.padding(MaterialTheme.spacing.small),
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.h3,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colors.darkText
        )

        FlowRow(
            maxItemsInEachRow = 2,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            horizontalArrangement = Arrangement.Center
        ) {
            for(item in mostDiscountedList){
                MostDiscountedCard(item = item)
            }
        }
    }
}