package com.example.testtesk9.domain

import com.example.testtesk9.domain.models.FlashSaleProductModel
import com.example.testtesk9.domain.models.LatestProductModel

interface ShopRepository {

    suspend fun getLatestProduct(): List<LatestProductModel>

    suspend fun getFlashSaleProduct(): List<FlashSaleProductModel>
}