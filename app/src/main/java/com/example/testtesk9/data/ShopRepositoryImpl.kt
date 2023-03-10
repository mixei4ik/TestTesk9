package com.example.testtesk9.data

import com.example.testtesk9.domain.ShopRepository
import com.example.testtesk9.domain.models.FlashSaleProduct
import com.example.testtesk9.domain.models.LatestProduct
import javax.inject.Inject

class ShopRepositoryImpl @Inject constructor(
    private val shopApi: ShopApiService
) : ShopRepository {
    override suspend fun getLatestProduct(): List<LatestProduct> {
        val latestList = mutableListOf<LatestProduct>()
        shopApi.getListLatestProduct().latest
            .forEach {
                latestList.add(
                    LatestProduct(
                        category = it.category,
                        name = it.name,
                        price = it.price,
                        image_url = it.image_url
                    )
                )
            }
        return latestList
    }

    override suspend fun getFlashSaleProduct(): List<FlashSaleProduct> {
        val flashSaleList = mutableListOf<FlashSaleProduct>()
        shopApi.getFlashSaleProduct().flash_sale
            .forEach {
                flashSaleList.add(
                    FlashSaleProduct(
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