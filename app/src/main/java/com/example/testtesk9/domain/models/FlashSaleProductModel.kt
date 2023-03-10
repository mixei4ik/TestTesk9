package com.example.testtesk9.domain.models

data class FlashSaleProductModel(
    val category: String,
    val name: String,
    val price: Double,
    val discount: Int,
    val image_url: String
)