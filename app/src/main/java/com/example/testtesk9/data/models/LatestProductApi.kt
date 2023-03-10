package com.example.testtesk9.data.models

data class LatestProductApi(
    val latest: List<Latest>
)

data class Latest(
    val category: String,
    val name: String,
    val price: Int,
    val image_url: String
)