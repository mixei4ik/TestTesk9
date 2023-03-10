package com.example.testtesk9.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testtesk9.common.Resource
import com.example.testtesk9.domain.GetFlashSaleProductUseCase
import com.example.testtesk9.domain.GetLatestProductUseCase
import com.example.testtesk9.domain.models.FlashSaleProductModel
import com.example.testtesk9.domain.models.LatestProductModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShopViewModel @Inject constructor(
    private val getLatestProductUseCase: GetLatestProductUseCase,
    private val getFlashSaleProductUseCase: GetFlashSaleProductUseCase
) : ViewModel() {

    private val _latestProductItems = MutableLiveData<Resource<List<LatestProductModel>>>()
    val latestProductItems: LiveData<Resource<List<LatestProductModel>>> = _latestProductItems

    private val _flashSaleProductItems = MutableLiveData<Resource<List<FlashSaleProductModel>>>()
    val flashSaleProductItems: LiveData<Resource<List<FlashSaleProductModel>>> = _flashSaleProductItems

    init {
        getLatestProduct()
        getFlashSaleProduct()
    }

    private fun getFlashSaleProduct() {
        _flashSaleProductItems.value = Resource.Loading()
        viewModelScope.launch {
            _flashSaleProductItems.value = getFlashSaleProductUseCase.getFlashSaleProduct()
        }
    }

    private fun getLatestProduct() {
        _latestProductItems.value = Resource.Loading()
        viewModelScope.launch {
            _latestProductItems.value = getLatestProductUseCase.getLatestProduct()
        }
    }


}