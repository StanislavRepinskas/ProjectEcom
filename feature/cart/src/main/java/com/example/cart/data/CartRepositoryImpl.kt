package com.example.cart.data

import com.example.cart_api.CartProductCount
import com.example.cart_api.CartRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class CartRepositoryImpl @Inject constructor() : CartRepository {

    private val cartUpdateFlow = MutableStateFlow<Long>(0)
    private val map = mutableMapOf<Long, Int>()

    override suspend fun add(productId: Long) {
        val count = map[productId] ?: 0
        map[productId] = count + 1
        cartUpdateFlow.value = System.currentTimeMillis()
    }

    override suspend fun remove(productId: Long) {
        val count = map[productId] ?: 0
        if (count > 0) {
            map[productId] = count - 1
        }
        cartUpdateFlow.value = System.currentTimeMillis()
    }

    override fun getProductCount(productId: Long): Int {
        return map[productId] ?: 0
    }

    override fun getAllProductCount(): List<CartProductCount> {
        return map.map {
            CartProductCount(
                productId = it.key,
                count = it.value
            )
        }.filter { it.count > 0 }
    }

    override fun getCartUpdateFlow(): Flow<Long> = cartUpdateFlow
}