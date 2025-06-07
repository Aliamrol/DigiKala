package com.example.digikala.repository

import com.example.digikala.data.model.home.AmazingItem
import com.example.digikala.data.model.home.MainCategory
import com.example.digikala.data.model.home.Slider
import com.example.digikala.data.model.home.StoreProduct
import com.example.digikala.data.remote.BaseApiResponse
import com.example.digikala.data.remote.HomeApiInterface
import com.example.digikala.data.remote.NetworkResults
import javax.inject.Inject

class HomeRepository @Inject constructor(
    private val api: HomeApiInterface
) : BaseApiResponse() {

    suspend fun getSlider(): NetworkResults<List<Slider>> = safeApiCall {
        api.getSlider()
    }

    suspend fun getAmazingItems(): NetworkResults<List<AmazingItem>> = safeApiCall {
        api.getAmazingItems()
    }

    suspend fun getSuperMarketAmazingItems(): NetworkResults<List<AmazingItem>> = safeApiCall {
        api.getSuperMarketAmazingProducts()
    }

    suspend fun getProposalBanners(): NetworkResults<List<Slider>> = safeApiCall {
        api.getProposalBanners()
    }

    suspend fun getCategories(): NetworkResults<List<MainCategory>> = safeApiCall {
        api.getCategories()
    }

    suspend fun getCenterBanners(): NetworkResults<List<Slider>> = safeApiCall {
        api.getCenterBanners()
    }

    suspend fun getBestSellerItems(): NetworkResults<List<StoreProduct>> = safeApiCall {
        api.getBestSellerItems()
    }

}