package com.example.digikala.ui.screens.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.digikala.utils.Constants
import com.example.digikala.utils.LocaleUtils
import com.example.digikala.viewModel.HomeViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(navController: NavHostController) {
    Home(navController)
}


@Composable
fun Home(
    navController: NavHostController, viewModel: HomeViewModel = hiltViewModel()
) {

    LocaleUtils.setLocale(LocalContext.current, Constants.USER_LANGUAGE)

    LaunchedEffect(true) {
        refreshDataFromServer(viewModel = viewModel)
    }

    SwipeRefreshSection(viewModel = viewModel, navController = navController)
}


@Composable
private fun SwipeRefreshSection(viewModel: HomeViewModel, navController: NavHostController) {

    val refreshScope = rememberCoroutineScope()
    val swipeRefreshState = rememberSwipeRefreshState(isRefreshing = false)


    SwipeRefresh(
        state = swipeRefreshState,
        onRefresh = {
            refreshScope.launch {
                refreshDataFromServer(viewModel)
            }
        },
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 60.dp)
        ) {
            item { SearchBarSection() }
            item { TopSliderSection() }
            item { ShowCaseSection(navController = navController) }
            item { AmazingOfferSection() }
            item { ProposalCardSection() }
            item { SuperMarketOfferSection() }
            item { CategoryListSection() }
            item { CenterBannerSection(1) }
            item { BestSellerOfferSection() }
            item { CenterBannerSection(2) }
            item { MostFavoriteProductSection() }
            item { CenterBannerSection(3) }
            item { MostVisitedOfferSection() }
            item { CenterBannerSection(4) }
            item { CenterBannerSection(5) }
            item { MostDiscountedOfferSection() }


        }
    }

}


private fun refreshDataFromServer(viewModel: HomeViewModel) {
    viewModel.getAllDataFromServer()
}