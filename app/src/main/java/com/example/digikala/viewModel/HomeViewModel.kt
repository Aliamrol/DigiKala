package com.example.digikala.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.digikala.data.model.home.AmazingItem
import com.example.digikala.data.model.home.MainCategory
import com.example.digikala.data.model.home.Slider
import com.example.digikala.data.model.home.StoreProduct
import com.example.digikala.data.remote.NetworkResults
import com.example.digikala.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel

class HomeViewModel @Inject constructor(
    private val repository: HomeRepository
) : ViewModel() {

    val slider = MutableStateFlow<NetworkResults<List<Slider>>>(NetworkResults.Loading())
    val amazingItems = MutableStateFlow<NetworkResults<List<AmazingItem>>>(NetworkResults.Loading())
    val superMarketItems =
        MutableStateFlow<NetworkResults<List<AmazingItem>>>(NetworkResults.Loading())
    val banners = MutableStateFlow<NetworkResults<List<Slider>>>(NetworkResults.Loading())
    val categories = MutableStateFlow<NetworkResults<List<MainCategory>>>(NetworkResults.Loading())
    val centerBannerItems = MutableStateFlow<NetworkResults<List<Slider>>>(NetworkResults.Loading())
    val bestSellerItems =
        MutableStateFlow<NetworkResults<List<StoreProduct>>>(NetworkResults.Loading())
    val mostVisitedItems =
        MutableStateFlow<NetworkResults<List<StoreProduct>>>(NetworkResults.Loading())

    fun getAllDataFromServer() {
        viewModelScope.launch {
            launch {
                slider.emit(repository.getSlider())
            }
            launch {
                amazingItems.emit(repository.getAmazingItems())
            }

            launch {
                superMarketItems.emit(repository.getSuperMarketAmazingItems())
            }

            launch {
                banners.emit(repository.getProposalBanners())
            }

            launch {
                categories.emit(repository.getCategories())
            }

            launch {
                centerBannerItems.emit(repository.getCenterBanners())
            }

            launch {
                bestSellerItems.emit(repository.getBestSellerItems())
            }

            launch {
                mostVisitedItems.emit(repository.getMostVisitedItems())
            }

        }
    }


    fun getSlider() {
        viewModelScope.launch {
            slider.emit(repository.getSlider())
        }
    }

    fun getAmazingItems() {
        viewModelScope.launch {
            amazingItems.emit(repository.getAmazingItems())
        }
    }

}