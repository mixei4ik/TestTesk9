package com.example.testtesk9.domain

import com.example.testtesk9.domain.models.FlashSaleProduct
import com.example.testtesk9.domain.models.LatestProduct

interface ShopRepository {

    suspend fun getLatestProduct(): List<LatestProduct>

    suspend fun getFlashSaleProduct(): List<FlashSaleProduct>
}