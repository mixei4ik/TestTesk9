package com.example.testtesk9.data

import com.example.testtesk9.data.models.FlashSaleProductApi
import com.example.testtesk9.data.models.LatestProductApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ShopApiService @Inject constructor(
    private val apiShop: ShopApiClient
) {

    suspend fun getListLatestProduct(): LatestProductApi {
        return withContext(Dispatchers.IO) {
            apiShop.getListLatestProduct()
        }
    }

    suspend fun getFlashSaleProduct(): FlashSaleProductApi {
        return withContext(Dispatchers.IO) {
            apiShop.getFlashSaleProduct()
        }
    }
}