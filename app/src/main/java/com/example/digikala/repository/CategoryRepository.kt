package com.example.digikala.repository

import com.example.digikala.data.model.category.SubCategory
import com.example.digikala.data.remote.BaseApiResponse
import com.example.digikala.data.remote.CategoryApiInterface
import com.example.digikala.data.remote.NetworkResults
import javax.inject.Inject

class CategoryRepository @Inject constructor(
    private val api: CategoryApiInterface
) : BaseApiResponse() {

    suspend fun getSubCategories(): NetworkResults<SubCategory> =
        safeApiCall {
            api.getSubCategories()
        }



}