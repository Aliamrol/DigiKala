package com.example.digikala.ui.screens.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.digikala.data.model.home.AmazingItem
import com.example.digikala.data.remote.NetworkResults
import com.example.digikala.log
import com.example.digikala.viewModel.HomeViewModel

@Composable
fun AmazingOfferSection(
    viewModel: HomeViewModel = hiltViewModel()
) {

    var amazingItemList by remember {
        mutableStateOf<List<AmazingItem>>(emptyList())
    }

    var loading by remember {
        mutableStateOf(false)
    }

    val amazingItemResult by viewModel.amazingItems.collectAsState()

    when (amazingItemResult) {
        is NetworkResults.Success -> {
            amazingItemList = amazingItemResult.data ?: emptyList()
            loading = false
            log("item: ${amazingItemList[0].name}")
        }

        is NetworkResults.Error -> {
            loading = false
            log("Amazing Offer Section Error: ${amazingItemResult.message}")
        }

        is NetworkResults.Loading -> {
            loading = true
        }
    }

}