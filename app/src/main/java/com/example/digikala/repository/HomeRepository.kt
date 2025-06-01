package com.example.digikala.repository

import com.example.digikala.data.remote.BaseApiResponse
import com.example.digikala.data.remote.HomeApiInterface
import javax.inject.Inject

class HomeRepository @Inject constructor(
    private val api: HomeApiInterface
) : BaseApiResponse() {

}