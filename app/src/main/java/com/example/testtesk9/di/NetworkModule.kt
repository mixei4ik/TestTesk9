package com.example.testtesk9.di

import com.example.testtesk9.common.Constants.BASE_URL
import com.example.testtesk9.data.ShopApiClient
import com.example.testtesk9.data.ShopApiService
import com.example.testtesk9.data.ShopRepositoryImpl
import com.example.testtesk9.domain.ShopRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(client)
            .build()
    }

    @Singleton
    @Provides
    fun provideShopApiClient(retrofit: Retrofit): ShopApiClient {
        return retrofit.create(ShopApiClient::class.java)
    }

    @Singleton
    @Provides
    fun provideShopRepository(shopApi: ShopApiService): ShopRepository {
        return ShopRepositoryImpl(shopApi)
    }
}