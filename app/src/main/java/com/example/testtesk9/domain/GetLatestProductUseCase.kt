package com.example.testtesk9.domain

import com.example.testtesk9.common.Resource
import com.example.testtesk9.domain.models.LatestProduct
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetLatestProductUseCase @Inject constructor(
    private val repository: ShopRepository
) {

    suspend fun getLatestProduct(): Resource<List<LatestProduct>> {
        return try {
            val latestProduct = repository.getLatestProduct()
            Resource.Success(latestProduct)
        } catch (e: HttpException) {
            Resource.Error(e.localizedMessage ?: "An unexpected error occured")
        } catch (e: IOException) {
            Resource.Error("Couldn't reach server. Check your internet connection")
        }
    }
}