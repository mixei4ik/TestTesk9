package com.example.testtesk9.data

import com.example.testtesk9.data.models.FlashSaleProductApi
import com.example.testtesk9.data.models.LatestProductApi
import retrofit2.http.GET

interface ShopApiClient {

    @GET("/cc0071a1-f06e-48fa-9e90-b1c2a61eaca7")
    suspend fun getListLatestProduct(): LatestProductApi

    @GET("/a9ceeb6e-416d-4352-bde6-2203416576ac")
    suspend fun getFlashSaleProduct(): FlashSaleProductApi
}