package com.example.digikala.ui.screens.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.digikala.data.model.home.Slider
import com.example.digikala.data.remote.NetworkResults
import com.example.digikala.log
import com.example.digikala.ui.component.CenterBannerItem
import com.example.digikala.viewModel.HomeViewModel

@Composable
fun CenterBannerSection(
    bannerNumber: Int,
    viewModel: HomeViewModel = hiltViewModel()
) {
    var centerBannerList by remember {
        mutableStateOf<List<Slider>>(emptyList())
    }

    var loading by remember { mutableStateOf(false) }

    val centerBannerResult by viewModel.centerBannerItems.collectAsState()

    when (centerBannerResult) {
        is NetworkResults.Success -> {
            loading = false
            centerBannerList = centerBannerResult.data ?: emptyList()
        }

        is NetworkResults.Error -> {
            loading = false
            log("Center Banner Section Error")
        }

        is NetworkResults.Loading -> {
            loading = true
        }
    }

    if (centerBannerList.isNotEmpty()) {
        CenterBannerItem(centerBannerList[bannerNumber - 1].image)
    }


}