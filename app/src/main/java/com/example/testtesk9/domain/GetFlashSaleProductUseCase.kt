package com.example.testtesk9.domain

import com.example.testtesk9.common.Resource
import com.example.testtesk9.domain.models.FlashSaleProductModel
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetFlashSaleProductUseCase @Inject constructor(
    private val repository: ShopRepository
) {

    suspend fun getFlashSaleProduct(): Resource<List<FlashSaleProductModel>> {
        return try {
            val flashSaleProduct = repository.getFlashSaleProduct()
            Resource.Success(flashSaleProduct)
        } catch (e: HttpException) {
            Resource.Error(e.localizedMessage ?: "An unexpected error occured")
        } catch (e: IOException) {
            Resource.Error("Couldn't reach server. Check your internet connection")
        }
    }
}