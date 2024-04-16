package com.example.catalog.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.catalog.domain.CatalogRepository
import com.example.core.domain.model.Product
import com.example.product_api.ProductNavigation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CatalogViewModel(
    private val catalogRepository: CatalogRepository,
    private val productNavigation: ProductNavigation
) : ViewModel() {

    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products = _products.asStateFlow()

    init {
        viewModelScope.launch {
            _products.value = withContext(Dispatchers.IO) {
                catalogRepository.getProducts()
            }
        }
    }

    fun onProductClick(product: Product) {
        productNavigation.openProduct(product)
    }

    class Factory @Inject constructor(
        private val catalogRepository: CatalogRepository,
        private val productNavigation: ProductNavigation
    ) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return CatalogViewModel(catalogRepository, productNavigation) as T
        }
    }
}