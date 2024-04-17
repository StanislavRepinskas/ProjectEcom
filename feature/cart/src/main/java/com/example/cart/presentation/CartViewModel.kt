package com.example.cart.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.cart_api.CartRepository
import com.example.core.ui.ProductItemState
import com.example.product_api.Product
import com.example.product_api.ProductNavigation
import com.example.product_api.ProductsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CartViewModel(
    private val productsRepository: ProductsRepository,
    private val cartRepository: CartRepository,
    private val productNavigation: ProductNavigation
) : ViewModel() {

    private var products: List<Product> = emptyList()

    private val _productsState = MutableStateFlow<List<ProductState>>(emptyList())
    val productsState = _productsState.asStateFlow()

    init {
        viewModelScope.launch {
            loadProducts()
            updateState()
        }

        viewModelScope.launch {
            cartRepository.getCartUpdateFlow().collect {
                if (it > 0) {
                    loadProducts()
                    updateState()
                }
            }
        }
    }

    private suspend fun loadProducts() {
        withContext(Dispatchers.IO) {
            val cartProducts = cartRepository.getAllProductCount()
            products = productsRepository.getProducts(cartProducts.map { it.productId })
        }
    }

    fun onProductClick(navController: NavController, product: Product) {
        productNavigation.openProduct(navController, product)
    }

    fun onProductPlusClick(product: Product) {
        viewModelScope.launch {
            cartRepository.add(product.id)
        }
    }

    fun onProductMinusClick(product: Product) {
        viewModelScope.launch {
            cartRepository.remove(product.id)
        }
    }

    private fun updateState() {
        _productsState.value = products.map {
            ProductState(
                product = it,
                productItemState = ProductItemState(
                    name = it.name,
                    cartCount = cartRepository.getProductCount(it.id)
                )
            )
        }
    }

    data class ProductState(
        val product: Product,
        val productItemState: ProductItemState
    )

    class Factory @Inject constructor(
        private val productsRepository: ProductsRepository,
        private val cartRepository: CartRepository,
        private val productNavigation: ProductNavigation
    ) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return CartViewModel(productsRepository, cartRepository, productNavigation) as T
        }
    }
}