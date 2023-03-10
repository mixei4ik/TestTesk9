package com.example.testtesk9.data.models

data class FlashSaleProductApi(
    val flash_sale: List<FlashSale>
)

data class FlashSale(
    val category: String,
    val name: String,
    val price: Double,
    val discount: Int,
    val image_url: String
)