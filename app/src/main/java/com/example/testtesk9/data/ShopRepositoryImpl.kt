package com.example.testtesk9.data

import com.example.testtesk9.domain.ShopRepository
import com.example.testtesk9.domain.models.FlashSaleProductModel
import com.example.testtesk9.domain.models.LatestProductModel
import javax.inject.Inject

class ShopRepositoryImpl @Inject constructor(
    private val shopApi: ShopApiService
) : ShopRepository {
    override suspend fun getLatestProduct(): List<LatestProductModel> {
        val latestList = mutableListOf<LatestProductModel>()
        shopApi.getListLatestProduct().latest
            .forEach {
                latestList.add(
                    LatestProductModel(
                        category = it.category,
                        name = it.name,
                        price = it.price,
                        image_url = it.image_url
                    )
                )
            }
        return latestList
    }

    override suspend fun getFlashSaleProduct(): List<FlashSaleProductModel> {
        val flashSaleList = mutableListOf<FlashSaleProductModel>()
        shopApi.getFlashSaleProduct().flash_sale
            .forEach {
                flashSaleList.add(
                    FlashSaleProductModel(
                        category = it.category,
                        name = it.name,
                        price = it.price,
                        discount = it.discount,
                        image_url = it.image_url
                    )
                )
            }
        return flashSaleList
    }
}